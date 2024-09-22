package MobileAutomation.Mahfil_app;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import MobileAutomation.Mahfil_app.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
public class channelDescriptionPageLocators extends AndroidActions{
	
	AndroidDriver driver;
	public channelDescriptionPageLocators(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//Popular channel locators
	@AndroidFindBy(xpath="(//android.widget.HorizontalScrollView/android.view.View)[2]")
	private WebElement popularChannelButton;
	@AndroidFindBy(xpath="(//android.view.View)[12]")
	private WebElement premiumPopularChannelButton;
	@AndroidFindBy(xpath="(//android.widget.HorizontalScrollView/android.view.View)[3]")
	private WebElement popularChannelName;
	@AndroidFindBy(xpath="(//android.view.View)[6]")
	private WebElement channelPageTitle;
	
	//Notification Page locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[2]")
	private WebElement notificationButton;
	@AndroidFindBy(xpath="(//android.view.View)[5]")
	private WebElement notificationPageTitle;
	
	
	@AndroidFindBy(xpath="(//android.widget.ImageView)[3]")
	private WebElement SignupPageTitle;
	
	//Search Page locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[3]")
	private WebElement searchButton;
	@AndroidFindBy(xpath="(//android.view.View)[7]")
	private WebElement searchPageTitle;
	

	//subscribe button locators
	@AndroidFindBy(accessibility="Subscribe")
	private WebElement subscribeButton;
	@AndroidFindBy(accessibility="Subscribed")
	private WebElement subscribedButton;
	@AndroidFindBy(xpath="(//android.widget.ImageView)[4]")
	private WebElement subscribeButtonTitle;
	@AndroidFindBy(accessibility = "Yes")
	private WebElement yesButton;

	
	//elipsis button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[5]")
	private WebElement elipsisButton;
	
	//share button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[1]")
	private WebElement shareButton;
	@AndroidFindBy(id="com.android.intentresolver:id/headline")
	private WebElement sharePageTitle;
	
	//add to favourite button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[2]")
	private WebElement addFavouriteButton;
	
	//report button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[3]")
	private WebElement reportButton;
	
	//video locators
	@AndroidFindBy(xpath="(//android.widget.ScrollView//android.view.View)[6]")
	private WebElement video;
	
	
	//Video player identifer Related Videos
//	@AndroidFindBy(xpath="(//android.widget.HorizontalScrollView//android.widget.ImageView)[4]")
	@AndroidFindBy(accessibility = "Related Videos")
	private WebElement videoPlayerPageTitle;
	
	//Video cut button premim
	@AndroidFindBy(xpath="//android.widget.Button[2]")
	private WebElement cutVideo;
	//premium pop up identifier
	@AndroidFindBy(xpath="(//android.widget.Button)")
	private WebElement premiumPopUpTitle;
	
	//playlist locators
	@AndroidFindBy(xpath="(//android.view.View)[12]")
	private WebElement playlistTab;
	@AndroidFindBy(xpath="(//android.widget.ImageView)[5]")
	private WebElement playlist;
	@AndroidFindBy(accessibility = "Playlist Videos")
	private WebElement playlistPlayerPageTitle;

	public void clickNotification() {
		notificationButton.click();
	}
	
	public void clickSearch() {
		searchButton.click();
	}
	
	public String checkClickedPopularChannelName() {
		String expectedTitle=popularChannelName.getAttribute("contentDescription");
		return expectedTitle;
	}
	public void clickPopularChannel() {
		
		popularChannelButton.click();
	}
	
	public void clickPopularChannelPremium() {
		
		premiumPopularChannelButton.click();
	}
	
	public void clickSubscribe() {
		subscribeButton.click();
	}
	
	public void clickUnSubscribe() throws InterruptedException {
		subscribedButton.click();
		yesButton.click();

	}
	
	public void Scroll(int times) {
		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",times));
	}
	
	public void clickElipsis() {
		elipsisButton.click();
	}
	public void clickShare() {
		shareButton.click();
	}	
	public void clickFavourite() {
		addFavouriteButton.click();
	}
	
	
	public void clickReportbutton() {
		reportButton.click();
	}
	public void report() {
		driver.findElement(AppiumBy.accessibilityId("Spam or misleading")).click();
		driver.findElement(AppiumBy.accessibilityId("Report")).click();
		
	}
	
	public void playVideo() throws InterruptedException {
		video.click();
//		Thread.sleep(2000);
	}
	
	public void stopVideo() throws InterruptedException {
		Thread.sleep(5000);
		driver.navigate().back();
		cutVideo.click();
	}
	
	public void findPremiumVideo() throws InterruptedException {
		while(true)
		{
			String text=video.getAttribute("contentDescription");
			if(text.contains("Premium") && text.contains("views"))
			{
				break;
			}
			else
			{
				Scroll(1);
			}
		}
	}
	
	public void findGeneralVideo() throws InterruptedException {
//		Scroll(2);
		while(true)
		{
			String text=video.getAttribute("contentDescription");
			if(text.contains("views") && !text.contains("Premium"))
			{
				break;
			}
			else
			{
				Scroll(1);
			}
		}
	}
	
	public void clickPlaylistTab() throws InterruptedException {
		Thread.sleep(2000);
		playlistTab.click();
	}
	
	public void clickPlaylist() {
		playlist.click();
	}
	
	
	
	public void checkTitle(String page, String title) {
		String actualTitle="";
		if(page.equals("SignupPageTitle"))
		{
			actualTitle=SignupPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("searchPageTitle"))
		{
			actualTitle=searchPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("channelPageTitle"))
		{
			actualTitle=channelPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("sharePageTitle"))
		{
			actualTitle=sharePageTitle.getText();
		}
		else if(page.equals("videoPlayerPageTitle"))
		{
			actualTitle=videoPlayerPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("notificationPageTitle"))
		{
			actualTitle=notificationPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("subscribeButtonTitle"))
		{
			actualTitle=subscribeButtonTitle.getAttribute("contentDescription");
		}
		else if(page.equals("addFavouriteButton"))
		{
			actualTitle=addFavouriteButton.getAttribute("contentDescription");
		}
		else if(page.equals("reportButton"))
		{
			actualTitle=reportButton.getAttribute("contentDescription");
		}
		else if(page.equals("premiumPopUpTitle"))
		{
			actualTitle=premiumPopUpTitle.getAttribute("contentDescription");
		}
		else if(page.equals("playlistPlayerPageTitle"))
		{
			actualTitle=playlistPlayerPageTitle.getAttribute("contentDescription");
		}
		System.out.println(actualTitle);
		String expectedTitle=title;
		Assert.assertEquals(actualTitle,expectedTitle,"Title didn't matched");

	}
	
	


}
