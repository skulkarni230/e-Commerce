package com.mystore.pageobject;

import com.mystore.actionclass.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends BaseClass {

    public ShippingPage()
    {
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement termsCheckBox;

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']/button")
    WebElement checkoutBtn;


    public void agreeTerms()
    {
        Action.click(getDriver(),termsCheckBox);
    }
    public PaymentPage clickCheckoutBtn()
    {
        Action.click(getDriver(),checkoutBtn);
        return new PaymentPage();
    }
}
