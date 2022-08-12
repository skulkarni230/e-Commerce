package com.mystore.actionclass;

import com.mystore.base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Action extends BaseClass {



    public static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

    public static void scrollByVisibilityofElement(WebDriver driver, WebElement ele)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ele);
    }

    public static void click (WebDriver driver,WebElement locator)
    {
        Actions act = new Actions(driver);
        act.moveToElement(locator).click().build().perform();
    }

    public static boolean findElement(WebDriver driver,WebElement ele) {
        boolean flag = false;
        try {
            ele.isDisplayed();
            flag = true;
        } catch (Exception e) {
            flag = false;
        } finally {
            if (flag) {
                System.out.println("Successfully found Element");
            } else {
                System.out.println("Unable to Locate Element");
            }
        }
        return flag;
    }

    public static boolean isDisplayed(WebDriver driver,WebElement ele)
    {
        boolean flag = false;
        flag = findElement(driver, ele);
        if (flag){
            flag = true;
            if (flag){
                System.out.println("Element is Displayed");
            }
            else {
                System.out.println("Element is not Displayed");
            }
        }else{
            System.out.println("Element not Displayed");
        }
        return flag;
    }

    public static boolean isSelected(WebDriver driver,WebElement ele)
    {
        boolean flag = false;
        flag = findElement(driver,ele);
        if(flag){
            flag = ele.isSelected();
            if (flag){
                System.out.println("Element is Selected");
            }
            else {
                System.out.println("Element is not Selected");
            }
        }else{
            System.out.println("Not Selected");
        }
        return flag;
    }

    public static boolean isEnabled(WebDriver driver,WebElement ele)
    {
        boolean flag = false;
        flag = findElement(driver,ele);
        if(flag){
            flag = ele.isEnabled();
            if (flag){
                System.out.println("Element is Enabled");
            }
            else {
                System.out.println("Element is not Enabled");
            }
        }else{
            System.out.println("Not Enabled");
        }
        return flag;
    }

    public static boolean type(WebElement ele, String text)
    {
        boolean flag = false;
        try{
            flag = ele.isDisplayed();
            ele.clear();
            ele.sendKeys(text);
            flag = true;
        }catch(Exception e){
            System.out.println("Location not Found");
            flag = false;
        }finally{
            if (flag){
                System.out.println("Successfully Entered Value");
            }
            else{
                System.out.println("Unable to Entered Value");
            }
        }
        return flag;
    }

    public static void implicitWait(WebDriver driver, int timeout)
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void explicitWait(WebDriver driver, WebElement ele, int timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public static boolean alert(WebDriver driver)
    {
        boolean flag = false;

        try{
            driver.switchTo().alert().accept();
            flag = true;
        }catch(NoAlertPresentException e){
            e.printStackTrace();
        }finally {
            if(!flag){
                System.out.println("Alert Handled Successfully");
            }
            else{
                System.out.println("No Alert Present");
            }
        }
        return flag;
    }

    public static void launchURL(WebDriver driver, String url)
    {
        boolean flag = false;
        try{
            driver.navigate().to(url);
            flag = true;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (flag){
                System.out.println("Successfully launched " +url);
            }
            else {
                System.out.println("Not able to launch the given URL");
            }
        }
    }

    public static void selectItemByValue(WebDriver driver,WebElement ele,String value)
    {
        boolean flag = false;
        try {
            Select s = new Select(ele);
            s.selectByVisibleText(value);
            flag = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            if (flag){
                System.out.println("Value Selected");
            }
            else{
                System.out.println("Invalid Value");
            }
        }

    }

    public static void captureScreen(WebDriver driver, String tname) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+ "-"+ timeStamp +".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken for failed testcase");
    }
}

