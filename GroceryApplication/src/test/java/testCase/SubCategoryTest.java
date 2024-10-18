package testCase;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.SubCategory;

public class SubCategoryTest extends BaseClass {

	LoginPage lp;
	HomePage hp;
	SubCategory sc;
	String subCatName;
	String catName;

	@Test
	public void verifyNewSubCategory() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		sc = new SubCategory(driver);
		lp.sendLoginDetails("admin", "admin");
		hp.clickOnSubCategoryButton(); // Click on subcategory button on homepage
		sc.addNewSubCategory(); // Click on New button on Subcategory Page
		sc.selectCategoryDropDown(); // Click on Select Category from SubCategory Page
		catName = sc.selectCategoryText(); // Click and select the text from Subcategory Page
		subCatName = sc.enterSubCategoryDetails(); // Enter the text in subcategory column in subcategory page
		sc.clickOnSaveButton();
		boolean actualFailure = sc.getAlertFailureText(); // Get the failure alert text
		assertEquals(actualFailure, false, "Subcategory already exists-Select other");
		hp.clickOnSubCategoryButton();
		String actualSubCatName = sc.readSubCategoryTableElement(1, 1);
		String expectedSubCatName = subCatName;
		assertEquals(actualSubCatName, expectedSubCatName, "Subcategory is not as expected");
	}
	
	
	@Test
	public void verifyEditSubCategory() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		sc = new SubCategory(driver);
		lp.sendLoginDetails("admin", "admin");
		hp.clickOnSubCategoryButton();
		String oldSubCatText = sc.newSubCatgoryText(); // copying the added subcatgory value before edit
		String oldCatText = sc.newCatgoryText(); // // copying the added catgory value before edit
		sc.clickOnEditButton();// click on edit button
		System.out.println("Before Edit=" + oldSubCatText);
		String newSubCatText = sc.editSubCategoryDetails("Red");// updating the value of subcategory
		sc.clickOnUpdateButton(); // click on update button
		System.out.println("After Edit=" + newSubCatText);
		boolean actualAlertMessage = sc.updatedAlertMessage();
		assertEquals(actualAlertMessage, true);

		// Checking if the value is updated
		String updatedSubCatgorytext = sc.readSubCategoryTableElement(1, 1);
		System.out.println("updatedSubCatgorytext" + updatedSubCatgorytext);
		Assert.assertEquals(updatedSubCatgorytext, newSubCatText, "SubCategory not edited to the table");
		// Searching for the updated subcatgory name
		sc.searchSubCatAfterUpdate(oldCatText, updatedSubCatgorytext);
		boolean searchMessage = sc.searchSubCatBeforeUpdateValue(oldCatText, oldSubCatText);
		assertEquals(searchMessage, true, "Result not found");

	}
	
	@Test
	public void verifyDeleteSubCatgory() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		sc = new SubCategory(driver);
		lp.sendLoginDetails("admin", "admin");
		hp.clickOnSubCategoryButton();
		String beforeDelCatName = sc.newCatgoryText();//copying the catgory name before delete
		String beforeDelSubCatName =sc.newSubCatgoryText(); //copying the subcatgory name before delete
		boolean deletemessage= sc.deleteCatgoryRow(); //click on delete button
		sc.searchSubCatAfterUpdate(beforeDelCatName, beforeDelSubCatName);
		boolean delMessageValue = sc.resultNotFoundMessage();
		Assert.assertEquals(delMessageValue, true,"Result not found");
		
		
	}
}
