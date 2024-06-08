package temp;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Hooks {
	
	public Engine engine;
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("...");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("...");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("...");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("...");
	}
}
