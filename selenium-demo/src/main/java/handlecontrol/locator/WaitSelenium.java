package  handlecontrol.locator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		// Set thời gian ngầm định là 10 s. Defaul không gọi là 0s
		// "đợi ngầm”, có nghĩa là nó sẽ luôn tìm kiếm Element trong 1 khoảng thời gian ngầm định trước khi văng ra No Such Element Exception
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		
		//  “cố tình đợi”, Explicit wait được sử dụng để tạm dừng việc thực thi script cho đến khi một điều kiện cụ thể được chỉ định được đáp ứng hoặc thời gian tối đa đã trôi qua.
		// Explicit wait chỉ được áp dụng cho một trường hợp cụ thể thay vì dùng cho toàn bộ các lệnh trong script.
		/*
		 * 
		 * Nếu chúng ta đang sử dụng kết hợp cả hai loại Wait trên thì có 2 trường hợp như sau:

			Nếu Explicit Wait dùng câu lệnh tìm kiếm là đối tượng By thì Explicit Wait sẽ được ưu tiên đầu tiên.
			Nếu Explicit Wait dùng câu lệnh tìm kiếm là findElement thì Implicit Wait sẽ được ưu tiên đầu tiên.
			
			
		 */ 
		//Explicit wait
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Website Testing')]")));

		driver.findElement(By.xpath("//h3[contains(text(),'Website Testing')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Anh Tester')]")));
		wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//div[@id= 'forgotPass'"), "text to be found"));
		// Fluent Wait
		
	
		
	}

}
