package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	@FindBy(xpath="//span[text()='7rmart supermarket']")
	WebElement homePageText;
	@FindBy(xpath = "//li//p[text()='Sub Category']")
	WebElement subCategoryButton;
	
	public String getHomePageText()
	{ 
		return homePageText.getText();	
	}
	
	public void clickOnSubCategoryButton()
	{
		subCategoryButton.click();
	}
}
