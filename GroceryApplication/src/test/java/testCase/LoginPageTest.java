package testCase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;

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
  public void verifyLoginWithValidData() 
  {
	  lp = new LoginPage(driver);
	  hp = new HomePage(driver);
	  lp.sendLoginDetails("admin","admin");
	  String actual = hp.getHomePageText();
	  String expected = "7rmart supermarket";
	  Assert.assertEquals(actual, expected, Constant.lp_verifyLoginWithValidData);//Assertion is used to compare the values(actual == expected)
  }
  
  @Test(dataProvider = "invalidLoginData")
  public void verifyLoginWithInvalidData(String username,String password) 
  {
	  lp = new LoginPage(driver);
	  hp = new HomePage(driver);
	  lp.sendLoginDetails(username,password);
	  String actual = lp.getAlertText();
	  String expected = "Alert!";
	  Assert.assertEquals(actual, expected, "Alert text not as expected");
	
  }
  
  
 
}
