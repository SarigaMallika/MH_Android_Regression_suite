package Login_positive_scenario;


import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import Reusable_functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Login_positive_scenario extends Generic_functions{
	public static boolean value;
	/* Application Launch*/
	@Given("App is open")
	public void app_launching() {
		try {
			app_launch();
			page_wait(5);
		} catch (IOException e) {
			e.getMessage();
		}
		}	
	

	@Then("check  the  Phone number  field is prefixed with country code")
	/*TC 001 - Validate that the'Phone number' field is prefixed with '+1' country code*/
	public static void login_positive_tc_001() throws IOException {
		try {
			click("Welcome_login");
			page_wait(5);
			value = driver.findElement(By.xpath(OR_reader("Object Locator","Plus_one"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (IOException e) {
			e.getMessage();
			takeScreenShot("login_positive_tc_001");
		}
		}
	
	@Given("User click on Forgot password")
	/*TC 002 - Validate that the user is able to click on the 'Forgot password?' link*/
	public static void login_positive_tc_002() throws IOException {
		try {
			click("Forgot_password_link");
			page_wait(20);
			value = driver.findElement(By.xpath(OR_reader("Object Locator", "Send_resend_link"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(20);
		} catch (IOException e) {
			e.getMessage();
			takeScreenShot("login_positive_tc_002");
			}
	}

	@Given("User click on Sign up")
	/*TC 003 - Validate that the user is able click on the 'Sign up' link*/
	public static void login_positive_tc_003() throws IOException {
		
		try {
			click("Signup_link");
			page_wait(20);
			value = driver.findElement(By.xpath(OR_reader("Object Locator", "Signup_now"))).isDisplayed();
			Assert.assertEquals(true,value);
			
		} catch (IOException e) {
			e.getMessage();
			takeScreenShot("login_positive_tc_003");
		}
		
	}
	
	@Given("User enter  the Password")
	/*TC 004 - Validate that the user is able to enter password on the Password field*/
	public static void login_positive_tc_004() throws IOException {
		
		try {
			click("Login_link_signup");
			page_wait(10);
			driver.findElement(By.xpath(OR_reader("Object Locator", "Password"))).sendKeys(td_reader("Password",1));		
		} catch (IOException e) {
			e.getMessage();
			takeScreenShot("login_positive_tc_004");
		}
		
	}

	@When("User enters valid phonenumber and password and User click on login")
	/*TC 005 - Validate that the user User enters valid phonenumber and password and User click on login*/
	public static void login_positive_tc_005() throws IOException {
		
		try {
			field_clear("Password");
			driver.findElement(By.xpath(OR_reader("Object Locator", "Phone_number"))).sendKeys(td_reader("Phone_number"));
			driver.findElement(By.xpath(OR_reader("Object Locator", "Password"))).sendKeys(td_reader("Password",0));
			driver.findElement(By.xpath("//android.widget.Button[@resource-id='login']")).click();
			//click("Login");
		} catch (IOException e) {
			e.getMessage();
			takeScreenShot("login_positive_tc_005");
		}
		
		
	}
	@Given("User click on Logout")
	/*TC 006 - Validate that the user is navigated to 'Landing page' on clicking the 'Log out' option*/
	public static void login_positive_tc_006() throws IOException {
		page_wait(20);
		//driver.findElementByClassName(OR_reader("Object Locator", "Three_line")).click();
		//click("Three_line");
		driver.findElement(By.xpath("//android.widget.TextView[@index='0']")).click();
		page_wait(9);
		driver.findElement(By.xpath("//android.view.ViewGroup[11]")).click();
		page_wait(9);
		close();
		
	}

	

}