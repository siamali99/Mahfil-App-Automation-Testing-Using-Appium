package MobileAutomation.Mahfil_app;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class helpAndFeedback extends configAppium{
	
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
//			else
//			{
//				driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
//			}
//			
//			driver.findElement(AppiumBy.accessibilityId("Continue with Email")).click();
//			WebElement email=driver.findElement(By.className("android.widget.EditText"));
//			email.click();
//			email.sendKeys("general.mahfil@gmail.com");
//			driver.findElement(AppiumBy.accessibilityId("Continue")).click();
//			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("0");
//			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("1");
//			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("1");
//			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("0");
//			driver.findElement(AppiumBy.accessibilityId("Continue")).click();
//			driver.navigate().back();
//	 }
	public menuPageLocators menu;
	public homePageLocators home;
	public helpAndFeedbackLocators feedback;

	 @BeforeMethod
	 public void before() throws InterruptedException {
		 menu=new menuPageLocators(driver);
		 home=new homePageLocators(driver);
		 feedback=new helpAndFeedbackLocators(driver);
		 Thread.sleep(200);
		 home.clickMenu();
		 menu.Scroll(1);
		 menu.clickHelpAndFeedback();
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
	
	@Test(priority=1, description="Help and feedback Testcase 01: Check Help and feedback button is working",groups= {"general"})
	public void subscriptionButtonCheck() throws InterruptedException {
		feedback.checkTitle("feedbackPageTitle", "Help and Feedback");
	}
	
	@Test(priority=2, description="Help and feedback Testcase 02: Check notification button is working in Help and feedback page",groups= {"general"})
	public void notificationButtonCheck() throws InterruptedException {
		feedback.clickNotification();
		feedback.checkTitle("notificationPageTitle", "Notifications");
	}
	
	@Test(priority=3, description="Help and feedback Testcase 03: Check search button is working in Help and feedback page",groups= {"general"})
	public void searchButtonCheck() {
		
		feedback.clickSearch();
		feedback.checkTitle("searchPageTitle", "Popular Search");
	}
	
	@Test(priority=4, description="Help and feedback Testcase 04: Check back button is working from Help and feedback page",groups= {"general"})
	public void backButtonCheck() {
		feedback.clickBackButton();
		menu.checkTitle("menuTitle","Others");
	}
	
	
	@Test(priority=5, description="Help and feedback Testcase 05: Check question is not sent by keeping all the field empty from Help and feedback page",groups= {"general"})
	public void FAQCheck1() {
		feedback.clickSendButton();
		feedback.checkTitle("toastMessage", "Fields are incorrect");
	}

	@Test(priority=6, description="Help and feedback Testcase 06: Check question is not sent by giving only spaces in inputs from Help and feedback page",groups= {"general"})
	public void FAQCheck2() {
		feedback.enterEmail("     ");
		feedback.Scroll(1);
		feedback.enterName("     ");
		feedback.enterSubject("     ");
		feedback.enterDescription("     ");
		feedback.clickSendButton();
		feedback.checkTitle("toastMessage", "Fields are incorrect");
	}
	
	@Test(priority=7, description="Help and feedback Testcase 07: Check question is not sent by giving invalid email in Help and feedback page",groups= {"general"})
	public void FAQCheck3() {
		feedback.enterEmail("siam@com");
		feedback.Scroll(1);
		feedback.enterName("siam");
		feedback.enterSubject("test");
		feedback.enterDescription("Test");
		feedback.clickSendButton();
		feedback.checkTitle("toastMessage", "Fields are incorrect");
	}
	
	@Test(priority=8, description="Help and feedback Testcase 08: Check question is not sent by giving invalid email in Help and feedback page",groups= {"general"})
	public void FAQCheck4() {
		feedback.enterEmail("siam.com");
		feedback.Scroll(1);
		feedback.enterName("siam");
		feedback.enterSubject("test");
		feedback.enterDescription("Test");
		feedback.clickSendButton();
		feedback.checkTitle("toastMessage", "Fields are incorrect");
	}
	
	@Test(priority=9, description="Help and feedback Testcase 09: Check question is not sent by giving spaces in name fields in Help and feedback page",groups= {"general"})
	public void FAQCheck5() {
		feedback.enterEmail("siam@gmail.com");
		feedback.Scroll(1);
		feedback.enterName("     ");
		feedback.enterSubject("test");
		feedback.enterDescription("Test");
		feedback.clickSendButton();
		feedback.checkTitle("toastMessage", "Fields are incorrect");
	}
	
	@Test(priority=10, description="Help and feedback Testcase 10: Check question is not sent by giving spaces in other fields in Help and feedback page",groups= {"general"})
	public void FAQCheck6() {
		feedback.enterEmail("siam@gmail.com");
		feedback.Scroll(1);
		feedback.enterName("siam");
		feedback.enterSubject("   ");
		feedback.enterDescription("    ");
		feedback.clickSendButton();
		feedback.checkTitle("toastMessage", "Fields are incorrect");
	}
	
	@Test(priority=11, description="Help and feedback Testcase 11: Check question is  sent by giving  valid input in Help and feedback page",groups= {"general"})
	public void FAQCheck7() {
		feedback.enterEmail("siam@gmail.com");
		feedback.Scroll(1);
		feedback.enterName("siam");
		feedback.enterSubject("test");
		feedback.enterDescription("test");
		feedback.clickSendButton();
		feedback.checkTitle("toastMessage", "Report sending successful");
//		 WebElement email=driver.findElement(By.xpath("(//android.widget.EditText)[1]"));
//		 email.click();
//		 email.sendKeys("siam@gmail.com");
//		 boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",1.0));
//		 WebElement name=driver.findElement(By.xpath("(//android.widget.EditText)[2]"));
//		 name.click();
//		 name.sendKeys("siam");
//		 WebElement subject=driver.findElement(By.xpath("(//android.widget.EditText)[3]"));
//		 subject.click();
//		 subject.sendKeys("test");
//		 WebElement description=driver.findElement(By.xpath("(//android.widget.EditText)[4]"));
//		 description.click();
//		 description.sendKeys("test");
//		driver.findElement(AppiumBy.accessibilityId("Send")).click();
////		driver.navigate().back();
//		String actualToast=driver.findElement(By.xpath("(//android.view.View)[6]")).getAttribute("contentDescription");
//		String expectedToast="Report sending successful";
//		Assert.assertEquals(actualToast,expectedToast,"Title didn't matched");
	}
	
}
