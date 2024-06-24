package MobileAutomation.Mahfil_app;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class signOutUser_menu extends configAppium {
	
//	 @BeforeClass
//	 public void generalLogin() {
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
//			while(true)
//			{
//				String home_bounds=driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).getAttribute("bounds");
//				if(home_bounds.equals("[476,181][964,305]"))
//						{
//					break;
//						}
//				else
//				{
//					driver.navigate().back();
//				}
//		
//			}
//	 }

	
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
	
	@Test(priority=1, description="Guest user menu Testcase 01: Check guest user can not access live dashboard",groups= {"guest"})
	public void dashboardButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).getAttribute("contentDescription");
		String expectedTitle="Continue with Google";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=2, description="Guest user menu Testcase 02: Check guest user can not access downloads",groups= {"guest"})
	public void downloadButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[5]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).getAttribute("contentDescription");
		String expectedTitle="Continue with Google";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=3, description="Guest user menu Testcase 03: Check guest user can not access favourites",groups= {"guest"})
	public void favouritesButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[6]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).getAttribute("contentDescription");
		String expectedTitle="Continue with Google";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=4, description="Guest user menu Testcase 04: Check guest user can not access watch history",groups= {"guest"})
	public void watchHistoryButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[7]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).getAttribute("contentDescription");
		String expectedTitle="Continue with Google";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=5, description="Guest user menu Testcase 05: Check guest user can not access subscribed channel",groups= {"guest"})
	public void subscribedChannelButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[8]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).getAttribute("contentDescription");
		String expectedTitle="Continue with Google";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=6, description="Guest user menu Testcase 06: Check guest user can access salat reminder page",groups= {"guest"})
	public void salatReminderButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[9]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
		String expectedTitle="Salat Time";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=7, description="Guest user menu Testcase 07: Check guest user can access settings page",groups={"guest"})
	public void settingsButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
		String expectedTitle="Settings";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=8, description="Guest user menu Testcase 08: Check auto daynight button is working from Settings page",groups= {"guest"})
	public void settingsAutoDayNightButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		//click on settings
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();

		String state1=driver.findElement(By.xpath("(//android.widget.Switch)[1]")).getAttribute("checked");
		driver.findElement(By.xpath("(//android.widget.Switch)[1]")).click();
		String state2=driver.findElement(By.xpath("(//android.widget.Switch)[1]")).getAttribute("checked");
		driver.findElement(By.xpath("(//android.widget.Switch)[1]")).click();
		
		Assert.assertNotEquals(state1,state2,"Title matched");
	}
	
	@Test(priority=9, description="Guest user menu Testcase 09: Check theme button is working from Settings page",groups= {"guest"})
	public void themeButtonCheck() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		//click on settings
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();

//		String state1=driver.findElement(By.xpath("(//android.widget.Switch)[2]")).getAttribute("checked");
		driver.findElement(By.xpath("(//android.widget.Switch)[1]")).click();
		driver.findElement(AppiumBy.accessibilityId("Dark Mode")).click();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.accessibilityId("Light Mode")).click();
	}
	
	@Test(priority=10, description="Settings Testcase 10: Check profile settings button is not accessable in Settings page",groups= {"guest"})
	public void profileSettingButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[10]")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[4]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).getAttribute("contentDescription");
		String expectedTitle="Continue with Google";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=11, description="Guest user menu Testcase 11: Check guest user has no packakge activated",groups= {"guest"})
	public void subscriptionButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(AppiumBy.accessibilityId("Subscription")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
		String expectedTitle="বর্তমানে আপনার কোনো সাবস্ক্রিপশন নেই, এখনই পছন্দের প্যাকেজ নিশ্চিত করুন!";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=12, description="Guest user menu Testcase 12: Check guest user can not go to subscription buy page without login",groups= {"guest"})
	public void buyPremiumButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		driver.findElement(AppiumBy.accessibilityId("Subscription")).click();
		driver.findElement(AppiumBy.accessibilityId("প্রিমিয়াম কিনুন")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).getAttribute("contentDescription");
		String expectedTitle="Continue with Google";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	

	
	@Test(priority=13, description="Guest user menu Testcase 13: Check guest user can access help and feedback page",groups= {"guest"})
	public void helpAndFeedbackButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",1.0));
		driver.findElement(AppiumBy.accessibilityId("Help and feedback")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
		String expectedTitle="Help and Feedback";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=14, description="Guest user menu Testcase 14: Check guest user can't access notification from help and feedback page",groups= {"guest"})
	public void helpAndFeedbackNotificationButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",1.0));
		driver.findElement(AppiumBy.accessibilityId("Help and feedback")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).getAttribute("contentDescription");
		String expectedTitle="Continue with Google";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}	
	
	@Test(priority=15, description="Guest user menu Testcase 15: Check guest user can access search from help and feedback page",groups= {"guest"})
	public void helpAndFeedbackSearchButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",1.0));
		driver.findElement(AppiumBy.accessibilityId("Help and feedback")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[7]")).getAttribute("contentDescription");
		String expectedTitle="Popular Search";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=16, description="Guest user menu Testcase 16: Check guest user can't sent any question from help and feedback page",groups= {"guest"})
	public void FAQCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",1.0));
		driver.findElement(AppiumBy.accessibilityId("Help and feedback")).click();
		 WebElement email=driver.findElement(By.xpath("(//android.widget.EditText)[1]"));
		 email.click();
		 email.sendKeys("siam@gmail.com");
		 scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",1.0));
		 WebElement name=driver.findElement(By.xpath("(//android.widget.EditText)[2]"));
		 name.click();
		 name.sendKeys("siam");
		 WebElement subject=driver.findElement(By.xpath("(//android.widget.EditText)[3]"));
		 subject.click();
		 subject.sendKeys("test");
		 WebElement description=driver.findElement(By.xpath("(//android.widget.EditText)[4]"));
		 description.click();
		 description.sendKeys("test");
		driver.findElement(AppiumBy.accessibilityId("Send")).click();
		driver.navigate().back();
		String actualToast=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
		String expectedToast="Report sending failed";
		Assert.assertEquals(actualToast,expectedToast,"Title didn't matched");
	}
	
	@Test(priority=17, description="Guest user menu Testcase 17: Check guest user can access privacy page",groups= {"guest"})
	public void privacyButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",1.0));
		driver.findElement(AppiumBy.accessibilityId("Privacy")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[5]")).getAttribute("contentDescription");
		String expectedTitle="Privacy";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=18, description="Guest user menu Testcase 18: Check guest user can't access notification from privacy page",groups= {"guest"})
	public void privacyNotificationButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",1.0));
		driver.findElement(AppiumBy.accessibilityId("Privacy")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[2]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).getAttribute("contentDescription");
		String expectedTitle="Continue with Google";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}	
	
	@Test(priority=19, description="Guest user menu Testcase 19: Check guest user can access search from privacy page",groups= {"guest"})
	public void privacySearchButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",1.0));
		driver.findElement(AppiumBy.accessibilityId("Privacy")).click();
		driver.findElement(By.xpath("(//android.widget.ImageView)[3]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.view.View)[7]")).getAttribute("contentDescription");
		String expectedTitle="Popular Search";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
	
	@Test(priority=20, description="Guest user menu Testcase 20: Check guest user can access share button",groups= {"guest"})
	public void shareButtonCheck() {
		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",1.0));
		driver.findElement(AppiumBy.accessibilityId("Share")).click();
//		driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		String pageTitle=driver.findElement(By.xpath("(//android.widget.TextView)[1]")).getText();
		String expectedTitle="Sharing text";
		Assert.assertEquals(pageTitle,expectedTitle,"Title didn't matched");
	}
}
