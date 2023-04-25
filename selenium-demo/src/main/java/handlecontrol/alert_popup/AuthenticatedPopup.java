package handlecontrol.alert_popup;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticatedPopup {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

	
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");

		// Dùng list.size() để kiếm tra phần tử có tồn tại hay không, khi element chỉ xuất hiện trong trường hợp đúng
		List<WebElement> element = driver.findElements(By.xpath("//p[contains(text(),'Congratulations!')]"));

		if (element.size()>0) {
			String text = element.get(0).getText();

			if (text.contains("Congratulations")) {
				System.out.println("successful login");
			} else {
				System.out.println("login failed");
			}
		}

	}

}
