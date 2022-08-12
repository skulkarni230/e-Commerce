package com.mystore.pageobject;

import com.mystore.actionclass.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BaseClass {

    public PaymentPage()
    {
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Please choose your payment method']")
    WebElement paymentMethodText;

    @FindBy(xpath = "//a[@class='bankwire']")
    WebElement payByBankWire;

    @FindBy(xpath = "//a[@class='cheque']")
    WebElement payByCheck;

    public OrderSummary clickPayByBankWire()
    {
        Action.click(getDriver(),payByBankWire);
        return new OrderSummary();
    }

    public OrderSummary clickPayByCheck()
    {
        Action.click(getDriver(),payByBankWire);
        return new OrderSummary();
    }



}
