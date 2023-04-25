package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import pageObject.LoginPage2;

public class LoginPOP_Test {
	WebDriver driver;
	LoginPage lp;
	LoginPage2 lp2;

	@BeforeMethod
	void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://autotest.jmaster.io/");
		driver.manage().window().maximize();
		// Set default driver wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@DataProvider(name = "dp")
	String[][] loginData() {
		String data[][] = { { "autotest1", "Autotest1" }, { "autotest3", "P@ssword1" }, { "lypham", "P@ssword1" } };

		return data;
	}

	@Test(priority = 1, dataProvider = "dp")
	void testLoginDataProvider(String username, String password) {
		lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLogin();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");

	}

	@Test(priority = 2)
	void testLogin() {
		lp = new LoginPage(driver);
		lp.setUserName("autotest1");
		lp.setPassword("Autotest1");
		lp.clickLogin();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");

	}

	@Test(priority = 3)
	void testLogin2() {
		lp2 = new LoginPage2(driver);
		lp2.setUserName("autotest1");
		lp2.setPassword("Autotest1");
		lp2.clickLogin();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");

	}

	@AfterMethod
	void tearDown() {
		driver.quit();
	}

}
