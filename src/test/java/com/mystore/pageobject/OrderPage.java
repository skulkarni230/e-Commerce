package com.mystore.pageobject;

import com.mystore.actionclass.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends BaseClass {

    public OrderPage()
    {
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//td[@class='cart_unit']/span")
    WebElement unitPrice;

    @FindBy(xpath = "//td[@class='total_price_container text-right']/span/../following-sibling::td/span")
    WebElement totalPrice;

    @FindBy(xpath = "//*[text()='Proceed to checkout']")
    WebElement proceedCheckoutBtn;

    @FindBy(xpath = "//div[@id='center_column']/h1/span")
    WebElement productCount;


    /*
    * This method will remove $ special char from price and convert that int to double
    * */
    public double getUnitPrice()
    {
        //Action.explicitWait(driver,productCount,10);
        Action.scrollByVisibilityofElement(getDriver(),productCount);
        String unitPriceText = unitPrice.getText();
        String unit = unitPriceText.replaceAll("[^a-zA-Z0-9]","");
        double finalUnit = Double.parseDouble(unit);
        return finalUnit/100;
    }

    public double getTotalPrice()
    {
        String totalPriceText = totalPrice.getText();
        String total = totalPriceText.replaceAll("[^a-zA-Z0-9]","");
        double finalTotalUnit = Double.parseDouble(total);
        return finalTotalUnit/100;
    }

    public LoginPage clickCheckoutBtn()
    {
        Action.scrollByVisibilityofElement(getDriver(),unitPrice);
        Action.click(getDriver(),proceedCheckoutBtn);
        return new LoginPage();
    }



}
