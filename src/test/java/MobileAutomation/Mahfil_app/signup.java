package MobileAutomation.Mahfil_app;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class signup extends configAppium{

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
	
	
	//---Check Continue with google----//
	
	
	@Test(priority=1, description="Try to google signup with provider logged in account")
	public void signup1() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickGoogleLogin();
		authentication.clickProviderEmail();
		authentication.checkTitle("errorMessageGoogle", "Email already linked to a Provider account. Please use a different one.");
	}
	
	@Test(priority=2, description="Try to google signup with email logged in account")
	public void signup2() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickGoogleLogin();
		authentication.clickEmailAccount();
		authentication.checkTitle("errorMessageGoogle", "Please try a different email address.");

	}
	
	@Test(priority=3, description="Try to google signup with valid email account")
	public void validGoogleSignup() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickGoogleLogin();
		authentication.clickGoogleAccount();
		menu.checkTitle("authButton", "Logout");

	}
	
	
	
	//-------------------Email signup test----------------------//
	
	@Test(priority=3, description="Try to signup with provider account email in email login")
	public void signup3() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickEmailLogin();
		authentication.enterEmail("siam.qtec@gmail.com");
		authentication.clickContinue();
		authentication.checkTitle("errorMessageEmail", "Email already linked to a Provider account. Please use a different one.");
	}
	
	
	@Test(priority=4, description="Try to signup with google logged in account")
	public void signup4() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickEmailLogin();
		authentication.enterEmail("siamali1499@gmail.com");
		authentication.clickContinue();
		authentication.checkTitle("errorMessageEmail", "This email already use in Google Login");
	}
	
	
	@Test(priority=5, description="Try to signup by keeping the email field empty")
	public void signup5() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickEmailLogin();
		authentication.enterEmail("");
		authentication.clickContinue();
		authentication.checkTitle("emailPage", "Continue with your Email");

	}
	
	@Test(priority=6, description="Try to signup by giving invalid email")
	public void signup6() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickEmailLogin();
		authentication.enterEmail("siam.com");
		authentication.clickContinue();
		authentication.checkTitle("emailPage", "Continue with your Email");

	}
	
	@Test(priority=7, description="Try to signup by giving invalid email")
	public void signup7() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickEmailLogin();
		authentication.enterEmail("siam@gmailcom");
		authentication.clickContinue();
		authentication.checkTitle("emailPage", "Continue with your Email");
	}
	
	
	@Test(priority=9, description="Try to signup by giving invalid otp")
	public void signup9() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickEmailLogin();
		authentication.enterEmail("alhasibsiam@gmail.com");
		authentication.clickContinue();
		authentication.enterOTP("0", "5", "2", "0");
		authentication.clickContinue();
		authentication.checkTitle("otpErrorMessage", "OTP doesn't matched");
	}
	
	
	@Test(priority=10, description="Try to signup by giving valid otp")
	public void signup10() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickEmailLogin();
		authentication.enterEmail("alhasibsiamss@gmail.com");
		authentication.clickContinue();
		authentication.enterOTP("0", "1", "1", "0");
		authentication.clickContinue();
		authentication.checkTitle("namePage", "Sign up to your account!");

	}
	
	
	@Test(priority=11, description="Try to signup by keeping the name field empty")
	public void signup11() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickEmailLogin();
		authentication.enterEmail("alhasibsiams@gmail.com");
		authentication.clickContinue();
		authentication.enterOTP("0", "1", "1", "0");
		authentication.clickContinue();
		authentication.enterName("");
		authentication.clickSave();
		authentication.checkTitle("namePage", "Sign up to your account!");
	}
	
	@Test(priority=12, description="Try to signup by giving only spaces in name field")
	public void signup12() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickEmailLogin();
		authentication.enterEmail("alhasibsiams@gmail.com");
		authentication.clickContinue();
		authentication.enterOTP("0", "1", "1", "0");
		authentication.clickContinue();
		authentication.enterName("      ");
		authentication.clickSave();
		authentication.checkTitle("namePage", "Sign up to your account!");
	}
	
	@Test(priority=13, description="Try to signup by giving name less then 3 character")
	public void signup13() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickEmailLogin();
		authentication.enterEmail("alhasibsiams@gmail.com");
		authentication.clickContinue();
		authentication.enterOTP("0", "1", "1", "0");
		authentication.clickContinue();
		authentication.enterName("si");
		authentication.clickSave();
		authentication.checkTitle("namePage", "Sign up to your account!");
	}
	
	
	@Test(priority=13, description="Try to signup by giving only phone")
	public void signup() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickEmailLogin();
		authentication.enterEmail("alhasibsiams@gmail.com");
		authentication.clickContinue();
		authentication.enterOTP("0", "1", "1", "0");
		authentication.clickContinue();
		authentication.enterPhone("1626023972");
		authentication.clickSave();
		authentication.checkTitle("namePage", "Sign up to your account!");
	}
	
	@Test(priority=14, description="Try to signup by giving valid name and phone")
	public void signup14() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickEmailLogin();
		authentication.enterEmail("test@mahfil.test");
		authentication.clickContinue();
		authentication.enterOTP("0", "1", "1", "0");
		authentication.clickContinue();
		authentication.enterName("siam");
		authentication.enterPhone("1626023972");
		authentication.clickSave();
		menu.checkTitle("authButton", "Logout");
	}
	
	
	//-------------------Phone signup test----------------------//
	
	
	@Test(priority=15, description="Keep the phone number field empty and try to signup")
	public void signup15() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickMobileLogin();
		authentication.enterNumber("");
		authentication.clickContinue();
		authentication.checkTitle("phonePage", "Continue with your phone number");
	}
	
	
	@Test(priority=16, description="Give invalid phone number and try to signup")
	public void signup16() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickMobileLogin();
		authentication.enterNumber("01626");
		authentication.clickContinue();
		authentication.checkTitle("phonePage", "Continue with your phone number");
	}
	

	
	@Test(priority=18, description="Try to signup by giving invalid otp on phone login")
	public void signup18() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickMobileLogin();
		authentication.enterNumber("01231234123");
		authentication.clickContinue();
		authentication.enterOTP("0", "0", "0", "0");
		authentication.clickContinue();
		authentication.checkTitle("otpErrorMessage", "OTP doesn't matched");
	}
	
	@Test(priority=19, description="Try to signup by giving valid otp on phone login")
	public void signup19() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickMobileLogin();
		authentication.enterNumber("01231234123");
		authentication.clickContinue();
		authentication.enterOTP("0", "1", "1", "0");
		authentication.clickContinue();
		authentication.checkTitle("namePage", "Sign up to your account!");
	}
	
	@Test(priority=20, description="Try to signup by keeping the name field empty")
	public void signup20() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickMobileLogin();
		authentication.enterNumber("01231234123");
		authentication.clickContinue();
		authentication.enterOTP("0", "1", "1", "0");
		authentication.clickContinue();
		authentication.enterName("");
		authentication.clickSave();
		authentication.checkTitle("namePage", "Sign up to your account!");
	}
	
	@Test(priority=21, description="Try to signup by giving only spaces in name field")
	public void signup21() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickMobileLogin();
		authentication.enterNumber("01231234123");
		authentication.clickContinue();
		authentication.enterOTP("0", "1", "1", "0");
		authentication.clickContinue();
		authentication.enterName("     ");
		authentication.clickSave();
		authentication.checkTitle("namePage", "Sign up to your account!");
	}
	
	@Test(priority=22, description="Try to signup by giving name less then 3 character")
	public void signup22() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickMobileLogin();
		authentication.enterNumber("01231234123");
		authentication.clickContinue();
		authentication.enterOTP("0", "1", "1", "0");
		authentication.clickContinue();
		authentication.enterName("si");
		authentication.clickSave();
		authentication.checkTitle("namePage", "Sign up to your account!");
	}
	
	@Test(priority=23, description="Try to signup by giving valid name and email")
	public void signup23() throws InterruptedException {
		menu.clickSignIn();
		authentication.clickMobileLogin();
		authentication.enterNumber("01231234123");
		authentication.clickContinue();
		authentication.enterOTP("0", "1", "1", "0");
		authentication.clickContinue();
		authentication.enterName("siam");
		authentication.clickSave();
		menu.checkTitle("authButton", "Logout");
	}

	
	
	
	
	
	

}
