package handlecontrol.handecontrol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalCommands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();

		// isDisplayed() isEnabled()
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		System.out.println("display status of logo:" + logo.isDisplayed());

		WebElement searchbox = driver.findElement(By.id("small-searchterms"));
		System.out.println("Searchbox status:" + searchbox.isDisplayed());
		System.out.println("Searchbox Enable status:" + searchbox.isEnabled());

		// isSelected()

		WebElement male_rd = driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female_rd = driver.findElement(By.xpath("//input[@id='gender-female']"));

		// Before selection
		System.out.println("Before selection both radio...............");
		System.out.println(male_rd.isSelected()); // false
		System.out.println(female_rd.isSelected()); // false

		// After selection of male radio button
		System.out.println("After selection of male radiop button............");
		male_rd.click();
		System.out.println(male_rd.isSelected()); // true
		System.out.println(female_rd.isSelected()); // false

		// After selection of fe-male radio button
		System.out.println("After selection of female radiop button............");
		female_rd.click();
		System.out.println(male_rd.isSelected()); // false
		System.out.println(female_rd.isSelected()); // true
		
		driver.quit();

	}

}
