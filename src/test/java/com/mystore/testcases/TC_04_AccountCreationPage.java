package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.AccountCreation;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_04_AccountCreationPage extends BaseClass {
    IndexPage indexPage;
    LoginPage loginPage;
    AccountCreation accountCreation;


    @Test
    public void accountCreationTest(){
        indexPage = new IndexPage();
        loginPage=indexPage.clickOnSignIn();
        accountCreation = loginPage.createAccount("july09@gmail.com");
        Assert.assertTrue(accountCreation.validateAccountCreationPage());
    }

}
