package test;

import org.testng.annotations.Test;

import dataProvider.ConfigPropertiesFile;
import pageObject.LoginPage2;
import pageObject.MyInfo;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestChangeLogo {
	WebDriver driver;
	LoginPage2 lp2;
	ConfigPropertiesFile pros = new ConfigPropertiesFile();

	@DataProvider(name = "images")
	public Iterator<Object[]> testValidData() throws IOException {
		List<Object[]> list = new ArrayList<>();

		list.add(new Object[] { "validImage", pros.getProperties("validImage") });
		list.add(new Object[] { "validImage2", pros.getProperties("validImage2") });

		return list.iterator();
	}

	@Test(priority = 1)
	void testLogin() {
		lp2 = new LoginPage2(driver);

		String username = pros.getProperties("username");
		String password = pros.getProperties("password");
		lp2.setUserName(username);
		lp2.setPassword(password);
		lp2.clickLogin();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");

	}

	@Test(priority = 2, dataProvider = "images")
	public void upLoadLogo(String key, String filename) throws InterruptedException {
		MyInfo myInfo = new MyInfo(driver);
		myInfo.clickLogoIcon();
		myInfo.clickSelectImage(filename);
		myInfo.Save();

	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		// driver = new FirefoxDriver();

		driver.get("https://autotest.jmaster.io/");
		driver.manage().window().maximize();
		// Set default driver wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterTest
	public void afterTest() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		driver.quit();
	}

}
