package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMLogin {
	
	public static WebDriver driver;
	public WebDriverWait wait;
	
	public void initilizeDriver()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nilamma\\Jar files\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();	
	}
	
	public void Login() throws InterruptedException 
	{
		//CRM App
		driver.get("https://imcqa.crm.dynamics.com/");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='loginfmt']")).sendKeys("nilamma@cybage.com");
		
		driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.id("passwordInput")).click();
		
		driver.findElement(By.id("passwordInput")).sendKeys("cybage#123");
		
		driver.findElement(By.xpath("//span[@id='submitButton']")).click();
		
		//Wait to enter the verification code
		Thread.sleep(30000);
		
		//Click on Verify button
		driver.findElement(By.id("idSubmit_SAOTCC_Continue")).click();
		
		//Wait till 'Stay Signed In' pop-up is displayed
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Stay signed in?')]")));
		
		driver.findElement(By.xpath("//input[@id='KmsiCheckboxField']")).click();
		driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
		
		//Wait till landing page is displayed
		Thread.sleep(20000);
	}
	
	public void createAccount() throws InterruptedException
	{
		driver.switchTo().frame("AppLandingPage");

		driver.findElement(By.xpath("//div[contains(text(),'Demand Driver Management')]")).click();
			
		//Wait till Home page is displayed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Home')]")));

		//Select Accounts menu from left navigation bar
		driver.findElement(By.xpath("//span[contains(text(),'Accounts')]")).click();
		
		//Wait till active accounts page is displayed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='shell-container']/div[@id='ApplicationShell']/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]")));
		
		//Click on 'New' button
		driver.findElement(By.xpath("//span[contains(text(),'New')]")).click();
		
		//Wait till new account page is displayed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@title='New Account']")));
		
		//Fill all the mandatory fields to create new account
		driver.findElement(By.xpath("//input[@id='id-276390f9-8bbf-4452-8f24-636b0ccaee2c-1-name8-name.fieldControl-text-box-text']")).sendKeys("Cyb QA Test");
		
		driver.findElement(By.xpath("//input[@aria-label='Phone']")).sendKeys("202 555 0191");
		
	}

	public static void main(String[] args) throws InterruptedException
	{
		CRMLogin cl = new CRMLogin();
		cl.initilizeDriver();
		cl.Login();
		cl.createAccount();
	}

}
