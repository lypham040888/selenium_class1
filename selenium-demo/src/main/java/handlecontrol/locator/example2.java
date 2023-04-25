package  handlecontrol.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.asserts.*;

public class example2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// 2) open url on the browser
		
		ChromeOptions chromeOption = new ChromeOptions();
		chromeOption.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver();
		// *
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.manage().window().maximize(); // maximize the page
		Thread.sleep(1000);
		driver.findElement(By.id("Email")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("admin");
		Thread.sleep(1000);
		WebElement titleElement = driver.findElement(By.tagName("h100"));
		
		//Assert.assertEquals("Dashboard", expectedTitle);
		driver.quit();
	  }

	

}
