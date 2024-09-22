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

public class LiveDashboard extends configAppium{
	
	public LiveDashboardLocators dashboard;
	public menuPageLocators menu;
	 @BeforeMethod
	 public void before() throws InterruptedException {
		 dashboard=new LiveDashboardLocators(driver);
		 menu=new menuPageLocators(driver);
		 menu.clickMenu();
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
	
	
	@Test(priority=1, description="Livedashboard Testcase 01: Check live dashboard button is working",groups= {"general","premium"})
	public void dashboardButtonCheck() throws InterruptedException {
		menu.clickDashboard();
		dashboard.checkTitle("dashboardPageTitle","Live Dashboard");
	}
	
	@Test(priority=2, description="Livedashboard Testcase 02: Check notification button is working in live dashboard page",groups= {"general","premium"})
	public void notificationButtonCheck() throws InterruptedException {
		menu.clickDashboard();
		dashboard.clickNotification();
		dashboard.checkTitle("notificationPageTitle","Notifications");
	}
	
	@Test(priority=3, description="Livedashboard Testcase 03: Check search button is working in live dashboard page",groups= {"general","premium"})
	public void searchButtonCheck() throws InterruptedException {
		menu.clickDashboard();
		dashboard.clickSearch();
		dashboard.checkTitle("searchPageTitle","Popular Search");
	}
	
	@Test(priority=4, description="Livedashboard Testcase 04: Check back button is working from live dashboard page",groups= {"general","premium"})
	public void backButtonCheck() throws InterruptedException {
		menu.clickDashboard();
		dashboard.clickBackButton();
		dashboard.checkTitle("menuTitle","Others");
	}
	
	@Test(priority=5, description="Livedashboard Testcase 05: Check channel is opening from live dashboard on logo click",groups= {"general","premium"})
	public void channelLogoCheck() throws InterruptedException {
		menu.clickDashboard();
		dashboard.clickChannelLogo();
		dashboard.checkTitle("channelTitle","Azhari tv");
	}
	
	@Test(priority=6, description="Livedashboard Testcase 06: Check channel is opening from live dashboard on channel name click",groups= {"general"})
	public void channelNameCheck() throws InterruptedException {
		menu.clickDashboard();
		dashboard.clickChannelName();
		dashboard.checkTitle("channelTitle","Azhari tv");
	}
	
	@Test(priority=7, description="Livedashboard Testcase 07: Check video is playing from live dashboard on click",groups= {"general"})
	public void LiveVideoCheck() throws InterruptedException {
		
		menu.clickDashboard();
		dashboard.playLiveVideo();
		dashboard.checkTitle("liveVideoPlayerPage","Related Videos");
	}
	
	@Test(priority=8, description="Livedashboard Testcase 08: Check subscribe button is working in live dashboard",groups= {"general","premium"})
	public void subscribeButtonCheck() throws InterruptedException {
		menu.clickDashboard();
		dashboard.clickSubscribeButton();
		dashboard.checkTitle("subscribeButtonTitle","Subscribed");

	}
	
	@Test(priority=9, description="Livedashboard Testcase 09: Check unsubscribe button is working in live dashboard",groups= {"general","premium"})
	public void unsubscribeButtonCheck() throws InterruptedException {
		menu.clickDashboard();
		dashboard.clickUnSubscribeButton();
		dashboard.checkTitle("subscribeButtonTitle","Subscribe");
	}
	
	
	@Test(priority=11, description="Livedashboard Testcase 11: Check live video share is working in live dashboard",groups= {"general","premium"})
	public void liveshareCheck() throws InterruptedException {
		menu.clickDashboard();
		dashboard.clickElipsis();
		dashboard.clickShare();
		dashboard.checkTitle("sharePageTitle", "Sharing link");
	}
	
	@Test(priority=12, description="Livedashboard Testcase 12: Check live video add to favourite is working in live dashboard",groups= {"general","premium"})
	public void adFavCheck() throws InterruptedException {
		
		menu.clickDashboard();
		dashboard.clickElipsis();
		dashboard.clickFavourite();
		dashboard.clickElipsis();
		dashboard.checkTitle("addFavouriteButton"," Remove from Favorite");
	}
	
	@Test(priority=13, description="Livedashboard Testcase 13: Check live video remove from favourite is working in live dashboard",groups= {"general","premium"})
	public void removeFavCheck() throws InterruptedException {
		
		menu.clickDashboard();
		dashboard.clickElipsis();
		dashboard.clickFavourite();
		dashboard.clickElipsis();
		dashboard.checkTitle("addFavouriteButton","Add to Favourite");

	}
	
	@Test(priority=14, description="Livedashboard Testcase 13: Check report video is working in live dashboard",groups= {"general","premium"})
	public void reportCheck() throws InterruptedException {
		menu.clickDashboard();
		dashboard.clickElipsis();
		dashboard.clickReportbutton();
		dashboard.report();
		dashboard.clickElipsis();
		dashboard.checkTitle("reportButton","Already Reported");

	}

}
