package handlecontrol.frame;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleInnerFramesDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();

		// Frame1
		WebElement frm1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frm1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("11111");

		driver.switchTo().defaultContent(); // Chuyền về page default là page chung

		// Frame3
		WebElement frm3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frm3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("33333");

		// inner frame chuyển đến iframe bên trong frame3
		driver.switchTo().frame(0);

		driver.findElement(By.cssSelector("div.AB7Lab.Id5V1")).click(); // select first radio button in frame
		
		Thread.sleep(4000);
		driver.switchTo().defaultContent();
		
		
		// frame2
		WebElement frm2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frm2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("2222");

		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		// frame 4

		// frame 5
		
		driver.quit();


	}

}
