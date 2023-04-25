package handlecontrol.handecontrol;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class getMethod {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/");
		Thread.sleep(2000);
		// getCurrentUrl
		System.out.println(driver.getCurrentUrl());
		// getTitle
		System.out.println(driver.getTitle());
		// getPageSource
		System.out.println(driver.getPageSource());

		System.out.println("Single window: " + driver.getWindowHandle());

		driver.switchTo().newWindow(WindowType.TAB);
		// Opens autotest homepage in the newly opened window
		driver.navigate().to("https://autotest.jmaster.io/web/index.php/auth/login");

		Thread.sleep(2000);

		System.out.println("Multiple window: " + driver.getWindowHandles());
		for (String wname : driver.getWindowHandles()) {
			driver.switchTo().window(wname);
			Thread.sleep(2000);
			System.out.println("Title:" + driver.getTitle());
			
		}
		

		driver.quit();

	}

}
