package com.mystore.pageobject;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    public LoginPage()
    {
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//form[@id='login_form']/div[1]/div[1]/input")
    WebElement emailBox;

    @FindBy(xpath = "//form[@id='login_form']/div[1]/div[2]/span/input")
    WebElement passwordBox;

    @FindBy(xpath = "//form[@id='login_form']/div[1]/p[1]/a")
    WebElement forgotPasswordLink;

    @FindBy(xpath = "//form[@id='login_form']/div[1]/p[2]/button")
    WebElement signInBtn;

    @FindBy(xpath = "//form[@id='create-account_form']/div/div[2]/input")
    WebElement createAccountEmail;

    @FindBy(xpath = "//form[@id='create-account_form']/div/div[3]/button")
    WebElement createAccountBtn;

    public HomePage signIn(String email, String password)
    {
        emailBox.clear();
        emailBox.sendKeys(email);
        passwordBox.clear();
        passwordBox.sendKeys(password);
        signInBtn.click();

        if(getDriver().getPageSource().contains("There is 1 error")){
            System.out.println("Sign In Failed");
        }
        return new HomePage();

    }

    /*
    * This method should be called when user does not login first
    * and tries to checkout directly from home page
    * This method will land user to addresspage hence returning the address oage object
    * */
    public AddressPage signInOne(String email, String password)
    {
        emailBox.clear();
        emailBox.sendKeys(email);
        passwordBox.clear();
        passwordBox.sendKeys(password);
        signInBtn.click();

        if(getDriver().getPageSource().contains("There is 1 error")){
            System.out.println("Sign In Failed");
        }
        return new AddressPage();

    }

    public AccountCreation createAccount(String email)
    {
        createAccountEmail.clear();
        createAccountEmail.sendKeys(email);
        createAccountBtn.click();
        if (getDriver().getPageSource().contains("An account using this email address has already been registered. Please enter a valid password or request a new one. "))
        {
            System.out.println("Account Creation Failed");
        }
        return new AccountCreation();
    }

}
