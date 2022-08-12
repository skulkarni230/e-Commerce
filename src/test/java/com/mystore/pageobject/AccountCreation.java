package com.mystore.pageobject;

import com.mystore.actionclass.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccountCreation extends BaseClass {

    public AccountCreation()
    {
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(xpath = "//form[@id='account-creation_form']/div[1]/h3")
    WebElement personalInfoTitle;

    public boolean validateAccountCreationPage()
    {
        return Action.isDisplayed(getDriver(),personalInfoTitle);
    }
}
