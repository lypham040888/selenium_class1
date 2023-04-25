package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class OrangeHRM_TestNG {
	WebDriver driver ;

	@Test(priority = 2)
	public void LoginAdmin() {
		driver.get("https://autotest.jmaster.io/web/index.php/auth/login");
		// Find element username

		WebElement txtUser = driver.findElement(By.name("username"));
		// Enter test data
		txtUser.sendKeys("autotest1");

		// Find element password
		WebElement txtPassword = driver.findElement(By.name("password"));
		// Enter test data
		txtPassword.sendKeys("Autotest1");

		// Find button login
		WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));
		System.out.print("The Login button:" + btnLogin.getText());
		// Click login
		btnLogin.click();
		WebElement titlePage = driver
				.findElement(By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb-module')]"));
		String expectationResult = "PIM";
		String actualResult = titlePage.getText();
		Assert.assertEquals(actualResult, expectationResult, "Kiểm tra text của title page");
	}

	@Test(priority = 1)
	public void LoginESS() {
		// Find element username
		driver.get("https://autotest.jmaster.io/web/index.php/auth/login");
		WebElement txtUser = driver.findElement(By.name("username"));
		// Enter test data
		txtUser.sendKeys("autotest3");

		// Find element password
		WebElement txtPassword = driver.findElement(By.name("password"));
		// Enter test data
		txtPassword.sendKeys("P@ssword1");

		// Find button login
		WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));
		System.out.print("The Login button:" + btnLogin.getText());
		// Click login
		btnLogin.click();
		WebElement titlePage = driver
				.findElement(By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb-module')]"));
		String expectationResult = "PIM";
		String actualResult = titlePage.getText();
		Assert.assertEquals(actualResult, expectationResult, "Kiểm tra text của title page");
	}

	@BeforeMethod
	public void beforeMethod() {
		// Setup Chrome Options
		ChromeOptions options = new ChromeOptions();
		// Add Chrome incognito mode
		//options.addArguments("-incognito");
		// Add Chrome start with maximized
		options.addArguments("--start-maximized");
		// Initialize Chrome driver
		//driver = new ChromeDriver(options);
		driver= new FirefoxDriver();
		// Set default driver wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod
	public void afterMethod() {
		// Reset driver wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		// Quit driver
		driver.quit();
	}

}
