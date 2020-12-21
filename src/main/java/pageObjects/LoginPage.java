package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{
	public WebDriver driver;
	
	By username = By.xpath("//input[@name='loginfmt']");
	By nextbtn = By.xpath("//input[@id='idSIButton9']");
	By password = By.id("passwordInput");
	By signinBtn = By.xpath("//span[@id='submitButton']");
	By verifyBtn = By.id("idSubmit_SAOTCC_Continue");
	By checkBox = By.xpath("//input[@id='KmsiCheckboxField']");
	By yesBtn = By.xpath("//input[@id='idSIButton9']");


	public LoginPage(WebDriver driver) 
	{
		this.driver =  driver;
	}

	public WebElement getUsername()
	{
		return driver.findElement(username);
	}
	
	public WebElement getNextbtn()
	{
		return driver.findElement(nextbtn);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getSignIn()
	{
		return driver.findElement(signinBtn);
	}
	
	public WebElement getVerifyBtn()
	{
		return driver.findElement(verifyBtn);
	}
	
	public WebElement getCheckBox()
	{
		return driver.findElement(checkBox);
	}
	
	public WebElement getYesBtn()
	{
		return driver.findElement(yesBtn);
	}
}
