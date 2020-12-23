package com.crm.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class LandingTest extends base
{
	public WebDriverWait wait;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
		//Wait till Sign In page is displayed
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Sign in')]")));
	}
	
	@Test(dataProvider = "getData")
	public void verifyLogin(String Username, String Password) throws InterruptedException 
	{		
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys(Username);
		lp.getNextbtn().click();
		Thread.sleep(5000);
		
		lp.getPassword().click();
		lp.getPassword().sendKeys(Password);
		lp.getSignIn().click();
		
		//Wait to enter the verification code
		Thread.sleep(30000);
		lp.getVerifyBtn().click();
		
		//Wait till 'Stay Signed In' pop-up is displayed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Stay signed in?')]")));
		lp.getCheckBox().click();
		lp.getYesBtn().click();
		
		//Verify that landing page is displayed after successful login
		LandingPage l = new LandingPage(driver);
		//To check visibility of web element on browser
		Assert.assertTrue(l.getDemandDriverMngmnt().isDisplayed());
		
	}
	
	@Test(priority=1)
	public void verifyHomePageNavigation() throws InterruptedException
	{
		//Wait till landing page is displayed
		Thread.sleep(20000);
		driver.switchTo().frame("AppLandingPage");
		
		LandingPage l = new LandingPage(driver);
		l.getDemandDriverMngmnt().click();
		
		//Wait till Home page is displayed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Call Center Manager Dashboard']")));
		
		//Verify that Home page is displayed after selecting Demand Driver Management menu
		//HomePage hp = new HomePage(driver);
		//Assert.assertTrue(hp.getHomeTitle().isDisplayed());
		
		System.out.println("User is redirected to Home page");
	}
	
	@DataProvider
	public Object[][] getData() 
	{
		//Row stands for how many combinations of test data will use
		//Column stands for that for each combination we are passing 2 values (Username, Password)
		Object[][] data = new Object[1][2];
		
		//1st test data set
		data[0][0] = "nilamma@cybage.com";
		data[0][1] = "cybage#123";
		
		return data;
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}