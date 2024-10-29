package testCase;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageContactPage;

public class ManageContactPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	ManageContactPage mc;

	@Test
	public void editContactDetails() throws Throwable {
		lp = new LoginPage(driver);
		hp = lp.loginUsingExcel();
		mc =hp.clickOnManageContactTab();
		mc.editContactData();
		boolean alertFlag = mc.getAlertText();
		assertEquals(alertFlag, true);
		mc.closeAlert();
	}
}
