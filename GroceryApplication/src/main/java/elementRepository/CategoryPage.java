package elementRepository;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtility;
import utilities.WaitUtilities;

public class CategoryPage {
	WebDriver driver;
	GeneralUtility gu = new GeneralUtility();
	WaitUtilities wu = new WaitUtilities(driver);

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//i[@class='nav-icon fas fa-file-o']//following-sibling::p[text()='Category']")
	WebElement categoryTab;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement inputCatText;
	@FindBy(xpath ="//button[@class='btn btn-danger']")
	WebElement updateButton;
	@FindBy(xpath ="(//input[@name='top_menu'])[1]")
	WebElement yesCheck;
	@FindBy(xpath = "//span[@class='fas fa-trash-alt']")
	WebElement delButton;
	@FindBy(xpath ="//input[@id='main_img']")
	WebElement chooseFileButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertText;
	@FindBy(xpath ="//span[@class='badge bg-warning']")
	WebElement inactiveStatus;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertSText;
	
	
	public void clickOnCategoryTab() {
		gu.clickOnElement(categoryTab);
	}
	public String readTableElement(int row, int column) {
		String path = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + row + "]//td["
				+ column + "]";
		WebElement element = driver.findElement(By.xpath(path));
		//System.out.println("Text"+element.getText());
		return element.getText();
	}
	
	public void clickOnEditButton(int row) {
		String editButtonPath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + row + "]//td[4]//a[@class='btn btn-sm btn btn-primary btncss']";
		WebElement editElement = driver.findElement(By.xpath(editButtonPath));
		gu.clickOnElement(editElement);	
	}
	
	public String editTextCatgoryDetails() {
		gu.clearText(inputCatText);
		String editedCatText = "Books"+gu.randon(100);
		gu.enterText(inputCatText, editedCatText);
		gu.scrollToBottom(driver);
		gu.clickUsingJavaScript(driver, yesCheck);
		gu.clickUsingJavaScript(driver, updateButton);
		return editedCatText;
}
	
	public boolean editImageCategoryDetails() throws InterruptedException {
		gu.scrollToBottom(driver);
		gu.clickUsingJavaScript(driver, delButton);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		gu.scrollToBottom(driver);
		String filePath = "C:\\Users\\User\\Desktop\\Books.jpg";
		gu.enterText(chooseFileButton, filePath);
		gu.clickUsingJavaScript(driver, updateButton);
		boolean flag = alertText.getText().contains("Category Updated Successfully");
		return flag;
	}
	

	public void toggleToActive(int row) {
		String inactiveStatusPath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+row+"]//td[3]//span[@class='badge bg-warning']"; // For 'Inactive'
		WebElement inactiveStatus = driver.findElement(By.xpath(inactiveStatusPath));
		gu.clickUsingJavaScript(driver, inactiveStatus);
	}
	
	public void toggleToInActive(int row) {
		String activeStatusPath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+row+"]//td[3]//span[@class='badge bg-success']"; // For 'Active'
		WebElement activeStatus = driver.findElement(By.xpath(activeStatusPath));
		gu.clickUsingJavaScript(driver, activeStatus);
	}
	
	public boolean alertMessage() {
		 boolean flag = alertSText.getText().contains("Category Status Changed Successfully");
			return flag;
	}

}
