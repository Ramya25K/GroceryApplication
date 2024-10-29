package testCase;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageNewsPage;
import utilities.WaitUtilities;

public class ManageNewsPageTest extends BaseClass {

	LoginPage lp;
	HomePage hp;
	ManageNewsPage mn;

	@Test
	public void addNewsInformation() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.loginUsingExcel();
		mn = hp.clickOnManageNewsTab();
		mn.clickOnNewManageNewsButton();
		String newsData = mn.enterNewsInformation("This is a Grocery Application currently undergoing testing", false);// false-
																														// add
																														// news
		boolean actualText = mn.getAlertText();
		boolean expectedText = true; // expected result should be true
		assertEquals(actualText, expectedText, "Error in saving"); // if the save doesnt work, it will print "Error in
																	// Saving".
	}

	@Test
	public void editNewsInformation() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.loginUsingExcel();
		mn = hp.clickOnManageNewsTab();
		String textToEdit = mn.readTableElement(1, 1); // copying the text before edit
		mn.clickOnEditButton();
		String editedNewsData = mn.enterNewsInformation("This is a Grocery Application currently undergoing testing",
				true);// true - edit news

		// Check if the value is updated
		String readEditedData = mn.readTableElement(1, 1);
		System.out.println("UpdatedNewText" + readEditedData);
		Assert.assertEquals(readEditedData, editedNewsData, "News not edited");
		// Checking if the old newsText is present after editing
		mn.clickOnSearchButton();
		boolean actualSearchResult = mn.searchNewsText(textToEdit);
		assertEquals(actualSearchResult, true, "Search was unsuccessful");
	}

	@Test
	public void deleteNewsInformation() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.loginUsingExcel();
		mn = hp.clickOnManageNewsTab();
		String textToDelete = mn.readTableElement(1, 1); // copying the text before edit
		mn.deleteNewsRow();
		// Checking if the deleted newsText is present after deleting
		mn.clickOnSearchButton();
		boolean actualSearchResult = mn.searchNewsText(textToDelete);
		assertEquals(actualSearchResult, true, "Delete was unsuccessful");

	}
}