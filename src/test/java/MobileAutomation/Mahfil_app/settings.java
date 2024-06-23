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
	
	
	
	 @BeforeGroups(value = "login_email")
	 public void beforeGeneral() {
			driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
			//Scroll to sign in button
			boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",2.0));
			//click on sign in button
			String text=driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.ImageView[9]")).getAttribute("contentDescription");
			System.out.println(text);
			if(text.equals("Logout"))
			{
				driver.findElement(AppiumBy.accessibilityId("Logout")).click();
				driver.findElement(AppiumBy.accessibilityId("Yes")).click();
				driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
			}
			else
			{
				driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
			}
			
			driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
			WebElement email=driver.findElement(By.className("android.widget.EditText"));
			email.click();
			email.sendKeys("premium.mahfil@gmail.com");
			driver.findElement(AppiumBy.accessibilityId("Continue")).click();
			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("0");
			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("1");
			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("1");
			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("0");
			driver.findElement(AppiumBy.accessibilityId("Continue")).click();
			driver.navigate().back();
	 }
	 
	 @BeforeGroups(value = "login_phone")
	 public void beforePremium() {
		 driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		//Scroll to sign in button
		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",2.0));
		//click on sign in button
		String text=driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.ImageView[9]")).getAttribute("contentDescription");
		System.out.println(text);
		if(text.equals("Logout"))
		{
			driver.findElement(AppiumBy.accessibilityId("Logout")).click();
			driver.findElement(AppiumBy.accessibilityId("Yes")).click();
			driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
		}
		else
		{
			driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
		}
		
		driver.findElement(AppiumBy.accessibilityId("Continue another way")).click();
		driver.findElement(AppiumBy.accessibilityId("Log in with Mobile")).click();
		WebElement number=driver.findElement(By.className("android.widget.EditText"));
		number.click();
		number.sendKeys("1842908695");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("0");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("1");
		driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("0");
		driver.findElement(AppiumBy.accessibilityId("Continue")).click();
		driver.navigate().back();
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
	
	
	@Test(priority=1, description="Settings Testcase 01: Check Settings button is working",groups= {"general","premium","login_email"})
	public void settingsButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
		String expectedTitle="Settings";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=2, description="Settings Testcase 02: Check notification button is working in Settings page",groups= {"general","premium","login_email"})
	public void notificationButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
		String expectedTitle="Notifications";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=3, description="Settings Testcase 03: Check search button is working in Settings page",groups= {"general","premium","login_email"})
	public void searchButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[7]")).getAttribute("contentDescription");
		String expectedTitle="Popular Search";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=4, description="Settings Testcase 04: Check back button is working from Settings page",groups= {"general","premium","login_email"})
	public void backButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
		String expectedTitle="Others";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=5, description="Settings Testcase 05: Check  backgroundplay button is working from Settings page",groups= {"general","premium","login_email"})
	public void backgroundplayButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		//click on settings
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();

		String state1=driver.findElement(By.xpath("(//android.widget.Switch)[1]")).getAttribute("checked");
		driver.findElement(By.xpath("(//android.widget.Switch)[1]")).click();
		String state2=driver.findElement(By.xpath("(//android.widget.Switch)[1]")).getAttribute("checked");
		driver.findElement(By.xpath("(//android.widget.Switch)[1]")).click();
		
		Assert.assertNotEquals(state1,state2,"Title matched");
	}
	
	@Test(priority=6, description="Settings Testcase 06: Check auto daynight button is working from Settings page",groups= {"general","premium","login_email"})
	public void autoDayNightButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		//click on settings
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();

		String state1=driver.findElement(By.xpath("(//android.widget.Switch)[2]")).getAttribute("checked");
		driver.findElement(By.xpath("(//android.widget.Switch)[2]")).click();
		String state2=driver.findElement(By.xpath("(//android.widget.Switch)[2]")).getAttribute("checked");
		driver.findElement(By.xpath("(//android.widget.Switch)[2]")).click();
		
		Assert.assertNotEquals(state1,state2,"Title matched");
	}
	
	@Test(priority=7, description="Settings Testcase 07: Check theme button is working from Settings page",groups= {"general","premium","login_email"})
	public void themeButtonCheck() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		//click on settings
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();

//		String state1=driver.findElement(By.xpath("(//android.widget.Switch)[2]")).getAttribute("checked");
		driver.findElement(By.xpath("(//android.widget.Switch)[2]")).click();
		driver.findElement(AppiumBy.accessibilityId("Dark Mode")).click();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.accessibilityId("Light Mode")).click();
	}
	
	@Test(priority=8, description="Settings Testcase 08: Check profile settings button is working in Settings page",groups= {"general","premium","login_email"})
	public void profileSettingButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
		String expectedTitle="Profile Settings";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=9, description="Settings Testcase 09: Check notification button is working in profile Settings page",groups= {"general","premium","login_email"})
	public void profilenotificationButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
		String expectedTitle="Notifications";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=10, description="Settings Testcase 10: Check search button is working in profile Settings page",groups= {"general","premium","login_email"})
	public void profilesearchButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[7]")).getAttribute("contentDescription");
		String expectedTitle="Popular Search";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=11, description="Settings Testcase 11: Check back button is working from profile Settings page",groups= {"general","premium","login_email"})
	public void profilebackButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
		String expectedTitle="Settings";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=12, description="Settings Testcase 12: Check name field can not keep empty in profile Settings page",groups= {"general","premium","login_email"})
	public void nameFieldcheck1() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		WebElement name=driver.findElement(By.xpath("(//android.widget.EditText)[1]"));
		name.click();
		String text1=name.getText();
		name.clear();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.accessibilityId("Save")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//android.widget.EditText)[1]")).click();
		String text2=driver.findElement(By.xpath("(//android.widget.EditText)[1]")).getText();
		Assert.assertEquals(text1,text2,"Text didn't matched");
		
	}
	
	
	@Test(priority=13, description="Settings Testcase 13: Check name can not be saved with only spaces in profile Settings page",groups= {"general","premium","login_email"})
	public void nameFieldcheck2() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		WebElement namefield=driver.findElement(By.xpath("(//android.widget.EditText)[1]"));
		namefield.click();
		String nameBefore=namefield.getText();
		namefield.clear();
		Thread.sleep(1000);
		String name="    ";
		namefield.sendKeys(name);
		driver.findElement(AppiumBy.accessibilityId("Save")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//android.widget.EditText)[1]")).click();
		String actualname=driver.findElement(By.xpath("(//android.widget.EditText)[1]")).getText();
		Assert.assertEquals(nameBefore,actualname,"Name didn't matched");
		
	}
	@Test(priority=14, description="Settings Testcase 14: Check name update is wokring in profile Settings page",groups= {"general","premium","login_email"})
	public void nameFieldcheck3() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		WebElement namefield=driver.findElement(By.xpath("(//android.widget.EditText)[1]"));
		namefield.click();
		namefield.clear();
		Thread.sleep(1000);
		String name="Siam";
		namefield.sendKeys(name);
		driver.findElement(AppiumBy.accessibilityId("Save")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//android.widget.EditText)[1]")).click();
		String actualname=driver.findElement(By.xpath("(//android.widget.EditText)[1]")).getText();
		Assert.assertEquals(name,actualname,"Name didn't matched");
		
	}
	
	@Test(priority=15, description="Settings Testcase 15: Check email field is not updateable while login with email profile Settings page",groups= {"general","premium","login_email"})
	public void emailFieldcheck() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		WebElement emailfield=driver.findElement(By.xpath("(//android.widget.EditText)[2]"));
		emailfield.click();
		String emailbefore=emailfield.getText();
		System.out.println("Email before : " + emailbefore);
		emailfield.clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//android.widget.EditText)[2]")).click();
		String emailafter=driver.findElement(By.xpath("(//android.widget.EditText)[2]")).getText();
		System.out.println("Email after : " + emailafter);
		Assert.assertEquals(emailbefore,emailafter,"Email didn't matched");
		
	}
	
	@Test(priority=16, description="Settings Testcase 16: Check phone number field cann't be keep empty in profile Settings page",groups= {"general","premium","login_email"})
	public void numberFieldcheck1() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		WebElement numberfield=driver.findElement(By.xpath("(//android.widget.EditText)[3]"));
		numberfield.click();
		String numBefore=numberfield.getText();
		numberfield.clear();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.accessibilityId("Save")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//android.widget.EditText)[3]")).click();
		String numAfter=driver.findElement(By.xpath("(//android.widget.EditText)[3]")).getText();
		Assert.assertEquals(numBefore,numAfter,"Number didn't matched");
	}
	
	@Test(priority=17, description="Settings Testcase 17: Check phone number field can't be saved with only spaces in profile Settings page",groups= {"general","premium"})
	public void numberFieldcheck2() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		WebElement numberfield=driver.findElement(By.xpath("(//android.widget.EditText)[3]"));
		numberfield.click();
		String numBefore=numberfield.getText();
		numberfield.clear();
		Thread.sleep(1000);
		numberfield.sendKeys("         ");
		driver.findElement(AppiumBy.accessibilityId("Save")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//android.widget.EditText)[3]")).click();
		String numAfter=driver.findElement(By.xpath("(//android.widget.EditText)[3]")).getText();
		Assert.assertEquals(numBefore,numAfter,"Number didn't matched");
	}
	
	@Test(priority=18, description="Settings Testcase 18: Check phone number field can't be saved with lenght less then six in profile Settings page",groups= {"general","premium","login_email"})
	public void numberFieldcheck3() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		WebElement numberfield=driver.findElement(By.xpath("(//android.widget.EditText)[3]"));
		numberfield.click();
		String numBefore=numberfield.getText();
		numberfield.clear();
		Thread.sleep(1000);
		numberfield.sendKeys("01626");
		driver.findElement(AppiumBy.accessibilityId("Save")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		driver.findElement(By.xpath("(//android.widget.EditText)[3]")).click();
		String numAfter=driver.findElement(By.xpath("(//android.widget.EditText)[3]")).getText();
		Assert.assertEquals(numBefore,numAfter,"Number didn't matched");
	}
	
	@Test(priority=19, description="Settings Testcase 19: Check phone number is update able with valid number in profile Settings page",groups= {"general","premium","login_email"})
	public void numberFieldcheck4() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		WebElement numberfield=driver.findElement(By.xpath("(//android.widget.EditText)[3]"));
		numberfield.click();
		numberfield.clear();
		Thread.sleep(1000);
		String number="01626023972";
		numberfield.sendKeys(number);
		driver.findElement(AppiumBy.accessibilityId("Save")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//android.widget.EditText)[3]")).click();
		String numAfter=driver.findElement(By.xpath("(//android.widget.EditText)[3]")).getText();
		Assert.assertEquals(number,numAfter,"Number didn't matched");
	}
	
	
	
	//-----------Make groups for email login and phone login check email field------------
	
	@Test(priority=20, description="Settings Testcase 20: Check phone number field is not updateable in profile Settings page while login with number ",groups= {"general","premium","login_phone"})
	public void numberFieldcheck() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		WebElement numberfield=driver.findElement(By.xpath("(//android.widget.EditText)[3]"));
		numberfield.click();
		String numbefore=numberfield.getText();
		System.out.println("number before : " + numbefore);
		numberfield.clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//android.widget.EditText)[3]")).click();
		String numafter=driver.findElement(By.xpath("(//android.widget.EditText)[3]")).getText();
		System.out.println("number after : " + numafter);
		Assert.assertEquals(numbefore,numafter,"number didn't matched");
		
	}
	
	@Test(priority=21, description="Settings Testcase 21: Check email field can't be keep empty in profile Settings page",groups= {"general","premium","login_phone"})
	public void emailFieldcheck1() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		WebElement emailfield=driver.findElement(By.xpath("(//android.widget.EditText)[2]"));
		emailfield.click();
		String emailBefore=emailfield.getText();
		emailfield.clear();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.accessibilityId("Save")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//android.widget.EditText)[2]")).click();
		String emailAfter=driver.findElement(By.xpath("(//android.widget.EditText)[2]")).getText();
		Assert.assertEquals(emailBefore,emailAfter,"email didn't matched");
	}
	
	@Test(priority=22, description="Settings Testcase 22: Check email field can't be saved with only spaces in profile Settings page",groups= {"general","premium","login_phone"})
	public void emailFieldcheck2() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		WebElement emailfield=driver.findElement(By.xpath("(//android.widget.EditText)[2]"));
		emailfield.click();
		String emailBefore=emailfield.getText();
		emailfield.clear();
		Thread.sleep(1000);
		emailfield.sendKeys("                     ");
		driver.findElement(AppiumBy.accessibilityId("Save")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		driver.findElement(By.xpath("(//android.widget.EditText)[2]")).click();
		String emailAfter=driver.findElement(By.xpath("(//android.widget.EditText)[2]")).getText();
		Assert.assertEquals(emailBefore,emailAfter,"email didn't matched");
	}
	
	@Test(priority=23, description="Settings Testcase 23: Check email field can't be saved with invalid email in profile Settings page",groups= {"general","premium","login_phone"})
	public void emailFieldcheck3() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		WebElement emailfield=driver.findElement(By.xpath("(//android.widget.EditText)[2]"));
		emailfield.click();
		String emailBefore=emailfield.getText();
		emailfield.clear();
		Thread.sleep(1000);
		emailfield.sendKeys("siam.com");
		driver.findElement(AppiumBy.accessibilityId("Save")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		driver.findElement(By.xpath("(//android.widget.EditText)[2]")).click();
		String emailAfter=driver.findElement(By.xpath("(//android.widget.EditText)[2]")).getText();
		Assert.assertEquals(emailBefore,emailAfter,"Number didn't matched");
	}
	
	@Test(priority=24, description="Settings Testcase 24: Check email field can't be saved with invalid email in profile Settings page",groups= {"general","premium","login_phone"})
	public void emailFieldcheck4() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		WebElement emailfield=driver.findElement(By.xpath("(//android.widget.EditText)[2]"));
		emailfield.click();
		String emailBefore=emailfield.getText();
		emailfield.clear();
		Thread.sleep(1000);
		emailfield.sendKeys("siam@gmail");
		driver.findElement(AppiumBy.accessibilityId("Save")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		driver.findElement(By.xpath("(//android.widget.EditText)[2]")).click();
		String emailAfter=driver.findElement(By.xpath("(//android.widget.EditText)[2]")).getText();
		Assert.assertEquals(emailBefore,emailAfter,"Number didn't matched");
	}
	
	@Test(priority=25, description="Settings Testcase 25: Check email  is update able with valid email in profile Settings page",groups= {"general","premium","login_phone"})
	public void emailFieldcheck5() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		WebElement emailfield=driver.findElement(By.xpath("(//android.widget.EditText)[2]"));
		emailfield.click();
		emailfield.clear();
		Thread.sleep(1000);
		String email="alhasibsiam@gmail.com";
		emailfield.sendKeys(email);
		driver.findElement(AppiumBy.accessibilityId("Save")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//android.widget.EditText)[2]")).click();
		String emailAfter=driver.findElement(By.xpath("(//android.widget.EditText)[2]")).getText();
		Assert.assertEquals(email,emailAfter,"Number didn't matched");
	}
	
}
