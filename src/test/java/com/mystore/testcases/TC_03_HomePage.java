package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import org.testng.Assert;

public class TC_03_HomePage extends BaseClass {

    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;

    public void wishListTest(){
        indexPage = new IndexPage();
        loginPage=indexPage.clickOnSignIn();
        homePage = loginPage.signIn(prop.getProperty("username"),prop.getProperty("password"));
        Assert.assertTrue(homePage.validateWishList());
    }
    public void orderHistoryTest(){
        indexPage = new IndexPage();
        loginPage=indexPage.clickOnSignIn();
        homePage = loginPage.signIn(prop.getProperty("username"),prop.getProperty("password"));
        Assert.assertTrue(homePage.validateHistory());
    }

}
