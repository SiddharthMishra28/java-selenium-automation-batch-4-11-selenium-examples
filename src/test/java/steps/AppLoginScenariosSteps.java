package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AppLoginScenariosSteps {
	
	@Given("I am a user of {string}")
	public void i_am_a_user_of(String appName) {
	    System.out.println("Navigating to "+appName);
	}
	@When("I enter {string} and {string}>")
	public void i_enter_and(String userId, String password) {
	    System.out.println("Logging in with user "+userId+" password "+password);
	}
	@Then("I should be able to process the information")
	public void i_should_be_able_to_process_the_information() {
	    System.out.println("Login outcome");
	}
}
