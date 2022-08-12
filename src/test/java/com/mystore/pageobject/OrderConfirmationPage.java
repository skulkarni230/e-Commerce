package com.mystore.pageobject;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderConfirmationPage extends BaseClass {
    public OrderConfirmationPage()

    {
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy (xpath = "//p[@class='cheque-indent']/strong")
    WebElement orderCompleteText;

    public boolean validateOrderConfirmation()
    {
        String confirm = orderCompleteText.getText();
        Assert.assertEquals(confirm,"Your order on My Store is complete.");
        return true;
    }
}
