package Forgot_password_positive_scenario;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import Reusable_functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Forgot_password_positive_scenario extends Generic_functions{
	static boolean value;
	
	/* Application  is launching using appium, navigating to Landing Welcome Page and clicking on login button  */
	@Given("App is open")
	public void app_launching() {
		try {
			app_launch();
			page_wait(4);
			value = driver.findElement(By.xpath(OR_reader("Object Locator", "welcome_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* TC_001 -Validate that the  user should  able to enter 10 digit number in "Phone Number" field*/
	@Then("Click on Login button then click on Forgot Password link and enter phone number in Phone number field")
	public static void forgot_positive_tc_001() throws Exception {
		page_wait(5);
		click("Login");
		page_wait(5);
		value = driver.findElement(By.xpath(OR_reader("Object Locator", "login_page_title"))).isDisplayed();
		Assert.assertEquals(true,value);
		page_wait(2);
		click("Forgot_password_link");
		driver.findElement(By.xpath(OR_reader("Object Locator","Forgot_phone_field"))).sendKeys(td_reader("Forgot_phone_number"));
	}
	
	/* TC_002 -Validate that the user should able to click on the  Send Reset Link button on entering valid phone number in Phone number field*/
	@Given("Verify that Send Reset Link button gets enabled and user can click on it")
	public static void forgot_positive_tc_002() throws Exception {
		field_clear("Forgot_phone_field");
		driver.findElement(By.xpath(OR_reader("Object Locator","Forgot_phone_field"))).sendKeys(td_reader("Forgot_phone_number"));
		value = driver.findElement(By.xpath(OR_reader("Object Locator","Forgot_titile"))).isDisplayed();
		Assert.assertEquals(true,value);
		click("Send_resend_link");
		
	}
	
	/* TC_003 -Validate that the user is navigated to sign up page on clicking Sign up link*/
	@Given("Click on Sign up link then should be navigated  to  Sign up page")
	public static void forgot_positive_tc_003() throws Exception {
		click("Forgot_signup_link");
		page_wait(10);
		value = driver.findElement(By.xpath(OR_reader("Object Locator", "signup_page_title"))).isDisplayed();
		Assert.assertEquals(true,value);
	}
}
