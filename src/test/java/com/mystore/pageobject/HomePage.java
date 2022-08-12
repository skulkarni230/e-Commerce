package com.mystore.pageobject;

import com.mystore.actionclass.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }


    @FindBy(xpath = "//div[@id='center_column']/div/div[2]/ul")
    WebElement myWishListBtn;

    @FindBy(xpath = "//div[@id='center_column']/div/div[1]/ul/li[1]/a")
    WebElement orderHistoryBtn;

    public boolean validateWishList()
    {
        return Action.isDisplayed(getDriver(),myWishListBtn);
    }

    public boolean validateHistory()
    {
        return Action.isDisplayed(getDriver(),orderHistoryBtn);
    }

}
