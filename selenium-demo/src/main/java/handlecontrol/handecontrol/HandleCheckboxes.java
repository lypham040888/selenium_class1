package handlecontrol.handecontrol;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleCheckboxes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait exwDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();

		// select specific one checkbox
		exwDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='monday']")));
		driver.findElement(By.xpath("//input[@id='monday']")).click();

//		// total number of checkboxes
		List<WebElement> checkboxes = driver
				.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		System.out.println("Total number of checkboxes:" + checkboxes.size()); // 7
//
//		// Select all the checkboxes

		for (int i = 0; i < checkboxes.size(); i++) {
			WebElement temp = checkboxes.get(i);

			if (temp.isSelected() == false) {
				temp.click();
			}

		}
//
//		// clear/Uncheck checkboxes
//
//		// Using normal for loop
		// Uncheck
		for (int i = 0; i < 3; i++) {
			checkboxes.get(i).click();
		}



	}

}
