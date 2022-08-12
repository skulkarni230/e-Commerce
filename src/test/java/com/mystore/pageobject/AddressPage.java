package com.mystore.pageobject;

import com.mystore.actionclass.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends BaseClass {

    public  AddressPage()

    {
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Proceed to checkout']")
    WebElement proceedToCheckout;

    public ShippingPage clickCheckoutBtn()
    {
        Action.click(getDriver(),proceedToCheckout);
        return new ShippingPage();
    }
}
