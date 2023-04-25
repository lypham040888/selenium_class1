package  handlecontrol.locator;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByXpathIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

		List<WebElement> lstImage = driver.findElements(By.xpath("//div[@class='picture']//img"));
		for (WebElement webElement : lstImage) {
			System.out.println("Text foreach:" + webElement.getAttribute("title"));
		}
		for (int i = 0; i < lstImage.size(); i++) {
			WebElement tmp = lstImage.get(i);
			System.out.println("Text for index:" + tmp.getAttribute("title"));

		}
		
		
		WebElement firstElement = driver.findElement(By.xpath("(//div[@class='picture']//img)[1]"));
		System.out.println("Text for firstElement:" + firstElement.getAttribute("title"));

		WebElement secondElement = driver.findElement(By.xpath("(//div[@class='picture']//img)[2]"));
		System.out.println("Text for secondElement:" + secondElement.getAttribute("title"));
		
		WebElement thirdElement = driver.findElement(By.xpath("(//div[@class='picture']//img)[3]"));
		System.out.println("Text for thirdElement:" + thirdElement.getAttribute("title"));
		
		WebElement fourElement = driver.findElement(By.xpath("(//div[@class='picture']//img)[4]"));
		System.out.println("Text for fourElement:" + fourElement.getAttribute("title"));
		
		WebElement fiveElement = driver.findElement(By.xpath("(//div[@class='picture']//img)[5]"));
		System.out.println("Text for fiveElement:" + fiveElement.getAttribute("title"));
		
		WebElement sixElement = driver.findElement(By.xpath("(//div[@class='picture']//img)[6]"));
		System.out.println("Text for sixElement:" + sixElement.getAttribute("title"));
		
		WebElement svElement = driver.findElement(By.xpath("(//div[@class='picture']//img)[7]"));
		System.out.println("Text for svElement:" + svElement.getText());

		driver.quit();

	}

}
