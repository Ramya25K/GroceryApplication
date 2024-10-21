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
	
	@DataProvider(name = "validLoginData")
    public Object[][] validLoginData() throws IOException {
        String filepath = "/src/main/resources/LoginData.xlsx"; // Path to Excel file
        String sheetName = "Sheet1"; // Name of sheet 
        Object[][] data = new Object[1][2]; // 2 columns for username and password

        // Read data from the second row (index 1)
        data[0][0] = ExcelUtility.getStringData(1, 0, filepath, sheetName); // Username from A2
        data[0][1] = ExcelUtility.getStringData(1, 1, filepath, sheetName); // Password from B2

        return data;
    }
	
	 @Test(dataProvider = "validLoginData")
  public void verifyLoginWithValidData(String username,String password) 
  {
	  lp = new LoginPage(driver);
	  hp = new HomePage(driver);
	  lp.sendLoginDetails(username,password);
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
	  Assert.assertEquals(actual, expected, Constant.lp_verifyLoginWithInvalidData);
	
  }
  
  
 
}
