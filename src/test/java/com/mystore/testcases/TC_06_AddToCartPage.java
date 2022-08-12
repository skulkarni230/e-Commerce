package com.mystore.testcases;

import com.mystore.actionclass.Action;
import com.mystore.base.BaseClass;
import com.mystore.pageobject.AddToCart;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.OrderPage;
import com.mystore.pageobject.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_06_AddToCartPage extends BaseClass {
    IndexPage indexPage;
    SearchResultPage searchResultPage;
    AddToCart addToCartPage;


    @Test
    public void addToCartpage() throws InterruptedException {
        indexPage = new IndexPage();
        searchResultPage = indexPage.searchProduct("t-shirt");
        if(searchResultPage!= null) {
            addToCartPage = searchResultPage.clickOnProduct();
            addToCartPage.enterProductQuantity("2");
            addToCartPage.selectSize("M");
            addToCartPage.clickAddToCartBtn();
            Assert.assertTrue(addToCartPage.validateAddToCart());
        }
        else{
            System.out.println("Provide product value");
        }
    }

}
