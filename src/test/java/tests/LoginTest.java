package tests;

import org.testng.annotations.Test;

import config.Hooks;
import pages.LoginPage;

public class LoginTest extends Hooks{

	
	@Test
	public void LoginIntoPortal_valid_credentials() {
		LoginPage page = new LoginPage(driver);
		page.login("https://demo.guru99.com/V1/index.php", "mngr542003", "nyseqAn");
	}
	
	@Test
	public void loginPortal_reset_function_test() {
		LoginPage page = new LoginPage(driver);
		page.reset("https://demo.guru99.com/V1/index.php", "mngr542003", "nyseqAn");
	}
}
