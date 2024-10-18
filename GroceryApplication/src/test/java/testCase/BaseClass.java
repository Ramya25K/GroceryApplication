package testCase;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	WebDriver driver;
 
  @BeforeMethod
  @Parameters("browser")
  public void beforeMethod(String browserName) {
	  if(browserName.equals("Chrome"))
	  {
	  	driver = new ChromeDriver();
	  }
	  else if(browserName.equals("firefox"))
	  {
		  driver = new FirefoxDriver();
	  }
	    driver.get("https://groceryapp.uniqassosiates.com/admin/login");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
  }

//  @AfterMethod
//  public void afterMethod() {
//	  driver.quit();
//	  
//  }

}
