package handlecontrol.alert_popup;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		//Alert alertForm = driver.switchTo().alert();
		Alert jsAlert = mywait.until(ExpectedConditions.alertIsPresent());

		System.out.println(jsAlert.getText());

		jsAlert.accept();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Thread.sleep(1000);
		mywait.until(ExpectedConditions.alertIsPresent());

		Alert jsAlertConfirm = driver.switchTo().alert();
		// Alert alertwindow = mywait.until(ExpectedConditions.alertIsPresent());

		System.out.println(jsAlertConfirm.getText());

		//jsAlertConfirm.accept(); // this will close alert window using ok button

		jsAlertConfirm.dismiss(); // close alert window by using cancel button
		Thread.sleep(3000);
		
	}

}
