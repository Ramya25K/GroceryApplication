package elementRepository;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.GeneralUtility;
import utilities.WaitUtilities;

public class ManageNewsPage {
	WebDriver driver;
	GeneralUtility gu = new GeneralUtility();
	WaitUtilities wu = new WaitUtilities(driver);
	

	public ManageNewsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	@FindBy(xpath ="//i[@class='nav-icon fas fa-']//following-sibling::p[text()='Manage News']")
	WebElement manageNewsTab;
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']")
	WebElement newManageNewsButton;
	@FindBy(xpath ="//textarea[@id='news']")
	WebElement enterNewsDetails;
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertText;
	@FindBy(xpath ="(//a[@class='btn btn-sm btn btn-primary btncss'])[1]")
	WebElement editButton;
	@FindBy(xpath ="//button[@class='btn btn-danger']")
	WebElement updateButton;
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath ="//input[@class='form-control']")
	WebElement searchTextBox;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement editSearchButton;
	@FindBy(xpath ="//center[text()='.........RESULT NOT FOUND.......']")
	WebElement errorText;
	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-danger btncss'])[1]")
	WebElement deleteButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlertMessage;
	
	
	public void clickOnManageNewsTab() {
		gu.clickOnElement(manageNewsTab);
	}
	
	public void clickOnNewManageNewsButton() {
		gu.clickOnElement(newManageNewsButton);
	}
	
	public String enterNewsInformation(String data,boolean isEdit) {
		if (isEdit) {
	        int randomNumber = gu.randon(100);
	        data="Edited Text";
	        data = data + randomNumber; // Append the random number to the existing data
	        gu.clearText(enterNewsDetails);
	        gu.enterText(enterNewsDetails, data);
			gu.clickOnElement(updateButton);
	    }
		else {
		gu.enterText(enterNewsDetails, data);
		gu.clickOnElement(saveButton);
		}
		return data;
	}
	
	public boolean getAlertText() {
		String message=alertText.getText();
		boolean alertmessage = message.contains("News Created Successfully");
		return alertmessage;
	 
}
	public String readTableElement(int row, int column) {
		String path = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + row + "]//td["
				+ column + "]";
		WebElement element = driver.findElement(By.xpath(path));
		// System.out.println("Text"+element.getText());
		return element.getText();
	}
	
	public void clickOnEditButton() {
		gu.clickOnElement(editButton);
	}
	
	public void clickOnSearchButton() {
		gu.clickOnElement(searchButton);
	}
	
	public boolean searchNewsText(String newsData) {
		gu.enterText(searchTextBox, newsData);
		gu.clickOnElement(editSearchButton);
		boolean searchMessage = errorText.getText().contains("RESULT NOT FOUND");
		return searchMessage;
	}
	
	public boolean deleteNewsRow()
	{
		deleteButton.click();
		driver.switchTo().alert().accept();
		boolean deleteMessage = successAlertMessage.getText().contains("News Deleted Successfully");
		return deleteMessage;
	}
	

}

