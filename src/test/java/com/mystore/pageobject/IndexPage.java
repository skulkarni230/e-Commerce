package com.mystore.pageobject;

import com.mystore.actionclass.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BaseClass {

    public IndexPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='login']")
    WebElement signInBtn;

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    WebElement logo;

    @FindBy(xpath = "//form[@id='searchbox']/input[4]")
    WebElement searchProductBox;

    @FindBy(xpath = "//form[@id='searchbox']/button")
    WebElement searchBtn;

    /*
     * Contains all the locators and methods for Index page
     * The object of Login page is created and returned in this class
     * */
    public LoginPage clickOnSignIn() {
        Action.click(getDriver(), signInBtn);
        return new LoginPage();
    }

    public boolean validateLogo() {
        return Action.isDisplayed(getDriver(), logo);
    }

    public String getTitle() {
        String title = getDriver().getTitle();
        return title;
    }

    public SearchResultPage searchProduct(String product) {
        boolean flag;
        if (product == "") {
            flag  = false;
        } else {
            flag = true;
        }
        if (!flag){
            return null;
        }else{
            Action.type(searchProductBox, product);
            Action.click(getDriver(), searchBtn);
            return new SearchResultPage();
        }

    }
}
