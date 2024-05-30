package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import utils.UIAutomationUtils;

public class LoginTest {
	
	LoginPage page = new LoginPage();
	UIAutomationUtils utils = new UIAutomationUtils();
	
	@Test
	public void LoginIntoPortal() {
		utils.navigateToUrl("https://demo.guru99.com/V1/index.php");
		utils.typeIntoInput(page.userIdField, "mngr571718");
		utils.typeIntoInput(page.passwordField, "patygYh");
		utils.clickElement(page.loginButton);
	}
}
