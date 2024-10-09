package MobileAutomation.Mahfil_app;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class login extends configAppium{

	public menuPageLocators menu;
	public homePageLocators home;
	public authenticationLocators authentication;
	 @BeforeMethod
	 public void before() throws InterruptedException {

		 menu=new menuPageLocators(driver);
		 home=new homePageLocators(driver);
		 authentication=new authenticationLocators(driver);
		 Thread.sleep(200);
		 home.clickMenu();
		 menu.Scroll(2);
	 }
	 
	@AfterMethod
	public void home() {
		while(true)
		{
			String home_bounds=driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).getAttribute("bounds");
			if(home_bounds.equals("[476,181][964,305]"))
					{
				break;
					}
			else
			{
				driver.navigate().back();
			}
	
		}
//		System.out.println("Return Home");

	}
	
	
	//-----------Login with google----------//
	@Test(priority=1, description="Login TestCase 01: Try to google login with provider logged in account")
	public void login1() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickGoogleLogin();
		authentication.clickProviderEmail();
		authentication.checkTitle("errorMessageGoogle", "Email already linked to a Provider account. Please use a different one.");
		
	}
	
	@Test(priority=2, description="Login TestCase 02:Try to google login with email logged in account")
	public void login2() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickGoogleLogin();
		authentication.clickEmailAccount();
		authentication.checkTitle("errorMessageGoogle", "Please try a different email address.");
	}
	
	@Test(priority=3, description="Login TestCase 03:Google login with a valid account")
	public void login3() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickGoogleLogin();
		authentication.clickGoogleAccount();
		menu.checkTitle("authButton", "Logout");
	}
	
	
	//--------------Login with Email----------------//
	
	@Test(priority=4, description="Login TestCase 04:Try to login with provider account email")
	public void login4() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickEmailLogin();
		authentication.enterEmail("siam.qtec@gmail.com");
		authentication.clickContinue();
		authentication.checkTitle("errorMessageEmail", "Email already linked to a Provider account. Please use a different one.");
	}
	
	
	@Test(priority=5, description="Login TestCase 05:Try to login with google logged in account")
	public void login5() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickEmailLogin();
		authentication.enterEmail("siamali1499@gmail.com");
		authentication.clickContinue();
		authentication.checkTitle("errorMessageEmail", "This email already use in Google Login");
	}
	
	
	@Test(priority=6, description="Login TestCase 06:Try to login by keeping the email field empty")
	public void login6() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickEmailLogin();
		authentication.enterEmail("");
		authentication.clickContinue();
		authentication.checkTitle("emailPage", "Continue with your Email");
	}
	
	@Test(priority=7, description="Login TestCase 07:Try to login by giving invalid email")
	public void login7() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickEmailLogin();
		authentication.enterEmail("siam.com");
		authentication.clickContinue();
		authentication.checkTitle("emailPage", "Continue with your Email");
	}
	
	@Test(priority=8, description="Login TestCase 08:Try to login by giving invalid email")
	public void login8() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickEmailLogin();
		authentication.enterEmail("siam@gmailcom");
		authentication.clickContinue();
		authentication.checkTitle("emailPage", "Continue with your Email");
	}
	

	
	@Test(priority=10, description="Login TestCase 10:Try to login by giving invalid otp")
	public void login10() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickEmailLogin();
		authentication.enterEmail("alhasibsiam@gmail.com");
		authentication.clickContinue();
		authentication.enterOTP("0", "5", "2", "0");
		authentication.clickContinue();
		authentication.checkTitle("otpErrorMessage", "OTP doesn't matched");
	}
	
	
	@Test(priority=11, description="Login TestCase 11:Try to login by giving valid otp in email login")
	public void signup10() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickEmailLogin();
		authentication.enterEmail("alhasibsiam@gmail.com");
		authentication.clickContinue();
		authentication.enterOTP("0", "1", "1", "0");
		authentication.clickContinue();
		menu.checkTitle("authButton", "Logout");
	}
	
	//--------------login with phone number-----------//

	@Test(priority=12, description="Login TestCase 12:Keep the phone number field empty and try to login")
	public void login12() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickMobileLogin();
		authentication.enterNumber("");
		authentication.clickContinue();
		authentication.checkTitle("phonePage", "Continue with your phone number");
	}
	
	
	@Test(priority=13, description="Login TestCase 13:Give invalid phone number and try to login")
	public void login13() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickMobileLogin();
		authentication.enterNumber("01626");
		authentication.clickContinue();
		authentication.checkTitle("phonePage", "Continue with your phone number");
	}
	

	
	@Test(priority=15, description="Login TestCase 15:Try to login by giving invalid otp on phone login")
	public void login15() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickMobileLogin();
		authentication.enterNumber("01231234123");
		authentication.clickContinue();
		authentication.enterOTP("0", "0", "0", "0");
		authentication.clickContinue();
		authentication.checkTitle("otpErrorMessage", "OTP doesn't matched");
	}
	
	@Test(priority=16, description="Login TestCase 16:Try to login by giving valid otp on phone login")
	public void login16() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickMobileLogin();
		authentication.enterNumber("01231234123");
		authentication.clickContinue();
		authentication.enterOTP("0", "1", "1", "0");
		authentication.clickContinue();
		menu.checkTitle("authButton", "Logout");
	}
}
	
