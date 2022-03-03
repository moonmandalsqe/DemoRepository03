package com.Bill.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Bill.CommonBrowsers.BrowsersList;
import com.Bill.DataDriven.DataDrivenClass;
import com.Bill.DataDriven.Data_pojo;
import com.Bill.ExtentReport.ExtentReportClass;
import com.Bill.Xpaths.XpathsUnique;


public class ImplementCases extends ExtentReportClass {
	
//	Use Xpaths here from 'XpathsUnique' class.
	public By User_Id = By.xpath(XpathsUnique.userId);
	public By pass_Id = By.xpath(XpathsUnique.passId);
	public By logIn = By.xpath(XpathsUnique.log_in);
	public By cross = By.xpath(XpathsUnique.cross_sign);
	public By Prod_Search = By.xpath(XpathsUnique.product_search);
	public By btn_search = By.xpath(XpathsUnique.search_button);
	public By flipkart_logo = By.xpath(XpathsUnique.flip_img);
	public By btn_srch = By.xpath(XpathsUnique.srch_btn);
	public By Prod_Srch = By.xpath(XpathsUnique.srch_product);
	
//  Create or initialize objects here.	
	BrowsersList bl = new BrowsersList();

	
//  All test cases started from here.
	@Test(priority = 0)
	public void firstCase() throws IOException, InterruptedException {
		
		extentTest = extent.startTest("firstCase");	      // We will write this line to use 'Extent Report'.
		
     // To Open Browser.
		bl.initialize();
		Thread.sleep(3000);
		
	 // To Open Url.	
	    bl.urlStack();	
		driver.manage().window().maximize();   
		Thread.sleep(3000);
			
	}
	
	@Test(priority = 1, dataProviderClass = DataDrivenClass.class, dataProvider ="testdata")   // To use 'Data-Driven' we will write (dataProviderClass = DataDrivenClass.class, dataProvider ="testdata").
    public void secondCase(final Data_pojo userDetails) throws IOException, InterruptedException {
		
		extentTest = extent.startTest("secondCase");	  // We will write this line to use 'Extent Report'.
		
		Thread.sleep(3000);
		
	 // To fail or check report screenshot upto login.
		driver.findElement(User_Id).sendKeys(userDetails.getDetails1());    // 9996050145 from excel.
		System.out.println("Enter Username: " + userDetails.getDetails1());
		
		driver.findElement(pass_Id).sendKeys(userDetails.getDetails2());    // shubham.
		System.out.println("Enter Password: " + userDetails.getDetails2());
		
		Thread.sleep(2000);
		driver.findElement(logIn).click();      
		
	 // To close popup.
		Thread.sleep(2000);
		driver.findElement(cross).click();
		
	 // To search product.
		Thread.sleep(2000);
		driver.findElement(Prod_Search).sendKeys(userDetails.getNumber1()); // Mobile.
		System.out.println("Enter Password: " + userDetails.getNumber1());
		
	 // Click on search button.
		Thread.sleep(3000);
		driver.findElement(btn_search).click();
		
	 // Click on 'Flipkart' image logo.
		Thread.sleep(3000);
		driver.findElement(flipkart_logo).click();	
		
	 // To search product again.
		Thread.sleep(2000);
		driver.findElement(Prod_Srch).sendKeys(userDetails.getNumber2()); // shoes.
		System.out.println("Enter Password: " + userDetails.getNumber2());
		
	 // Again click on search button.
		Thread.sleep(3000);
		driver.findElement(btn_srch).click();
		
		Thread.sleep(2000);
	}
	
}
