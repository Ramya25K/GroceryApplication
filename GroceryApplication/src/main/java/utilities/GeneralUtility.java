package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtility {

	public String selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public String selectDropdownWithIndex(WebElement element, int indexNumber) {
		Select object = new Select(element);
		object.selectByIndex(indexNumber);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public void selectDropdownWithVisibleText(WebElement element, String text) {
		Select object = new Select(element);
		object.selectByVisibleText(text);
		WebElement selectedElement = object.getFirstSelectedOption();
		selectedElement.click();
	}

	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public void clickJavaScriptExecutorByScroll(WebDriver driver, List<WebElement> elements, int index) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", elements.get(index));
	}

	public void sendValueUsingJavaScriptAndBlur(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '" + value + "'", element);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].blur()", element);
	}

	public void clickOnElement(WebElement element) {
		element.click();
	}

	public void enterText(WebElement element, String value) {
		element.sendKeys(value);
	}

	public void clearText(WebElement element) {

		element.clear();
	}

	public void navigateToBack(WebDriver driver) {

		driver.navigate().back();
	}

	public void navigateToForward(WebDriver driver) {

		driver.navigate().forward();
	}

	public void navigateToRefresh(WebDriver driver) {

		driver.navigate().refresh();
	}

	public void navigateTo(WebDriver driver, String url) {

		driver.navigate().to(url);
	}

	public boolean isElementDisplayed(WebElement element) {
		return (element.isDisplayed());
	}

	public boolean isElementEnabled(WebElement element) {
		return (element.isEnabled());
	}

	public boolean isElementSelected(WebElement element) {
		return (element.isSelected());

	}

	public void scrollBy(WebDriver driver) {
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("window.scrollBy(0,1000)");

	}
	public int randon(int limit) {
		Random random = new Random();
		// int limit = 1000;
		int randomNumber = random.nextInt(limit);
		return randomNumber;
	}
	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}
	
	public void scrollToBottom(WebDriver driver) {
	    JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	public void scrollToElement(WebDriver driver, WebElement element) {
	    JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public void clickUsingJavaScript(WebDriver driver, WebElement element) {
	    JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", element);
	}

}