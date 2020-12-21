package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage 
{
	public WebDriver driver;
	
	By HomePagetitle = By.xpath("//*[text()='Call Center Manager Dashboard']");
	
	public HomePage(WebDriver driver) 
	{
		this.driver =  driver;
	}
	
	public WebElement getHomeTitle()
	{
		return driver.findElement(HomePagetitle);
	}
	
}
