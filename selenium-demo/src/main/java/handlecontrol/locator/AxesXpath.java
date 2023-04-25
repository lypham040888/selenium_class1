package  handlecontrol.locator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AxesXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		// Get ancestor
		WebElement ancestorXpath = driver.findElement(By.xpath("//a[text()='$25 Virtual Gift Card']//ancestor::div[@class='product-grid home-page-product-grid']"));
		System.out.println("Inner HTML:" + ancestorXpath.getAttribute("innerHTML"));
		System.out.println("Text:"+ ancestorXpath.getText());
		// Get parent
		WebElement parentXpath = driver.findElement(By.xpath("//a[text()='$25 Virtual Gift Card']//parent::h2[@class='product-title']"));
		System.out.println("Parent:"+ parentXpath.getAttribute("innerHTML"));
		
		// Following
		
		List<WebElement> followingEle = driver.findElements(By.xpath("//a[text()='Apple MacBook Pro 13-inch']//following::div[@class='picture']"));
		for (WebElement webElement : followingEle) {
			System.out.println( "Following: "+webElement.getAttribute("innerHTML"));
		}
		// Preceding
		WebElement preceding = driver.findElement(By.xpath("//a[text()='Apple MacBook Pro 13-inch']//preceding::div[@class='details']"));
		System.out.println("Preceding: "+ preceding.getText());
		// descendant
		
		List<WebElement>descendant = driver.findElements(By.xpath("//div[@class='topic-block']//descendant::a"));
		for (WebElement webElement : descendant) {
			System.out.println("descendant:"+webElement.getText());
		}
		// descendant vs following
		System.out.println("List out descendant item");
		List<WebElement>descendantDemo = driver.findElements(By.xpath("//ul[@class='list']//descendant::a"));
		for (WebElement webElement : descendantDemo) {
			System.out.println("Descendant item: "+ webElement.getText());
			
		}
		System.out.println("List out following item");
		List<WebElement>followingDemo = driver.findElements(By.xpath("//ul[@class='list']//following::a"));
		for (WebElement webElement : followingDemo) {
			System.out.println("followingDemo item: "+ webElement.getText());
			
		}
		
		// following-sibling
		
		List<WebElement>following_sibling = driver.findElements(By.xpath("//a[text()='Build your own computer']//parent::h2/following-sibling::div"));
		for (WebElement webElement : following_sibling) {
			System.out.println("FS:"+ webElement.getAttribute("innerHTML"));
		}
		List<WebElement>afollowing_sibling = driver.findElements(By.xpath("//a[text()='Build your own computer']//following-sibling::div"));
		for (WebElement webElement : afollowing_sibling) {
			System.out.println("FSpan:"+ webElement.getAttribute("innerHTML"));
		}
		
		
		List<WebElement>preceding_sibling = driver.findElements(By.xpath("//a[text()='Apple MacBook Pro 13-inch']//ancestor::div/preceding-sibling::div[@class='picture']"));
		for (WebElement webElement : preceding_sibling) {
			System.out.println("preceding_sibling:"+ webElement.getAttribute("innerHTML"));
		}
		
		List<WebElement>preceding_siblingClass = driver.findElements(By.xpath("//a[text()='nopCommerce new release!']//ancestor::div/preceding-sibling::div[@class='news-item']"));
		for (WebElement webElement : preceding_siblingClass) {
			System.out.println("preceding_siblingClass:"+ webElement.getText());
		}
		
		driver.quit();

	}

}
