package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends BaseClass{
	LoginPage lp;
	HomePage hp;

	
	
	@DataProvider(name = "invalidLoginData")
	public Object[][] invalidLoginData() {
        return new Object[][] {
            {"admin", "adminss"}, // Correct username, incorrect password
            {"adminss", "admin"}, // Incorrect username, correct password
            {"adminss", "adminss"} // Both incorrect
        };
    }
	
	
	 @Test
  public void verifyLoginWithValidData() throws IOException 
  {
	  lp = new LoginPage(driver);
	  hp = new HomePage(driver);
	  lp.loginUsingExcel(); // calling loginUsingExcel Function in LoginPage
	  String actual = hp.getHomePageText();
	  String expected = "7rmart supermarket1";
	  Assert.assertEquals(actual, expected, Constant.lp_verifyLoginWithValidData);//Assertion is used to compare the values(actual == expected)
  }
  
  @Test(enabled=false,dataProvider = "invalidLoginData")
  public void verifyLoginWithInvalidData(String username,String password) 
  {
	  lp = new LoginPage(driver);
	  hp = new HomePage(driver);
	  lp.sendLoginDetails(username,password);
	  String actual = lp.getAlertText();
	  String expected = "Alert!";
	  Assert.assertEquals(actual, expected, Constant.lp_verifyLoginWithInvalidData);
	
  }
  
  
 
}
