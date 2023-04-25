package  handlecontrol.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoXpathLocator {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		// *
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize(); // maximize the page
		Thread.sleep(1000);
		/* Lấy theo thuộc tính của tagname đầy đủ attribute
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		Thread.sleep(1000);
		WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
		email.clear();
		Thread.sleep(1000);
		email.sendKeys("admin@yourstore.com");
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.clear();
		password.sendKeys("admin");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(2000);
		
		// Lấy theo parent Parent node ( Lấy từ đời cha trở xuống)
		WebElement powerByLink = driver.findElement(By.xpath("//div[@class='main-footer']//a"));
		System.out.println("Power by: "+ powerByLink.getText());
		*/
		
		//WebElement myAccountLink = driver.findElement(By.xpath("//div[@class='footer-block my-account']//a"));
		//System.out.println("My Account : "+ myAccountLink.getText());
		
		// Lấy giá trị tuyệt đối của attribute thì bằng =
		WebElement myAccountByText = driver.findElement(By.xpath("//div[@class='footer']//a[(text()='My account')]"));
		System.out.println("My Account by Text : "+ myAccountByText.getText());
		
		// Lấy giá trị tương đối của attribute với  dấu ,
		WebElement rmyAccountByText = driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My account')]"));
		System.out.println("My Account by Text : "+ rmyAccountByText.getText());
				
		// Lấy giá trị tương đối của attribute với  start-with

		WebElement swmyAccountByText = driver.findElement(By.xpath("//div[@class='footer']//a[starts-with(text(),'My')]"));
		System.out.println("My Account by Text : "+ swmyAccountByText.getText());
		driver.close();
		//driver.quit();
		
	}

}
