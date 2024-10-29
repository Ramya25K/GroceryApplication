package testCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import elementRepository.CategoryPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;

public class CategoryPageTest extends BaseClass {

	LoginPage lp;
	HomePage hp;
	CategoryPage cp;

	@Test(enabled = false)
	public void EditNewCategory() throws IOException, Throwable {
		lp = new LoginPage(driver);
		hp = lp.loginUsingExcel();
		cp = hp.clickOnCategoryTab();
		String catText = cp.readTableElement(3, 1);
		cp.clickOnEditButton(3);
		String editedCatText = cp.editTextCatgoryDetails();
		assertNotEquals(editedCatText, catText, "Category Text are same-(not edited)");
		cp.clickOnEditButton(6);
		boolean actualflag = cp.editImageCategoryDetails();
		assertEquals(actualflag, true, "The image category details should be updated.");
	}

	@Test
	public void checkForStatus() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.loginUsingExcel();
		cp = hp.clickOnCategoryTab();
		cp.toggleToActive(1);// to make active
		boolean alertflag1 = cp.alertMessage();
		assertEquals(alertflag1, true, "The category status should be updated.-To-active");
		cp.toggleToInActive(2);// to make inactive
		boolean alertflag2 = cp.alertMessage();
		assertEquals(alertflag2, true, "The category status should be updated.-To InActive");
	}
}
