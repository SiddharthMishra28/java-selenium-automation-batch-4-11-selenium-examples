package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.UIAutomationUtils;

public class LoginPage extends UIAutomationUtils{
	
	public By userIdField = By.name("uid");
	public By passwordField = By.name("password");
	public By loginButton = By.name("btnLogin");
	public By resetButton = By.name("btnReset");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void login(String url, String username, String password) {
		this.navigateToUrl(url);
		this.typeIntoInput(this.userIdField, username);
		this.typeIntoInput(this.passwordField, password);
		this.clickElement(loginButton);
	}
	
	public void reset(String url, String username, String password) {
		this.navigateToUrl(url);
		this.typeIntoInput(this.userIdField, username);
		this.typeIntoInput(this.passwordField, password);
		this.clickElement(resetButton);
	}
	
}
