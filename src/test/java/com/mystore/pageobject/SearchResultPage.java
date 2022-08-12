package com.mystore.pageobject;

import com.mystore.actionclass.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BaseClass {

    public SearchResultPage()
    {
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='top-pagination-content clearfix']/div[2]")
    WebElement productSearchResult;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    WebElement warningMessage;

    //*[@id='center_column']//img
    @FindBy(xpath = "//div[@class='right-block']/h5/a")
    WebElement productImage;


    public boolean isProductAvailable1() {
        boolean flag;
        boolean result = false;
        if(warningMessage.isDisplayed())
        {
            flag = false;
            System.out.println("Product Not Availible");
        }
        else{
            result = Action.isDisplayed(getDriver(),productSearchResult);
        }

            return result;

    }
    public boolean isProductAvailable() {
        boolean result = false;
        try {
            result = Action.isDisplayed(getDriver(), productSearchResult);
            if (!result) {
                System.out.println("Product not available");
            }
        }catch(Exception e){
            System.out.println("Product not available");
        }
        return result;
    }

    public AddToCart clickOnProduct()
    {
        Action.scrollByVisibilityofElement(getDriver(),productImage);
        Action.click(getDriver(),productImage);
        System.out.println("Clicked");
        Action.implicitWait(getDriver(),10);
        return new AddToCart();
    }

}
