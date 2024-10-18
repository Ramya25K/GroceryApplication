package testCase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	WebDriver driver;
 
  @BeforeMethod
  public void beforeMethod() {
	  	driver = new ChromeDriver();
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
