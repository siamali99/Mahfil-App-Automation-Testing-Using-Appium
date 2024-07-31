package MobileAutomation.Mahfil_app;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;

public class Home extends configAppium{
	public homePageLocators home;
	 @BeforeGroups(value = "premium")
	    public void premiumLogin() {
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
	 
	 @BeforeGroups(value = "general")
	 public void generalLogin() {
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
			email.sendKeys("general.mahfil@gmail.com");
			driver.findElement(AppiumBy.accessibilityId("Continue")).click();
			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.EditText")).sendKeys("0");
			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.EditText")).sendKeys("1");
			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.EditText")).sendKeys("1");
			driver.findElement(By.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText")).sendKeys("0");
			driver.findElement(AppiumBy.accessibilityId("Continue")).click();
			driver.navigate().back();
	 }
	 @BeforeMethod
	 public void before() {
		 home=new homePageLocators(driver);
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
	

	
	@Test(priority=1, description="Home Testcase 01: Check menu section is opening",groups= {"all"})
	public void menuButtonCheck() {
//		homePageLocators home=new homePageLocators(driver);
		home.clickMenu();
		home.checkTitle("menuPageTitle","Others");
	}
	
	@Test(priority=2, description="Home Testcase 02: Check notification is not accessable",groups= {"guest"})
	public void guestnotificationButtonCheck() {
		home.clickNotification();
		//passing exoected page and page title
		home.checkTitle("SignupPageTitle","Continue with Google");
	}
	
	
	@Test(priority=3, description="Home Testcase 03: Check search is accessable",groups= {"guest"})
	public void searchButtonCheck() {
		home.clickSearch();
		home.checkTitle("searchPageTitle","Popular Search");
	}
	
	@Test(priority=4, description="Home Testcase 04: Check channel is opening from channel logo click",groups= {"guest"})
	public void channelLogoCheck() throws InterruptedException {
		String title=home.checkClickedPopularChannelName();
		home.clickPopularChannel();
		home.checkTitle("channelPageTitle",title);
	}
	
	@Test(priority=5, description="Home Testcase 05: Check subscribe button click taking guest user to login page",groups= {"guest"})
	public void guestSubscribeButtonCheck() throws InterruptedException {
		home.clickSubscribe();
		home.checkTitle("SignupPageTitle","Continue with Google");
	}
	
	
	@Test(priority=6, description="Home Testcase 06: Check general video is shareable as a guest user",groups= {"guest"})
	public void guestGeneralVideoShareCheck() throws InterruptedException {
//		home.Scroll(8);
		home.findGeneralVideo();
		home.clickElipsis();
		home.clickShare();
		home.checkTitle("sharePageTitle","Sharing link");
		}
	
	@Test(priority=7, description="Home Testcase 07: Check premium video is shareable as a guest user",groups= {"guest"})
	public void guestPremiumVideoShareCheck() throws InterruptedException {
//		home.Scroll(8);
		home.findPremiumVideo();
		home.clickElipsis();
		home.clickShare();
		home.checkTitle("sharePageTitle","Sharing link");
		}
	
	@Test(priority=8, description="Home Testcase 08: Check general video ad video favourite is not working as a guest user",groups= {"guest"})
	public void guestGeneralVideoAdFavCheck() throws InterruptedException {
//		home.Scroll(8);
		home.findGeneralVideo();
		home.clickElipsis();
		home.clickFavourite();
		home.checkTitle("SignupPageTitle","Continue with Google");
		}
	
	@Test(priority=9, description="Home Testcase 09: Check premium video ad video favourite is not working as a guest user",groups= {"guest"})
	public void guestPremiumVideoAdFavCheck() throws InterruptedException {
//		home.Scroll(8);
		home.findPremiumVideo();
		home.clickElipsis();
		home.clickFavourite();
		home.checkTitle("SignupPageTitle","Continue with Google");
		}
	
	@Test(priority=10, description="Home Testcase 10: Check video report is not working as a guest user",groups= {"guest"})
	public void guestGeneralVideoReportCheck() throws InterruptedException {
//		home.Scroll(8);
		home.findGeneralVideo();
		home.clickElipsis();
		home.clickReportbutton();
		home.checkTitle("SignupPageTitle","Continue with Google");
		}
	
	
	@Test(priority=11, description="Home Testcase 11: Check premium video report is not working as a guest user",groups= {"guest"})
	public void guestPremiumVideoReportCheck() throws InterruptedException {
//		home.Scroll(8);
		home.findPremiumVideo();
		home.clickElipsis();
		home.clickReportbutton();
		home.checkTitle("SignupPageTitle","Continue with Google");
		}
	
	@Test(priority=12, description="Home Testcase 12: Check premium video is not playable as a guest user",groups= {"guest"})
	public void guestPremiumVideoPlay() throws InterruptedException {
		home.findPremiumVideo();
		home.playVideo();
		home.checkTitle("SignupPageTitle","Continue with Google");
	
	}
	
	@Test(priority=13, description="Home Testcase 13: Check general video is playable as a guest user",groups= {"guest"})
	public void guestGeneralVideoPlay() throws InterruptedException {
		home.findGeneralVideo();
		home.playVideo();
		home.checkTitle("videoPlayerPageTitle","Related Videos");
	
	}
	
	@Test(priority=14, description="Home Testcase 14: Check notification is accessable",groups= {"general"})
	public void notificationButtonCheck() {
		home.clickNotification();
		//passing exoected page and page title
		home.checkTitle("notificationPageTitle","Notifications");
	}
	
	@Test(priority=15, description="Home Testcase 15: Check subscribe button is working",groups= {"general"})
	public void SubscribeButtonCheck() throws InterruptedException {
		home.clickSubscribe();
		home.checkTitle("subscribeButtonTitle","Subscribed");
	}
	
	@Test(priority=16, description="Home Testcase 16: Check unsubscribe button is working",groups= {"general"})
	public void unSubscribeButtonCheck() throws InterruptedException {
		home.clickUnSubscribe();
		home.checkTitle("subscribeButtonTitle","Subscribe");
	}
	
	
	@Test(priority=17, description="Home Testcase 17: Check general video ad to favourite is working",groups= {"general"})
	public void generalVideoAdFavButtonCheck() throws InterruptedException {
//		home.Scroll(7);
		home.findGeneralVideo();
		home.clickElipsis();
		home.clickFavourite();
		home.clickElipsis();
		home.checkTitle("addFavouriteButton"," Remove from Favorite");
		}
	
	@Test(priority=18, description="Home Testcase 18: Check general video remove from  favourite is working",groups= {"general"})
	public void generalVideoremoveFavButtonCheck() throws InterruptedException {
//		home.Scroll(7);
		home.findGeneralVideo();
		home.clickElipsis();
		home.clickFavourite();
//		Thread.sleep(1000);
		home.clickElipsis();
		home.checkTitle("addFavouriteButton","Add to Favourite");
		}
	
	
	@Test(priority=19, description="Home Testcase 19: Check general user can not ad premium video to favourite",groups= {"general"})
	public void premumVideoAdFavButtonCheck() throws InterruptedException {
//		home.Scroll(7);
		home.findPremiumVideo();
		home.clickElipsis();
		home.clickFavourite();
		home.checkTitle("premiumPopUpTitle","আজই প্রিমিয়াম কিনুন");
		}
	
	@Test(priority=20, description="Home Testcase 20: Check general user can not report premium video",groups= {"general"})
	public void premumVideoReportCheck() throws InterruptedException {
//		home.Scroll(7);
		home.findPremiumVideo();
		home.clickElipsis();
		home.clickReportbutton();
		home.checkTitle("premiumPopUpTitle","আজই প্রিমিয়াম কিনুন");
		}
	
	@Test(priority=21, description="Home Testcase 21: Check general user can report general video",groups= {"general"})
	public void generalVideoReportCheck() throws InterruptedException {
//		home.Scroll(7);
		home.findGeneralVideo();
		home.clickElipsis();
		home.clickReportbutton();
		home.report();
		home.clickElipsis();
		home.checkTitle("reportButton","Already Reported");
		}
	
	@Test(priority=22, description="Home Testcase 22: Check general user can not play premium video",groups= {"general"})
	public void premumVideoplayCheckByGeneralUser() throws InterruptedException {
//		home.Scroll(7);
		home.findPremiumVideo();
		home.playVideo();
		home.checkTitle("premiumPopUpTitle","আজই প্রিমিয়াম কিনুন");
		}
	
	
	@Test(priority=23, description="Home Testcase 23: Check premium user can ad premium video to favourite",groups= {"premium"})
	public void premumVideoAdFavCheckByPremiumUser() throws InterruptedException {
		home.findPremiumVideo();
		home.clickElipsis();
		home.clickFavourite();
		home.clickElipsis();
		home.checkTitle("addFavouriteButton"," Remove from Favorite");
		}
	
	@Test(priority=24, description="Home Testcase 24: Check premium user can ad premium video to favourite",groups= {"premium"})
	public void premumVideoReportCheckByPremiumUser() throws InterruptedException {
		home.findPremiumVideo();
		home.clickElipsis();
		home.clickReportbutton();
		home.report();
		home.clickElipsis();
		home.checkTitle("reportButton","Already Reported");
		}
	@Test(priority=25, description="Home Testcase 25: Check premium user can  play premium video",groups= {"premium"})
	public void premumVideoplayCheckByPremiumUser() throws InterruptedException {
		home.findPremiumVideo();
		home.playVideo();
		home.checkTitle("videoPlayerPageTitle","Related Videos");
		}

	
	
	

	
}
