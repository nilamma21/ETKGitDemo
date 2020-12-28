package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
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
		
		//Wait till Sign In page is displayed
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Sign in')]")));

		driver.findElement(By.xpath("//input[@name='loginfmt']")).sendKeys("nilamma@cybage.com");
		
		driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='loginMessage']")));
		driver.findElement(By.id("passwordInput")).click();
		
		driver.findElement(By.id("passwordInput")).sendKeys("cybage#123");
		
		driver.findElement(By.xpath("//span[@id='submitButton']")).click();
		
		//Wait to enter the verification code
		Thread.sleep(30000);
		
		//Click on Verify button
		driver.findElement(By.id("idSubmit_SAOTCC_Continue")).click();
		
		//Wait till 'Stay Signed In' pop-up is displayed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Stay signed in?')]")));
		
		driver.findElement(By.xpath("//input[@id='KmsiCheckboxField']")).click();
		driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
		
		//Wait till landing page is displayed
		Thread.sleep(30000);
	}
	
	public void selectDDMngmentMenu()
	{
		driver.switchTo().frame("AppLandingPage");

		driver.findElement(By.xpath("//div[contains(text(),'Demand Driver Management')]")).click();
			
		//Wait till Home page is displayed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Home')]")));
		
		//**Need to remove below two lines while final execution(Already added in createAccount method)
		//Select Accounts menu from left navigation bar
		driver.findElement(By.xpath("//span[contains(text(),'Accounts')]")).click();
		//Wait till Active Accounts page is displayed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'New')]")));
		
	}
	
	public void createAccount() throws InterruptedException
	{
		//Select Accounts menu from left navigation bar
		driver.findElement(By.xpath("//span[contains(text(),'Accounts')]")).click();
		
		//Wait till Active Accounts page is displayed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'New')]")));
		
		//Click on 'New' button
		driver.findElement(By.xpath("//span[contains(text(),'New')]")).click();
		
		//Wait till new account page is displayed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@title='New Account']")));
		
		//Fill all the mandatory fields to create new account
		//Enter Account Name
		WebElement accountName = driver.findElement(By.xpath("//input[@id='id-276390f9-8bbf-4452-8f24-636b0ccaee2c-1-name8-name.fieldControl-text-box-text']"));
		accountName.click();
		accountName.sendKeys("Cyb_QATest");
		
		//Enter Phone no.
		WebElement phn = driver.findElement(By.xpath("//input[@aria-label='Phone']"));
		phn.click();
		phn.sendKeys("20255501917");
		Thread.sleep(5000);
		
		//Scroll up the page till Address field
		Actions action = new Actions(driver);
		WebElement address = driver.findElement(By.xpath("//h2[contains(text(),'Address')]"));
		action.moveToElement(address).perform();
		
		//Select account type
		driver.findElement(By.xpath("//input[@id='xxc_typecode_ledit']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Toggle menu']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Buyer')]")).click();
		address.click();
		
		//Enter Street1 address
		WebElement street1 = driver.findElement(By.xpath("//input[@aria-label='Street 1']"));
		//street1.click();
		street1.sendKeys("QA Test Street");
		
		//Scroll down on the page
		action.keyDown(Keys.CONTROL).sendKeys(Keys.DOWN).perform();
		action.keyDown(Keys.CONTROL).sendKeys(Keys.DOWN).release().perform();
		
		Thread.sleep(5000);
		//Enter City
		WebElement city = driver.findElement(By.xpath("//input[@aria-label='City']"));
		city.click();
		city.sendKeys("New York");
				
		//Enter state
		WebElement state = driver.findElement(By.xpath("//input[@aria-label='State/Province']"));
		state.click();
		state.sendKeys("MH");
		
		//Enter country
		WebElement zip = driver.findElement(By.xpath("//input[@aria-label='ZIP/Postal Code']"));
		zip.click();
		zip.sendKeys("444123");
		
		WebElement country = driver.findElement(By.xpath("//input[@aria-label='Country']"));
		country.click();
		driver.findElement(By.xpath("//button[@aria-label='Toggle Dropdown']")).click();
		driver.findElement(By.xpath("//body/div[@id='_dropdown']/div[3]")).click();
		
		driver.findElement(By.xpath("//button[@aria-label='Save & Close']")).click();
		
		//Wait till Active Accounts page is displayed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Active Accounts']")));
	}
	
	public void validateAccount() throws InterruptedException
	{	
		WebElement searchAccount = driver.findElement(By.xpath("//input[@aria-label='Search this view']"));
		searchAccount.click();
		searchAccount.sendKeys("Cyb_QATest");
		driver.findElement(By.xpath("//button[@aria-label='Start search']")).click();
		Thread.sleep(10000);
		WebElement validateAccName = driver.findElement(By.xpath("//a[contains(text(),'Cyb_QATest')]"));
		if (validateAccName.isDisplayed()) {
			System.out.println("New Account is created successfully");
		}
		else {
			System.out.println("Failed to create a new account");
		}
	}
	
	public void deactivateAccount() throws InterruptedException
	{
		WebElement accName = null;
		//String accNameTitle = null;
		CharSequence accNameTitle = null;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		//Click on 'A' link to sort accounts starts with 'A'
		driver.findElement(By.xpath("//a[@id='A_link']")).click();
		
		try {
		Thread.sleep(4000);	
		//Select 2nd account name in list
		accName = driver.findElement(By.xpath("//div[@data-id='cell-1-2']"));
		accName.click();
		accNameTitle = accName.getText();
		System.out.println(accNameTitle);
		}
		catch(StaleElementReferenceException e) {
			System.out.println(e.getMessage());
        }
		
		//Wait till Deactivate button is displayed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Deactivate']")));
		
		//Click on Deactivate button
		driver.findElement(By.xpath("//button[@aria-label='Deactivate']")).click();
		
		//Click on 'Deactivate button of confirmation po-up
		driver.findElement(By.xpath("//button[@data-id='ok_id']")).click();
		
		WebElement activateBtn = driver.findElement(By.xpath("//button[@aria-label='Activate']"));
		if (activateBtn.isDisplayed()) {
			System.out.println("Selected account is deactivated successfully");
		}
		else {
			System.out.println("Failed to deactivate an account");
		}
		
		//Navigate back to Active accounts page
		driver.findElement(By.xpath("//span[@class='symbolFont BackButton-symbol pa-ak ']")).click();
		
		//Click on 'Active Accounts' drop-down view button
		driver.findElement(By.xpath("//span[@class='symbolFont ChevronDownMed-symbol  ']")).click();
		
		//Select 'Inactive Accounts' option
		driver.findElement(By.xpath("//*[text()='Inactive Accounts']")).click();
		
		Thread.sleep(6000);
		//Click on 'A' link to sort accounts starts with 'A'
		try {
			WebElement alink = driver.findElement(By.xpath("//a[@id='A_link']"));
			wait.until(ExpectedConditions.elementToBeClickable(alink));
			alink.click();
			Thread.sleep(3000);
			
			//Validate deactivated account
			WebElement searchAcc = driver.findElement(By.xpath("//input[@aria-label='Search this view']"));
			searchAcc.click();
			searchAcc.sendKeys(accNameTitle);
			driver.findElement(By.xpath("//button[@aria-label='Start search']")).click();
			Thread.sleep(10000);
			WebElement validateInactiveAcc = driver.findElement(By.xpath("//div[@data-id='cell-0-2']"));
			if (validateInactiveAcc.isDisplayed()) {
				System.out.println("Deactivated Account is displayed under 'Inactive Account' list");
			}
			else {
				System.out.println("Failed to display deactived account");
			}	
		}
		catch (StaleElementReferenceException exe) {
			System.out.println(exe.getMessage());
		}
		catch (IllegalArgumentException ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	public static void main(String[] args) throws InterruptedException
	{
		CRMLogin cl = new CRMLogin();
		cl.initilizeDriver();
		cl.Login();
		cl.selectDDMngmentMenu();
		//cl.createAccount();
		//cl.validateAccount();
		cl.deactivateAccount();
	}

}
