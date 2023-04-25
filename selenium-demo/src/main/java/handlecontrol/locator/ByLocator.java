package  handlecontrol.locator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ByLocator {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions chromeOption = new ChromeOptions();
		chromeOption.addArguments("--remote-allow-origins=*");
		WebDriver driver = new FirefoxDriver();
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
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(2000);
		
		// Tagname
		/*
		WebElement titleElement = driver.findElement(By.tagName("h1"));
		System.out.println("h1 title "+ titleElement.getText());
		
		System.out.println("h1 innerHTML "+ titleElement.getAttribute("innerHTML"));
		
		System.out.println("List elements: ");
		List< WebElement> lsttitleElement = driver.findElements(By.tagName("h1"));
	
		for (WebElement webElement : lsttitleElement) {
			System.out.println(webElement.getAttribute("innerHTML"));	
		}
		*/
		// cssSelector
		// id
		
		/*
		WebElement sectionNopCommerceNews = driver.findElement(By.cssSelector("#nopcommerce-news-box"));
		System.out.println("sectionNopCommerceNews innerHTML: "+ sectionNopCommerceNews.getAttribute("innerHTML"));
		*/
		
		WebElement singlefloatLeft = driver.findElement(By.cssSelector("a.float-left"));
		System.out.println("Single singlefloatLeft: "+ singlefloatLeft.getAttribute("innerHTML"));
		
		List< WebElement> floatLeft = driver.findElements(By.cssSelector("a.float-left"));
		for (WebElement webElement : floatLeft) {
		 System.out.println("innerHTML: "+ webElement.getAttribute("innerHTML"));
		}

		List< WebElement> sectionNopCommerce = driver.findElements(By.cssSelector("a[class=float-left]"));
		for (WebElement webElement : sectionNopCommerce) {
			webElement.getAttribute("innerHTML");
		}
		
		
		List< WebElement> divNopCommerce = driver.findElements(By.cssSelector("div.card-body"));
		for (WebElement webElement : divNopCommerce) {
			 System.out.println("inner HTML of div : "+webElement.getAttribute("innerHTML"));
		}
		 WebElement sectionNopCommerceNews = driver.findElement(By.linkText("Online training for developers"));
		
	
		// Link text
		 WebElement onlineTraining = driver.findElement(By.partialLinkText("Online training"));
		 System.out.println("onlineTraining innerHTML: "+ onlineTraining.getAttribute("innerHTML"));
		
		 WebElement ponlineTraining = driver.findElement(By.xpath("Online training"));
		 
		//Assert.assertEquals("Dashboard", expectedTitle);
		driver.quit();
	}

}
