package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

public static void main(String[] args) {
// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\nilamma\\\\Jar files\\\\chromedriver_win32\\\\chromedriver.exe");

WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();

driver.get("https://staging.expotoolkit.com/");
driver.findElement(By.linkText("Administrator Sign-in")).click();
driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("shradhama@cybage.com");
driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Ma45AzSd27");
driver.findElement(By.xpath("//input[@id='cmdSubmit']")).click();
driver.findElement(By.linkText("RECEIVERTEST")).click();
driver.quit();
}


}
