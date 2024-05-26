package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {


	@Given("I am a user for XYZ app")
	public void i_am_a_user_for_xyz_app() {
	    System.out.println("I am in given step");
	}
	@When("I enter correct username and password")
	public void i_enter_correct_username_and_password() {
	    System.out.println("I am in When step");
	}
	@Then("I should be able to login")
	public void i_should_be_able_to_login() {
	    System.out.println("I am in Then step");
	}
	
	@Given("I am a user for {string} app")
	public void i_am_a_user_for_app(String appName) {
	    System.out.println(appName);
	}
	@When("I enter incorrect {string} and {string}")
	public void i_enter_incorrect_and(String userId, String password) {
	   System.out.println(userId);
	   System.out.println(password);
	}
	@Then("I should not be able to login")
	public void i_should_not_be_able_to_login() {
	    System.out.println("Unsuccessful!");
	}
}
