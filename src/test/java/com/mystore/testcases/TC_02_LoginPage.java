package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.dataProviderArray;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_02_LoginPage extends BaseClass {

    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;
/*
*
* In the below method - clickOnSignIn method returns the object of login page
* and signIn method return the object of home page
*
* */
    @Test(dataProvider = "credentials", dataProviderClass = dataProviderArray.class)
    public void login(String username, String password){
        indexPage = new IndexPage();
        loginPage=indexPage.clickOnSignIn();
        homePage = loginPage.signIn(username,password);
        Assert.assertTrue(homePage.validateHistory());
    }

}
