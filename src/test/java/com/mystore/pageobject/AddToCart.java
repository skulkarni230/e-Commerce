package com.mystore.pageobject;

import com.mystore.actionclass.Action;
import com.mystore.base.BaseClass;
import freemarker.template.utility.NumberUtil;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart extends BaseClass {

    public AddToCart()
    {
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='quantity_wanted']")
    WebElement productQuantity;

    @FindBy(xpath = "//select[@id='group_1']")
    WebElement selectSize;

    @FindBy(xpath = "//*[text()='Add to cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//div[@class='clearfix']/div[1]/h2/i")
    WebElement successMsg;

    @FindBy(xpath = "//*[@title='Proceed to checkout']")
    WebElement checkoutBtn;



    public void enterProductQuantity(String quant)
    {

            System.out.println("Quant value is - " + quant);
            if ((quant != "" && quant != null) && (quant.matches("[0-9]+"))) {
                productQuantity.clear();
                productQuantity.sendKeys(quant);
            } else {
                System.out.println("Enter valid quantity value");
            }

    }
    public void selectSize(String value)
    {
        if((value != "" && value != null) && (value.contains("S") || value.contains("M") || value.contains("L"))){
        Action.scrollByVisibilityofElement(getDriver(),selectSize);
        Action.selectItemByValue(getDriver(),selectSize,value);
        System.out.println("Selected Size is : " +value);}
        else{
            System.out.println("Invalid Input for Size");
        }
    }
    public void clickAddToCartBtn()
    {
        Action.click(getDriver(),addToCartBtn);
        Action.explicitWait(getDriver(),successMsg,10);
    }

    public boolean validateAddToCart()
    {
        return Action.isDisplayed(getDriver(),successMsg);
    }

    public OrderPage clickOnCheckout()
    {
        Action.click(getDriver(),checkoutBtn);
        return new OrderPage();
    }

}
