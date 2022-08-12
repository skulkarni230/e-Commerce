package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_08_e2e extends BaseClass {

    IndexPage indexPage;
    SearchResultPage searchResultPage;
    AddToCart addToCartPage;
    OrderPage orderPage;
    LoginPage loginPage;
    AddressPage addressPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;
    OrderSummary orderSummary;
    OrderConfirmationPage orderConfirm;

    @Test
    public void endToEndTest()  {
        indexPage = new IndexPage();
        searchResultPage = indexPage.searchProduct("t-shirt");
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.enterProductQuantity("2");
        addToCartPage.selectSize("L");
        addToCartPage.clickAddToCartBtn();
        orderPage=addToCartPage.clickOnCheckout();
        //Thread.sleep(2000L);
        loginPage = orderPage.clickCheckoutBtn();
        addressPage = loginPage.signInOne("admin@xyz.com","admin@123");
        shippingPage = addressPage.clickCheckoutBtn();
        shippingPage.agreeTerms();
        paymentPage = shippingPage.clickCheckoutBtn();
        orderSummary = paymentPage.clickPayByBankWire();
        orderConfirm = orderSummary.clickConfirmOrder();
        Assert.assertTrue(orderConfirm.validateOrderConfirmation());


    }
}
