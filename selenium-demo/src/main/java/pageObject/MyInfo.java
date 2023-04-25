package pageObject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyInfo extends BasePage {
	public MyInfo(WebDriver driver) {
		super(driver);

	}

	// Locator
	@FindBy(xpath = "//img[@class='employee-image']")
	WebElement imgLogo;

	@FindBy(xpath = "//div[@class='employee-image-wrapper']//img[@alt='profile picture']")
	WebElement imgSelectorLogo;
	@FindBy(xpath = " //button[normalize-space()='Save']")
	WebElement btnSave;

	// Action
	public void clickLogoIcon() {
		imgLogo.click();

	}

	public void clickSelectImage(String filename) throws InterruptedException {
		imgSelectorLogo.click();
		String filePath = System.getProperty("user.dir")+"\\screenshots\\"+filename;
		// Khởi tạo Robot class
		Robot rb = null;
		try {
			rb = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		// Copy File path vào Clipboard
		StringSelection str = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		Thread.sleep(1000);

		// Nhấn Control+V để dán
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		// Xác nhận Control V trên
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		Thread.sleep(1000);

		// Nhấn Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(4000);

	}

	public void Save() {
		btnSave.click();

	}

}
