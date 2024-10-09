package MobileAutomation.Mahfil_app;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class settings extends configAppium{
	
	
	
//	 @BeforeGroups(value = "login_email")
//	 public void beforeGeneral() {
//			driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
//			//Scroll to sign in button
//			boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",2.0));
//			//click on sign in button
//			String text=driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.ImageView[9]")).getAttribute("contentDescription");
//			System.out.println(text);
//			if(text.equals("Logout"))
//			{
//				driver.findElement(AppiumBy.accessibilityId("Logout")).click();
//				driver.findElement(AppiumBy.accessibilityId("Yes")).click();
//				driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
//			}
//			else
//			{
//				driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
//			}
//			
//			driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
//			WebElement email=driver.findElement(By.className("android.widget.EditText"));
//			email.click();
//			email.sendKeys("premium.mahfil@gmail.com");
//			driver.findElement(AppiumBy.accessibilityId("Continue")).click();
//			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("0");
//			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("1");
//			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("1");
//			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("0");
//			driver.findElement(AppiumBy.accessibilityId("Continue")).click();
//			driver.navigate().back();
//	 }
//	 
//	 @BeforeGroups(value = "login_phone")
//	 public void beforePremium() {
//		 driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
//		//Scroll to sign in button
//		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",2.0));
//		//click on sign in button
//		String text=driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.ImageView[9]")).getAttribute("contentDescription");
//		System.out.println(text);
//		if(text.equals("Logout"))
//		{
//			driver.findElement(AppiumBy.accessibilityId("Logout")).click();
//			driver.findElement(AppiumBy.accessibilityId("Yes")).click();
//			driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
//		}
//		else
//		{
//			driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
//		}
//		
//		driver.findElement(AppiumBy.accessibilityId("Continue another way")).click();
//		driver.findElement(AppiumBy.accessibilityId("Log in with Mobile")).click();
//		WebElement number=driver.findElement(By.className("android.widget.EditText"));
//		number.click();
//		number.sendKeys("1842908695");
//		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
//		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("0");
//		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("1");
//		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("1");
//		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("0");
//		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
//		driver.navigate().back();
//	 }
	 
		public menuPageLocators menu;
		public homePageLocators home;
		public settingsLocator settings;
		public profileSettingsLocator profile;
		 @BeforeMethod
	public void before() throws InterruptedException {
		menu=new menuPageLocators(driver);
		home=new homePageLocators(driver);
		settings=new settingsLocator(driver);
		profile=new profileSettingsLocator(driver);
		Thread.sleep(200);
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
	}
	
	
	@Test(priority=1, description="Settings Testcase 01: Check Settings button is working",groups= {"All"})
	public void settingsButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.checkTitle("settingsPageTitle", "Settings");

	}
	@Test(priority=2, description="Settings Testcase 02: Check notification button is not accessable for guest user in Settings page",groups= {"guest"})
	public void guestNotificationButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickNotification();
		settings.checkTitle("SignupPageTitle","Continue with Google");
	}
	@Test(priority=3, description="Settings Testcase 03: Check profile settings button is working in Settings page",groups= {"guest"})
	public void GuestProfileSettingButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickProfileSettings();
		settings.checkTitle("SignupPageTitle","Continue with Google");
	}
	@Test(priority=4, description="Settings Testcase 04: Check notification button is working in Settings page",groups= {"general","premium","login_email"})
	public void notificationButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickNotification();
		settings.checkTitle("notificationPageTitle", "Notifications");
	}
	
	@Test(priority=5, description="Settings Testcase 05: Check search button is working in Settings page",groups= {"general","premium","login_email"})
	public void searchButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickSearch();
		settings.checkTitle("searchPageTitle", "Popular Search");
	}
	
	@Test(priority=6, description="Settings Testcase 06: Check back button is working from Settings page",groups= {"general","premium","login_email"})
	public void backButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickBackButton();
		menu.checkTitle("menuTitle","Others");
	}
	@Test(priority=7, description="Settings Testcase 7: Check auto daynight button is working from Settings page",groups= {"general","premium","login_email"})
	public void autoDayNightButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickSwitch1();
		settings.checkTitle("switchButton1", "false");
		settings.clickSwitch1();
		settings.checkTitle("switchButton1", "true");

	}
	@Test(priority=8, description="Settings Testcase 08: Check theme button is working from Settings page",groups= {"general","premium","login_email"})
	public void themeButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickSwitch1();
		settings.clickDarkMode();
		Thread.sleep(1000);
		settings.clickLightMode();
		settings.clickSwitch1();
	}
	
	@Test(priority=9, description="Settings Testcase 09: Check profile settings button is working in Settings page",groups= {"general","premium","login_email"})
	public void profileSettingButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickProfileSettings();
		profile.checkTitle("profileSettingsPageTitle", "Profile Settings");


	}
	
	@Test(priority=10, description="Settings Testcase 10: Check notification button is working in profile Settings page",groups= {"general","premium","login_email"})
	public void profilenotificationButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickProfileSettings();
		profile.clickNotification();
		profile.checkTitle("notificationPageTitle", "Notifications");

	}
	
	
	@Test(priority=10, description="Settings Testcase 10: Check search button is working in profile Settings page",groups= {"general","premium","login_email"})
	public void profilesearchButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickProfileSettings();
		profile.clickSearch();
		profile.checkTitle("searchPageTitle", "Popular Search");
	}
	
	@Test(priority=11, description="Settings Testcase 11: Check back button is working from profile Settings page",groups= {"general","premium","login_email"})
	public void profilebackButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickProfileSettings();
		profile.clickBackButton();
		settings.checkTitle("settingsPageTitle", "Settings");
	}
	

	@Test(priority=12, description="Settings Testcase 12: Check name field can not keep empty in profile Settings page",groups= {"general","premium","login_email"})
	public void nameFieldcheck1() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickProfileSettings();
		String initial=profile.modifyName("");
		profile.clickSave();
		profile.checkTitle("nameField", initial);
	}
	
	
	@Test(priority=13, description="Settings Testcase 13: Check name can not be saved with only spaces in profile Settings page",groups= {"general","premium","login_email"})
	public void nameFieldcheck2() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickProfileSettings();
		String initial=profile.modifyName("     ");
		profile.clickSave();
		profile.checkTitle("nameField", initial);
		
	}
	@Test(priority=14, description="Settings Testcase 14: Check name update is wokring in profile Settings page",groups= {"general","premium","login_email"})
	public void nameFieldcheck3() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickProfileSettings();
		String initial=profile.modifyName("Siam Ali");
		profile.clickSave();
		profile.checkTitle("nameField", "Siam Ali");
		
	}
	
	@Test(priority=15, description="Settings Testcase 15: Check email field is not updateable while login with email profile Settings page",groups= {"general","premium","login_email"})
	public void emailFieldcheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickProfileSettings();
		String initial=profile.modifyEmail("siam@gmail.com");
		profile.clickSave();
		profile.checkTitle("emailField", initial);	
	}
	
	@Test(priority=16, description="Settings Testcase 16: Check phone number field cann't be keep empty in profile Settings page",groups= {"general","premium","login_email"})
	public void numberFieldcheck1() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickProfileSettings();
		String initial=profile.modifyPhone("");
		profile.clickSave();
		profile.checkTitle("numberField", initial);
	}
	
	@Test(priority=17, description="Settings Testcase 17: Check phone number field can't be saved with only spaces in profile Settings page",groups= {"general","premium"})
	public void numberFieldcheck2() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickProfileSettings();
		String initial=profile.modifyPhone("             ");
		profile.clickSave();
		profile.checkTitle("numberField", initial);
	}
	
	@Test(priority=18, description="Settings Testcase 18: Check phone number field can't be saved with lenght less then six in profile Settings page",groups= {"general","premium","login_email"})
	public void numberFieldcheck3() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickProfileSettings();
		String initial=profile.modifyPhone("01626");
		profile.clickSave();
		profile.clickBackButton();
		settings.clickProfileSettings();
		profile.checkTitle("numberField", initial);
	}
	
	@Test(priority=19, description="Settings Testcase 19: Check phone number is update able with valid number in profile Settings page",groups= {"general","premium","login_email"})
	public void numberFieldcheck4() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickProfileSettings();
		String initial=profile.modifyPhone("01626023973");
		profile.clickSave();

		profile.checkTitle("numberField", "01626023973");
	}
	
	
	
	//-----------Make groups for email login and phone login check email field------------
	
	@Test(priority=20, description="Settings Testcase 20: Check phone number field is not updateable in profile Settings page while login with number ",groups= {"general","premium","login_phone"})
	public void numberFieldcheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickProfileSettings();
		String initial=profile.modifyPhone("01626023973");
		profile.clickSave();
		profile.checkTitle("numberField", initial);
	}
	
	@Test(priority=21, description="Settings Testcase 21: Check email field can't be keep empty in profile Settings page",groups= {"general","premium","login_phone"})
	public void emailFieldcheck1() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickProfileSettings();
		Thread.sleep(500);
		String initial=profile.modifyEmail("");
		profile.clickSave();
		profile.checkTitle("emailField", initial);	
	}
	
	@Test(priority=22, description="Settings Testcase 22: Check email field can't be saved with only spaces in profile Settings page",groups= {"general","premium","login_phone"})
	public void emailFieldcheck2() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickProfileSettings();
		Thread.sleep(500);
		String initial=profile.modifyEmail("       ");
		profile.clickSave();
		profile.checkTitle("emailField", initial);	
	}
	
	@Test(priority=23, description="Settings Testcase 23: Check email field can't be saved with invalid email in profile Settings page",groups= {"general","premium","login_phone"})
	public void emailFieldcheck3() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickProfileSettings();
		Thread.sleep(500);
		String initial=profile.modifyEmail("siam.com");
		profile.clickSave();
		profile.clickBackButton();
		settings.clickProfileSettings();
		profile.checkTitle("emailField", initial);
	}
	
	@Test(priority=24, description="Settings Testcase 24: Check email field can't be saved with invalid email in profile Settings page",groups= {"general","premium","login_phone"})
	public void emailFieldcheck4() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickProfileSettings();
		Thread.sleep(500);
		String initial=profile.modifyEmail("siam@gmail");
		profile.clickSave();
		profile.clickBackButton();
		settings.clickProfileSettings();
		profile.checkTitle("emailField", initial);
	}
	
	@Test(priority=25, description="Settings Testcase 25: Check email  is update able with valid email in profile Settings page",groups= {"general","premium","login_phone"})
	public void emailFieldcheck5() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickProfileSettings();
		Thread.sleep(500);
		String initial=profile.modifyEmail("siam@gmail.com");
		profile.clickSave();
		profile.clickBackButton();
		settings.clickProfileSettings();
		profile.checkTitle("emailField", "siam@gmail.com");
	}
	
	@Test(priority=26, description="Settings Testcase 26: Check  backgroundplay button is working from Settings page",groups= {"premium"})
	public void backgroundplayButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSettings();
		settings.clickSwitch1();
		settings.checkTitle("switchButton1", "false");
		settings.clickSwitch1();
		settings.checkTitle("switchButton1", "true");

	}
	
}
