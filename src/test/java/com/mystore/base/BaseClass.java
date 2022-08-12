package com.mystore.base;

import com.mystore.actionclass.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/*
* This is base class contain all the common methods
*
* */
public class BaseClass {

    public static Properties prop;
    //public static WebDriver driver
    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
/*
* this class will read the basic information like url,browser,uname and pass from config.properties file
* */
    @BeforeTest
    public void loadConfig()  {

        try{
            prop = new Properties();
            System.out.println("Super constructor Invoked");
            FileInputStream fis = new FileInputStream("./Configurations/Config.properties");
            prop.load(fis);
            }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }


    }
    public static WebDriver getDriver()
    {
        return driver.get();
    }


    @Parameters("browser")
    @BeforeMethod
    public static void launchApp(String browserName)
    {
        //WebDriverManager.chromedriver().setup();
        //String browserName = prop.getProperty("browser");


        if(browserName.contains("chrome"))
        {
           // System.out.println(prop.getProperty("chromepath"));

            System.setProperty("webdriver.chrome.driver",prop.getProperty("chromepath"));
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());//for cross browser testing
            //driver = new ChromeDriver();//for regular run
        }
        else if (browserName.contains("firefox")){
            System.setProperty("webdriver.chrome.driver",prop.getProperty("firefoxpath"));
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());//for cross browser testing
            //driver = new FirefoxDriver();//for regular run
        }
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().get(prop.getProperty("url"));
        //getDriver().manage().timeouts().pageLoadTimeout()

        //driver.manage().window().maximize(); //regular browser run
        Action.implicitWait(getDriver(),10);
        //driver.get(prop.getProperty("url"));//regular browser run
    }

    @AfterMethod
    public void tearDown()

    {
        getDriver().quit();
    }

    @BeforeSuite
    public void beforeSuite(){
        DOMConfigurator.configure("log4j.xml");
    }


}
