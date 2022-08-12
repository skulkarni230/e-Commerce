package com.mystore.testcases;

import com.mystore.actionclass.Action;
import com.mystore.base.BaseClass;
import com.mystore.pageobject.AddToCart;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.OrderPage;
import com.mystore.pageobject.SearchResultPage;
import org.testng.annotations.Test;

public class TC_07_OrderPage extends BaseClass {
    IndexPage indexPage;
    SearchResultPage searchResultPage;
    AddToCart addToCartPage;
    OrderPage orderPage;

    @Test
    public void verifyTotalPrice() throws InterruptedException {
        indexPage = new IndexPage();
        searchResultPage = indexPage.searchProduct("t-shirt");
        if(searchResultPage!= null) {
            addToCartPage = searchResultPage.clickOnProduct();
            addToCartPage.enterProductQuantity("2");
            addToCartPage.selectSize("L");
            addToCartPage.clickAddToCartBtn();
            orderPage=addToCartPage.clickOnCheckout();
            Thread.sleep(2000L);
            System.out.println(orderPage.getUnitPrice());
            System.out.println(orderPage.getTotalPrice());

        }
    }
}
