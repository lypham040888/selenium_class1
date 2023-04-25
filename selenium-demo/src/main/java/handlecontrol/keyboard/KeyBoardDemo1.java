package  handlecontrol.keyboard;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyBoardDemo1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Initialize ChromeDriver
		// Here we assume that the ChromeDriver path has been set in the System Global
		// variables
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Navigate to the demo site
		driver.get("https://demoqa.com/text-box");

		// Enter the Full Name
		WebElement fullName = driver.findElement(By.id("userName"));
		fullName.sendKeys("Mr.Peter Haynes");

		// Enter the Email
		WebElement email = driver.findElement(By.id("userEmail"));
		email.sendKeys("PeterHaynes@toolsqa.com");

		// Enter the Current Address
		WebElement currentAddress = driver.findElement(By.id("currentAddress"));
		currentAddress.sendKeys("43 School Lane London EC71 9GO");

		// Copy the Current Address
		currentAddress.sendKeys(Keys.CONTROL+"a");
		//currentAddress.sendKeys("a");
		currentAddress.sendKeys(Keys.CONTROL+"c");
		//currentAddress.sendKeys("c");
		
		// Press the TAB Key to Switch Focus to Permanent Address
		currentAddress.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		
		// Paste the Address in the Permanent Address field
		WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
		permanentAddress.sendKeys(Keys.CONTROL+"v");
		
		//permanentAddress.sendKeys("v");
		Thread.sleep(3000);

		// Compare Text of current Address and Permanent Address
		System.out.println(currentAddress.getAttribute("value"));

		System.out.println(permanentAddress.getAttribute("value"));

		driver.quit();
	}

}
