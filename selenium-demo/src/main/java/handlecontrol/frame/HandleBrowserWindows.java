package handlecontrol.frame;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindows {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://autotest.jmaster.io/web/index.php/auth/login");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		String singleWindow = driver.getWindowHandle();
		
		System.out.println("Single Windows:"+ singleWindow);
		// capture id's for browser windows
		Set<String> windowIDs = driver.getWindowHandles(); // store 2 window id's

		// Approach1 - using List collection

		List<String> windowidsList = new ArrayList(windowIDs); // converted Set --->List

		String parentWindowID = windowidsList.get(0);
		String childWindowID = windowidsList.get(1);

		// Switch to child window 
		driver.switchTo().window(childWindowID);
		Thread.sleep(1000);
		// Click Contact Sales
		driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
		Thread.sleep(3000);
		
		// Switch to parent window 
		driver.switchTo().window(parentWindowID);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
		Thread.sleep(3000);

		// Approach2
		System.out.println("Approach 2 ");
		for (String winid : windowIDs) {
			
			String title = driver.switchTo().window(winid).getTitle();
			System.out.println("Web Title: "+ title);
			if (title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM")) {
				driver.findElement(By.xpath("//button[text()='Contact Sales")).click();
				System.out.println("Web Title: "+ title);
			}
		}

		// closing specific browser windows based on choice


		for (String winid : windowIDs) {
			String title = driver.switchTo().window(winid).getTitle();

			if (title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM")) {
				driver.close();
			}
		}
		
		driver.quit();

	}
}
