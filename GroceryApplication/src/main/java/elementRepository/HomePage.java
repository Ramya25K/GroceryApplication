package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtility;

public class HomePage {
	WebDriver driver;
	GeneralUtility gu = new GeneralUtility();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	WebElement homePageText;
	@FindBy(xpath = "//li//p[text()='Sub Category']")
	WebElement subCategoryTab;
	@FindBy(xpath = "//i[@class='nav-icon fas fa-file-o']//following-sibling::p[text()='Category']")
	WebElement categoryTab;
	@FindBy(xpath = "//i[@class='nav-icon fas fa-fa fa-address-book-o']//following-sibling::p[text()='Manage Contact']")
	WebElement manageContactTab;
	@FindBy(xpath = "//i[@class='nav-icon fas fa-']//following-sibling::p[text()='Manage News']")
	WebElement manageNewsTab;

	public String getHomePageText() {
		return homePageText.getText();
	}

	public SubCategory clickOnSubCategoryButton() {
		gu.clickOnElement(subCategoryTab);
		return new SubCategory(driver);
	}

	public CategoryPage clickOnCategoryTab() {
		gu.clickOnElement(categoryTab);
		return new CategoryPage(driver);
	}

	public ManageContactPage clickOnManageContactTab() {
		gu.clickOnElement(manageContactTab);
		return new ManageContactPage(driver);
	}

	public ManageNewsPage clickOnManageNewsTab() {
		gu.clickOnElement(manageNewsTab);
		return new ManageNewsPage(driver);
	}
}
