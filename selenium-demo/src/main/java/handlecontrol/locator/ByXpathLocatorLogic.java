package  handlecontrol.locator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ByXpathLocatorLogic {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();

		driver.get("https://demo.nopcommerce.com/");
		WebElement fbElement = driver.findElement(By.xpath("//a[@rel='noopener noreferrer' and text()='Facebook']"));
		
		System.out.println("Facebook: " + fbElement.getText());

		List<WebElement> fbElemet = driver
				.findElements(By.xpath("//a[@rel='noopener noreferrer' and (text()='Facebook' or text()='YouTube')]"));
		for (WebElement webElement : fbElemet) {
			webElement.click();
			Thread.sleep(1000);
		}

		// driver.close();
		driver.quit(); //

	}

}
