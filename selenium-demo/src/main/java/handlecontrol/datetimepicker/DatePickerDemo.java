package handlecontrol.datetimepicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();

		driver.switchTo().frame(0); // switch to frame

		// Approach 1
		//driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("10/15/2023");
		// // mm/dd/yyyy

		// Approach2

		String year = "2022";
		String month = "May";
		String date = "10";

		driver.findElement(By.xpath("//input[@id='datepicker']")).click(); // will open the date picker

		// select month & year
		while (true) {
			String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (mon.equals(month) && yr.equals(year)) {
				break;
			}
		//driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")).click();// Click next day 
			driver.findElement(By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']")).click(); // Click back day
		}

		// select date

		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

		for (WebElement dt : allDates) {
			if (dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
		
		Thread.sleep(3000);
		driver.quit();
	}

}
