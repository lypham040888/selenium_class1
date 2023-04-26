package pageObject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class MyInfo extends BasePage {
	public MyInfo(WebDriver driver) {
		super(driver);

	}

	// Locator

	// Info
	@FindBy(name = "firstName")
	WebElement txtFirstName;

	@FindBy(name = "middleName")
	WebElement txtMiddleName;

	// Upload image
	@FindBy(xpath = "//img[@class='employee-image']")
	WebElement imgLogo;

	@FindBy(xpath = "//div[@class='employee-image-wrapper']//img[@alt='profile picture']")
	WebElement imgSelectorLogo;
	@FindBy(xpath = " //button[normalize-space()='Save']")
	WebElement btnSave;
	@FindBys(@FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"))
	List<WebElement> listMessageFindBy;

	By errorMessagePath = By
			.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']");

	// Action
	public void clickLogoIcon() {
		imgLogo.click();

	}

	public void clickSelectImage(String filename) throws InterruptedException {
		imgSelectorLogo.click();
		String filePath = System.getProperty("user.dir") + "\\screenshots\\" + filename;
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

		Thread.sleep(3000);

		// Nhấn Control+V để dán
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		// Xác nhận Control V trên
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		Thread.sleep(3000);

		// Nhấn Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(5000);

	}

	public void SaveInfo() {
		txtFirstName.clear();
		txtFirstName.sendKeys("Auto test");
		txtMiddleName.clear();
		txtMiddleName.sendKeys("Middle Name");
		btnSave.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void SaveUploadImage() {
		btnSave.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void validateUpload(String expectValue) {
		// List<WebElement> lstMessage = getDriver().findElements(errorMessagePath);

		if (listMessageFindBy != null && listMessageFindBy.size() > 0) {
			for (WebElement webElement : listMessageFindBy) {
				SoftAssert sa = new SoftAssert();
				sa.assertEquals(webElement.getText(), expectValue, "File upload not allow");
				sa.assertAll();// Bắt buộc
			}

		}

	}

}
