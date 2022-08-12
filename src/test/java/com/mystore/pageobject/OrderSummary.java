package com.mystore.pageobject;

import com.mystore.actionclass.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummary extends BaseClass {
    public OrderSummary()
    {
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='I confirm my order']")
    WebElement confirmOrderBtn;

    public OrderConfirmationPage clickConfirmOrder()
    {
        Action.click(getDriver(),confirmOrderBtn);
        return new OrderConfirmationPage();
    }
}
