package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtility;

public class SubCategory {

	WebDriver driver;
	// String subCategoryName; //instance variable
	GeneralUtility gu = new GeneralUtility(); // to use general utility class functions here, we need to create its
												// object

	public SubCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newSubCategoryButton;
	@FindBy(id = "cat_id")
	WebElement newCategoryDropDown;
	@FindBy(xpath = "//select[@class='form-control selectpicker']//option[text()='Apple']")
	WebElement newCategoryDropText;
	@FindBy(id = "subcategory")
	WebElement subCategoryText;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//child::h5")
	WebElement alertFailure;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr")
	List<WebElement> subCategoryTableSize;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[5]//i[@class='fas fa-edit']")
	WebElement rowEditButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	WebElement newSubCatgoryText;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[2]")
	WebElement newCatgoryText;
	@FindBy(xpath = "//button[text()='Update']")
	WebElement rowUpdateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlertMessage;
	@FindBy(xpath = "//i[@class=' fa fa-search']")
	WebElement searchButton;
	@FindBy(xpath = "//select[@id='un']")
	WebElement searchCatText;
	@FindBy(xpath = "//input[@name='ut']")
	WebElement inputUpdateSubCatText;
	@FindBy(xpath = "//i[@class='fa fa-search']")
	WebElement updateSearchButton;
	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	WebElement resultNotFound;
	@FindBy(xpath ="//i[@class='fas fa-trash-alt']")
	WebElement deleteButton;

	public void addNewSubCategory() {
		newSubCategoryButton.click();
	}

	public void selectCategoryDropDown() {
		newCategoryDropDown.click();
	}

	public String selectCategoryText() {
		newCategoryDropText.click();
		WebElement selectedOptionElement = driver
				.findElement(By.xpath("//select[@class='form-control selectpicker']//option[text()='Apple']"));
		String selectedOptionText = selectedOptionElement.getText();
		return selectedOptionText;
	}

	public String enterSubCategoryDetails() {
		String subCategoryName = "Fruits" + gu.generateCurrentDateAndTime();
		subCategoryText.sendKeys(subCategoryName);
		return subCategoryName;
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

	public boolean getAlertFailureText() {
		String message=alertFailure.getText();;
		boolean alertmessage = message.contains("Subcategory already exists");
		return alertmessage;
	}

	public String readSubCategoryTableElement(int row, int column) {
		String path = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + row + "]//td["
				+ column + "]";
		WebElement element = driver.findElement(By.xpath(path));
		// System.out.println("Text"+element.getText());
		return element.getText();
	}

	public void clickOnEditButton() {
		rowEditButton.click();

	}

	public String newSubCatgoryText() {
		return newSubCatgoryText.getText();
	}

	public String newCatgoryText() {
		return newCatgoryText.getText();
	}

	public void clickOnUpdateButton() {
		rowUpdateButton.click();
	}

	public String editSubCategoryDetails(String newText) {
		String randomText = gu.generateCurrentDateAndTime();
		String combinedText = newText + randomText;

		gu.clearText(subCategoryText);
		gu.enterText(subCategoryText, combinedText); // Enter the new text
		return combinedText;
	}

	public boolean updatedAlertMessage() {
		String message = successAlertMessage.getText();
		boolean alertmessage = message.contains("Sub Category Updated Successfully");
		return alertmessage;

	}

	public void searchSubCatAfterUpdate(String oldcatText, String updatedSubCatgorytext) {
		gu.clickOnElement(searchButton);
		searchCatText.click();
		gu.selectDropdownWithVisibleText(searchCatText, oldcatText);
		inputUpdateSubCatText.sendKeys(updatedSubCatgorytext);
		updateSearchButton.click();

	}

	public boolean searchSubCatBeforeUpdateValue(String oldcatText, String oldSubCatText) {
		gu.clickOnElement(searchButton);
		searchCatText.click();
		gu.selectDropdownWithVisibleText(searchCatText, oldcatText);
		inputUpdateSubCatText.clear();
		inputUpdateSubCatText.sendKeys(oldSubCatText);
		updateSearchButton.click();
		boolean searchMessage = resultNotFound.getText().contains("RESULT NOT FOUND");
		return searchMessage;
	}
	
	public boolean deleteCatgoryRow()
	{
		deleteButton.click();
		driver.switchTo().alert().accept();
		boolean deleteMessage = successAlertMessage.getText().contains("Sub Category Deleted Successfully");
		return deleteMessage;
	}
	public boolean resultNotFoundMessage(){
		boolean deletemessage=resultNotFound.getText().contains("RESULT NOT FOUND");
		return deletemessage;

	}

}
