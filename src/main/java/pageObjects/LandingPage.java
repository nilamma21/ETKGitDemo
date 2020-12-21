package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{
	public WebDriver driver;
	
	//By demandDriverMngmnt = By.xpath("//div[contains(text(),'Demand Driver Management')]");
	By demandDriverMngmnt = By.xpath("//*[text()='Demand Driver Management']");

	public LandingPage(WebDriver driver) 
	{
		this.driver =  driver;
	}
	
	public WebElement getDemandDriverMngmnt()
	{
		return driver.findElement(demandDriverMngmnt);
	}
	
}
