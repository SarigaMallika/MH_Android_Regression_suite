package Signup_positive_scenario;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import Reusable_functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Signup_positive_scenario extends Generic_functions{
	public static boolean value1,value2;

	/*For verifying that the app is launched and user clicks on the Signup button and navigates to Signup page*/
	@Given("App is open and user is on sign up page")
	public static void signup_positive_tc_001() throws IOException {
		try {
			app_launch();
			page_wait(10);
			click("sign_up");
		}catch(IOException e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_tc_001");
		}
	}

	/* For verifying that the user is navigated to the login page on clicking the login link*/
	@When("user clicks on the login link user is navigated to the login page")
	public static void signup_positive_tc_002() throws IOException{
		try {	
			page_wait(20);
			click("login_link");
			page_wait(30);
			value1 = driver.findElement(By.xpath(OR_reader("Object Locator", "login_page_title"))).isDisplayed();
			Assert.assertEquals(true,value1);
			page_wait(50);
			click("signup_link");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_tc_002");
		}
	}

	/* For verifying password and confirm password values are masked */
	@When("User enters the details in the Password and Confirmed Password field should be masked")
	public void signup_positive_tc_003() throws IOException {
		try {
			page_wait(30);
			driver.findElement(By.xpath(OR_reader("Object Locator","password"))).sendKeys(td_reader("password"));
			driver.findElement(By.xpath(OR_reader("Object Locator", "confirm_password"))).sendKeys(td_reader("confirm_password"));
			value1=driver.findElement(By.xpath(OR_reader("Object Locator", "password"))).isDisplayed();
			value2=driver.findElement(By.xpath(OR_reader("Object Locator", "confirm_password"))).isDisplayed();
			Assert.assertEquals(true,value1);
			Assert.assertEquals(true,value2);
			browser_back();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_tc_003");
		}
	}

	/* For verifying user can see the original value while clicking on the Eye*/
	@Then("User clicks on the Eye and Orginal value should be displayed in the password fields")
	public void signup_positive_tc_004() throws IOException {
		try {
			page_wait(30);
			click("sign_up");
			driver.findElement(By.xpath(OR_reader("Object Locator","password"))).sendKeys(td_reader("password"));
			page_wait(30);
			click("show_password");
			value1=driver.findElement(By.xpath(OR_reader("Object Locator", "show_password"))).isDisplayed();
			Assert.assertEquals(true,value1);
			browser_back();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_tc_004");
		}
	}

	/* Verifying values entered in Password and Confirm Password are same */ 
	@When("user enter same values of Password in the Confirmed field")
	public void signup_positive_tc_005() throws IOException {
		try {
			page_wait(30);
			click("sign_up");
			driver.findElement(By.xpath(OR_reader("Object Locator","password"))).sendKeys(td_reader("password"));
			driver.findElement(By.xpath(OR_reader("Object Locator", "confirm_password"))).sendKeys(td_reader("confirm_password"));
			value1=driver.findElement(By.xpath(OR_reader("Object Locator", "password"))).isDisplayed();
			value2=driver.findElement(By.xpath(OR_reader("Object Locator", "confirm_password"))).isDisplayed();
			Assert.assertEquals(true,value1);
			Assert.assertEquals(true,value2);
			browser_back();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_tc_005");
		}
	}

	/* User entering all the valid credentials */
	@When("User enters valid credentials")
	public void signup_positive_tc_006() throws IOException {
		try {
			page_wait(30);
			click("sign_up");
			driver.findElement(By.xpath(OR_reader("Object Locator","first_name"))).sendKeys(td_reader("first _name"));
			driver.findElement(By.xpath(OR_reader("Object Locator", "last_name"))).sendKeys(td_reader("last_name"));
			driver.findElement(By.xpath(OR_reader("Object Locator","email_id"))).sendKeys(td_reader("email_id"));
			driver.findElement(By.xpath(OR_reader("Object Locator", "phone_number"))).sendKeys(td_reader("phone_number"));
			driver.findElement(By.xpath(OR_reader("Object Locator","password"))).sendKeys(td_reader("password"));
			driver.findElement(By.xpath(OR_reader("Object Locator", "confirm_password"))).sendKeys(td_reader("confirm_password"));
			page_wait(20);
			click("checkbox");
			page_wait(20);
			click("signup");
			page_wait(20);
			value1=driver.findElement(By.xpath(OR_reader("Object Locator", "otp_1"))).isDisplayed();
			Assert.assertEquals(true,value1);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_tc_006");
		}
	}

	/*User entering otp*/
	@When("user enters otp and clicks on verify button and is navigated to the login page")
	public void signup_positive_tc_007() throws IOException {
		try {
			driver.findElement(By.xpath(OR_reader("Object Locator","otp_1"))).sendKeys(td_reader("otp_1"));
			driver.findElement(By.xpath(OR_reader("Object Locator","otp_2"))).sendKeys(td_reader("otp_2"));
			driver.findElement(By.xpath(OR_reader("Object Locator","otp_3"))).sendKeys(td_reader("otp_3"));
			driver.findElement(By.xpath(OR_reader("Object Locator","otp_4"))).sendKeys(td_reader("otp_4"));
			page_wait(5);
			click("verify");
			click("verify");
			value1=driver.findElement(By.xpath(OR_reader("Object Locator", "otp_page"))).isDisplayed();
			Assert.assertEquals(true,value1);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_tc_007");
		}
	}
}