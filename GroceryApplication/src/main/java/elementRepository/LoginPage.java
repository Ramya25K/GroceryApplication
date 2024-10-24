package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcelUtility;
import utilities.GeneralUtility;

public class LoginPage {

	WebDriver driver;
	 ExcelUtility eu = new ExcelUtility(); // Create an instance of ExcelUtilities
	 GeneralUtility gu = new GeneralUtility();
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	@FindBy(xpath ="//input[@name ='username']")
	WebElement userNameField;
	@FindBy(xpath = "//input[@name ='password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInButton;
	@FindBy(xpath ="//div[@class='alert alert-danger alert-dismissible']//child::h5")
	WebElement alertText;
	
	public HomePage sendLoginDetails(String userName, String password)
	{
		gu.enterText(userNameField, userName);
		gu.enterText(passwordField,password);
		gu.clickOnElement(signInButton);
		return new HomePage(driver); //for chaining of pages
	}
	
	public String getAlertText() 
	{
		return alertText.getText();
	}

	public HomePage loginUsingExcel() throws IOException
	{
		String username = eu.getStringData(1, 0, "Sheet1");
		gu.enterText(userNameField, username);

	     String password = eu.getStringData(1, 1, "Sheet1");
	     gu.enterText(passwordField,password);
	     gu.clickOnElement(signInButton);
	     return new HomePage(driver); //for chaining of pages(calling hp constructor)
	}
	
	
}
