package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.security.auth.login.FailedLoginException;

public class TC_05_SearchResultPage extends BaseClass {

    IndexPage indexPage;
    SearchResultPage searchResultPage;

    @Test
    public void productAvailibilityTest()
    {
        indexPage = new IndexPage();
        searchResultPage = indexPage.searchProduct("dress");
        if(searchResultPage!= null) {
            boolean result = searchResultPage.isProductAvailable();
            Assert.assertTrue(result);
        }
        else{
            System.out.println("Provide product value");
        }

    }
}
