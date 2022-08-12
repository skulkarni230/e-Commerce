package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.IndexPage;
import com.mystore.utils.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_01_IndexPage extends BaseClass {

    IndexPage indexPage;

    @Test
    public void verifyLogo()
    {
        Log.startTestCase("Verify Logo");
        indexPage = new IndexPage();
        boolean result = indexPage.validateLogo();
        Assert.assertTrue(result);
        Log.info("Logo verified successfully");
        Log.endTestCase("Verify Logo");
    }
    @Test
    public void verifyTitle()
    {
        Log.startTestCase("Verify Title");
        indexPage = new IndexPage();
        String title = indexPage.getTitle();
        Assert.assertEquals(title,"My Store");
        Log.info("Title verified successfully");
        Log.endTestCase("Verify Logo");
    }



}
