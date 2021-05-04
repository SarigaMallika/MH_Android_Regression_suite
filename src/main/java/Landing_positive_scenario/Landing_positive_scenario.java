package Landing_positive_scenario;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import Reusable_functions.Generic_functions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Landing_positive_scenario extends Generic_functions{
	static boolean value;
	
	/*TC_001 Validate that the user is navigated to Welcome page */
	@Given("User opens application and User should be navigated to Welcome page")
	public static void landing_welcome_positive_tc_001() throws IOException {
		try {
			app_launch();
			page_wait(40);
			value = driver.findElement(By.xpath(OR_reader("Object Locator", "welcome_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (IOException e) {
			e.printStackTrace();
			takeScreenShot("landing_welcome_positive_tc_001");
		}
	}

	/*TC_002 Validate that the user is able to click on 'Sign Up' button and navigate to 'Sign Up' page */
	@When("User clicks on the Sign Up button and navigate to Sign Up page")
	public static void landing_welcome_positive_tc_002() throws IOException {
		try {
			page_wait(60);
			click("SignUp");
			page_wait(10);
			value = driver.findElement(By.xpath(OR_reader("Object Locator", "signup_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(50);
			click("Backarrow");		
		}catch(IOException e) {
			e.printStackTrace();
			takeScreenShot("landing_welcome_positive_tc_002");
		}
	}

	/*TC_003 Validate that the  user is able to click on 'Login' button and navigated to login page*/
	@When("User clicks on Login button and navigate to Login page")
	public static void landing_welcome_positive_tc_003() throws IOException {
		try {
			page_wait(40);
			click("Login");
			page_wait(60);
			value = driver.findElement(By.xpath(OR_reader("Object Locator", "login_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(10);
			page_close();
		}catch(IOException e) {
			e.printStackTrace();
			takeScreenShot("landing_welcome_positive_tc_003");
		}
	}
}