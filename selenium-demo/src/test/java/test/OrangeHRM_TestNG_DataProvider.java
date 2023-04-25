package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrangeHRM_TestNG_DataProvider {
	WebDriver driver;

	@DataProvider(name = "dp")
	String[][] loginData() {
		String data[][] = { { "autotest1", "Autotest1" }, { "autotest3", "P@ssword1" }, { "lypham", "P@ssword1" } };

		return data;
	}

	@Test(dataProvider = "dp")
	public void Login(String username, String pwd) {
		driver.get("https://autotest.jmaster.io/web/index.php/auth/login");
		// Find element username

		WebElement txtUser = driver.findElement(By.name("username"));
		// Enter test data
		txtUser.sendKeys(username);

		// Find element password
		WebElement txtPassword = driver.findElement(By.name("password"));
		// Enter test data
		txtPassword.sendKeys(pwd);

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
