package handlecontrol.handecontrol;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentWaitDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.get("https://autotest.jmaster.io/web/index.php/auth/login");

		// Fluent wait declaration

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(30));
		wait.pollingEvery(Duration.ofSeconds(5));
		wait.ignoring(NoSuchElementException.class);

		// usage
		WebElement username = (WebElement) wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		username.sendKeys("Admin");
		driver.close();
	}

}
