package com.techfios.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
//import java.util.List;
import java.util.List;

import com.techfios.page.AddCustomerPage;
import com.techfios.page.DashboardPage;
import com.techfios.page.LoginPage;
import com.techfios.util.BrowserFactory;
import com.techfios.util.ReadExcel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AddCustomerTest {
    WebDriver driver;
    public String username;
    public String password;

    @Test
    public void test(){

        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.init();

        FileInputStream fis;
        try {
            fis = new FileInputStream("Excel/xl2.xlsx");
            ReadExcel readExcel = new ReadExcel(fis); 
            LinkedHashMap<Integer, String[]> map = readExcel.returnAllDataInMapFormat();
            username = map.get(0)[0];
            password = map.get(0)[1];

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        DashboardPage dashboardPage = new DashboardPage(driver);

        //remove from this line to 60 before using automatic creator in line 66-80
        dashboardPage.verifyDashboard();
        dashboardPage.clickOnCustomers();
        dashboardPage.clickOnAddCustomers();

        //List<WebElement> company = driver.findElements(By.xpath("//select[@id='cid']//*"));
        
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.verifyAddCustomersPage();
        addCustomerPage.fillRandomData();
        addCustomerPage.selectCompany("Techfios");
        addCustomerPage.selectCountry("Algeria");
        addCustomerPage.submit();
        addCustomerPage.clickOnListCustomers();
        addCustomerPage.verifyListCustomersPage();
        //String data = addCustomerPage.readTableData(1, 3);
        //System.out.println(data);
        addCustomerPage.verifyUserData("Md Hossain", 10); //Checks first 10 rows for text "Md Hossain", after which it runs the Assertion if it's found


        /*
        int i = 0;
        while (i<1000){
        dashboardPage.clickOnDashboard();
        dashboardPage.verifyDashboard();
        dashboardPage.clickOnCustomers();
        dashboardPage.clickOnAddCustomers();

        //List<WebElement> company = driver.findElements(By.xpath("//select[@id='cid']//*"));
        
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.fillRandomData();
        addCustomerPage.selectCompany("Techfios");
        addCustomerPage.selectCountry("Bangladesh");
        addCustomerPage.submit();
            i++;
        }*/
        

        //addCustomerPage
        

    }

    @AfterMethod
    public void tearDown(){
        try {
            Thread.sleep(5000);
            driver.quit();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
