package com.mystore.dataprovider;

import com.mystore.utils.XLUtility;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class dataProviderArray {

    @DataProvider(name = "credentials")
    public Object[][] getLoginCredentialsData() throws IOException {
        String path = "./\\src\\test\\java\\com\\mystore\\resources\\E-Commerce.xlsx";
        XLUtility xlutil = new XLUtility(path);

        int rowNum = xlutil.getRowCount("Credentials");

        int colCount = xlutil.getCellCount("Credentials", 1);


        String logindata[][] = new String[rowNum][colCount];

        for (int i = 1; i <= rowNum; i++) {

            for (int j = 0; j < colCount; j++) {

                logindata[i - 1][j] = xlutil.getCellData("Credentials", i, j);

            }
        }
        return logindata;
    }

}
