package  handlecontrol.locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DemoLogin1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// 1) Launch browser driver
		ChromeOptions chromeOption = new ChromeOptions();
		chromeOption.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(chromeOption);

		driver.get("https://autotest.jmaster.io/");
		driver.manage().window().maximize(); // maximize the page
		Thread.sleep(1000);
		driver.findElement(By.name("username")).clear();
		Thread.sleep(1000);
		driver.findElement(By.name("username")).sendKeys("autotest1");
		driver.findElement(By.name("password")).sendKeys("Autotest1");
		Thread.sleep(1000);
		WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));
		btnLogin.click();
		Thread.sleep(3000);

		// 3) close browser
		driver.quit();

	}

}
