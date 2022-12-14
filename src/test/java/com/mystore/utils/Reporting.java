package com.mystore.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mystore.actionclass.Action;
import com.mystore.base.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting extends TestListenerAdapter
{
    public ExtentSparkReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;

    public void onStart(ITestContext testContext)
    {
        //To generate timestamp for report
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String repName = "Test-Report-"+timeStamp+".html";
        //#Timestamp used in report name
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);


        extent = new ExtentReports();

        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("HostName", "Admin");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("user", "Admin");

        htmlReporter.config().setDocumentTitle("E-Commerce Project");
        htmlReporter.config().setReportName("Functional Test ");
        htmlReporter.config().setTheme(Theme.DARK);
    }

    public void onTestSuccess(ITestResult tr)
    {
        logger=extent.createTest(tr.getName());
        logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
    }

    public void onTestFailure(ITestResult tr)  {
        logger=extent.createTest(tr.getName());
        logger.fail(tr.getThrowable());
        logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

        try {
            Action.captureScreen(BaseClass.getDriver(),tr.getName());
        } catch (IOException e) {
            System.out.println("Not able to take screenshot");
        }
        String screenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+ tr.getName()+ "-" + Action.timeStamp +".png";

        File f = new File(screenshotPath);

        if(f.exists())
        {
            try {
                logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
            }
            catch(Exception e)
            {
                System.out.println("Not able to attach screenshot");
            }
        }

    }

    public void onTestSkipped(ITestResult tr)
    {
        logger=extent.createTest(tr.getName());
        logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
    }

    public void onFinish(ITestContext testContext)
    {
        extent.flush();
    }
}

