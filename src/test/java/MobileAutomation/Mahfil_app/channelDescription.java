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

public class channelDescription extends configAppium{
	public channelDescriptionPageLocators channel;
	 @BeforeMethod
	 public void before() {
		 channel=new channelDescriptionPageLocators(driver);
		 channel.clickPopularChannel();
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
	

	
	@Test(priority=1, description="Channel Description Page Testcase 01: Check notification is not accessable by guest user",groups= {"guest"})
	public void guestNotificationButtonCheck() {
		channel.clickNotification();
		channel.checkTitle("SignupPageTitle","Continue with Google");
	}
	
	@Test(priority=2, description="Channel Description Page Testcase 02: Check search is accessable by guest user",groups= {"guest"})
	public void searchButtonCheck() {
		channel.clickSearch();
		channel.checkTitle("searchPageTitle","Popular Search");
	}
	
	@Test(priority=3, description="Channel Description Page Testcase 03: Check subscribe button click take guest user to login page",groups= {"guest"})
	public void guestSubscribeButtonCheck() {
		channel.clickSubscribe();
		channel.checkTitle("SignupPageTitle","Continue with Google");
	}
	
	@Test(priority=4, description="Channel Description Page Testcase 04: Check guest user can share general video from channel description page",groups= {"guest"})
	public void guestShareButtonCheckGeneralVideo() throws InterruptedException {
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
		
	}
	
	@Test(priority=5, description="Channel Description Page Testcase 05: Check guest user can share premium video from channel description page",groups= {"guest"})
	public void guestShareButtonCheckPremiumVideo() throws InterruptedException {
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickShare();
		channel.checkTitle("sharePageTitle", "Sharing link");
		
	}
	
	@Test(priority=6, description="Channel Description Page Testcase 06: Check guest user can not add general video to favourite  from channel description page",groups= {"guest"})
	public void guestAdFavButtonCheckGeneralVideo() throws InterruptedException {
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		channel.checkTitle("SignupPageTitle","Continue with Google");
	}
	
	@Test(priority=7, description="Channel Description Page Testcase 07: Check guest user can not add premium video to favourite  from channel description page",groups= {"guest"})
	public void guestAdFavButtonCheckPremiumVideo() throws InterruptedException {
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickFavourite();
		channel.checkTitle("SignupPageTitle","Continue with Google");
	}
	
	@Test(priority=8, description="Channel Description Page Testcase 09: Check guest user can not report general video from channel description page",groups= {"guest"})
	public void guestReportButtonCheckGeneralVideo() throws InterruptedException {
		channel.findGeneralVideo();
		channel.clickElipsis();
		channel.clickReportbutton();
		channel.checkTitle("SignupPageTitle","Continue with Google");
	}
	
	@Test(priority=10, description="Channel Description Page Testcase 10: Check guest user can not report premium video from channel description page",groups= {"guest"})
	public void guestReportButtonCheckPremiumVideo() throws InterruptedException {
		channel.findPremiumVideo();
		channel.clickElipsis();
		channel.clickReportbutton();
		channel.checkTitle("SignupPageTitle","Continue with Google");
	}
	
	@Test(priority=11, description="Channel Description Page Testcase 012: Check guest user can play general video from channel description page",groups= {"guest"})
	public void guestGeneralVideoPlayCheck() throws InterruptedException {
		channel.findGeneralVideo();
		channel.playVideo();
		channel.checkTitle("videoPlayerPageTitle","Related Videos");
	}
	
	@Test(priority=13, description="Channel Description Page Testcase 013: Check guest user can not  play premium video from channel description page",groups= {"guest"})
	public void guestPremiumVideoPlayCheck() throws InterruptedException {
		channel.findPremiumVideo();
		channel.playVideo();
		channel.checkTitle("SignupPageTitle","Continue with Google");
	}
	
	
	
	


	
	
	

	
}
