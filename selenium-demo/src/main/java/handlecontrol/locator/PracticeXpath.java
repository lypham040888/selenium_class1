package  handlecontrol.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PracticeXpath {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		Thread.sleep(1000);
		
		WebElement h2Title = driver.findElement(By.xpath("//div[@class='topic-block-body']"));
		System.out.println(h2Title.getText());
		driver.quit();
	}

}
