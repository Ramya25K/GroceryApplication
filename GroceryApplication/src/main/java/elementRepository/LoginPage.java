package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
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
	
	public void sendLoginDetails(String userName, String password)
	{
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		signInButton.click();
	}
	
	public String getAlertText() 
	{
		return alertText.getText();
	}

	
	
}
