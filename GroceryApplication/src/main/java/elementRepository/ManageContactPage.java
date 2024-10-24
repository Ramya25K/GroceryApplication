package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtility;
import utilities.WaitUtilities;

public class ManageContactPage {
	WebDriver driver;
	GeneralUtility gu = new GeneralUtility();
	WaitUtilities wu = new WaitUtilities(driver);

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-fa fa-address-book-o']//following-sibling::p[text()='Manage Contact']")
	WebElement manageContactTab;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement contactEditButton;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailTextBox;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertText;
	@FindBy(xpath = "//button[@class='close']")
	WebElement closeButton;

	public void clickOnManageContactTab() {
		gu.clickOnElement(manageContactTab);
	}

	public void editContactData() throws Throwable {
		gu.clickOnElement(contactEditButton);
		gu.clearText(emailTextBox);
		gu.enterText(emailTextBox, "testing123@test.com");
		gu.scrollToBottom(driver);
		wu.waitForElementToBeClickable(updateButton, 5);
		// gu.clickOnElement(updateButton);
		gu.clickUsingJavaScript(driver, updateButton);
	}

	public boolean getAlertText() {
		boolean flag = alertText.getText().contains("Contact Updated Successfully");
		return flag;
	}

	public void closeAlert() {
		gu.clickOnElement(closeButton);
	}

}
