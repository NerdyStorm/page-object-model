package com.techfios.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPage {
    
    WebDriver driver;
    
    public DashboardPage(WebDriver driver){
        this.driver = driver; 
        PageFactory.initElements(driver, this);
    }

    //WebElement Library
    @FindBy (how = How.XPATH, using = "//span[text() = 'Dashboard']") WebElement dashboardButton;
    @FindBy (how = How.XPATH, using = "//h2[contains(text(), 'Dashboard')]") WebElement pageTitle;
    @FindBy (how = How.XPATH, using = "//span[text() = 'Customers']") WebElement customersButton;
    @FindBy (how = How.XPATH, using = "//a[contains(text(), 'Add Customer')]") WebElement addCustomers;

    public void clickOnDashboard(){
        dashboardButton.click();
    }
    public void verifyDashboard (){
       Assert.assertEquals("Dashboard", pageTitle.getText(), "Not on Dashboard Page!");
    }

    public void clickOnCustomers (){
        customersButton.click();
    }
    public void clickOnAddCustomers (){
        addCustomers.click();
    }

}
