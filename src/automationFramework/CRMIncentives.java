	package automationFramework;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class CRMIncentives {

	public static void main(String[] args) throws InterruptedException {
	// TODO Auto-generated method stub

	// Initialize Driver

	System.setProperty("webdriver.chrome.driver", "C:\\Users\\nilamma\\Jar files\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();

	// Maximize Driver

	driver.manage().window().maximize();

	// Adding Implicit Wait

	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	// Access URL

	driver.get("https://imcqa.crm.dynamics.com/");

	// Login to CRM

	driver.findElement(By.cssSelector("input[name = 'loginfmt']")).sendKeys("nilamma@cybage.com");
	driver.findElement(By.cssSelector("input[id = 'idSIButton9']")).click();
	driver.findElement(By.cssSelector("input[id = 'passwordInput']")).sendKeys("cybage#123");
	driver.findElement(By.cssSelector("span[id = 'submitButton']")).click();
	Thread.sleep(30000);
	driver.findElement(By.id("idSubmit_SAOTCC_Continue")).click();
	driver.findElement(By.id("idSIButton9")).click();

	// Open landing page / dashboard

	driver.switchTo().frame("AppLandingPage");
	driver.findElement(By.id("AppDetailsSec_1_Item_1")).click();

	// Go to Account section using left menu option

	driver.findElement(By.xpath("//span[contains(text(),'Accounts')]")).click();

	// Search Account Name

	driver.findElement(By.xpath("//div[@data-id = 'data-set-quickFind-container']/input")).sendKeys("Cyb");
	driver.findElement(By.xpath("//div[@data-id = 'data-set-quickFind-container']/button")).click();

	// Open searched account

	driver.findElement(By.xpath("//div[@data-id = 'cell-0-2']")).click();

	Thread.sleep(30000);

	// Open Incentives tab

	driver.findElement(By.xpath("//li[@data-id = 'tablist-tab_4']")).click();

	// Open New Incentive window

	driver.findElement(By.xpath("//button[@aria-label = 'New Incentive']")).click();

	// Enter data in new incentive form

	// Select Contact

	driver.findElement(By.xpath("//input[@aria-label = 'Contact, Lookup']")).click();
	driver.findElement(By.xpath("//button[@aria-label = 'Search records for Contact, Lookup field']")).click();
	driver.findElement(By.xpath("//span[@data-id = 'xxc_contactid.fieldControl-emailaddress11_0_0']")).click();

	// Select Market

	driver.findElement(By.xpath("//input[@aria-label = 'Market, Lookup']")).click();
	driver.findElement(By.xpath("//button[@aria-label = 'Search records for Market, Lookup field']")).click();
	driver.findElement(By.xpath("//span[@data-id = 'xxc_marketid.fieldControl-xxc_channelid1_0_0']")).click();

	// Select Referral Source

	driver.findElement(By.xpath("//input[@aria-label = 'Referral Source, Lookup']")).click();
	driver.findElement(By.xpath("//button[@aria-label = 'Search records for Referral Source, Lookup field']")).click();
	driver.findElement(By.xpath("//span[@data-id = 'xxc_referralsourceid.fieldControl-xxc_type1_0_0']")).click();

	// Enter Other Incentive Source

	driver.findElement(By.xpath("//input[@aria-label = 'Other Incentive Source']")).click();
	driver.findElement(By.xpath("//input[@aria-label = 'Other Incentive Source']")).sendKeys("None");

	// Save Incentive

	driver.findElement(By.xpath("//button[@aria-label = 'Save & Close']")).click();

	// Incentive verification

	//Assert.assertEquals(driver.findElement(By.xpath("")), expected, message);

	}

	}

