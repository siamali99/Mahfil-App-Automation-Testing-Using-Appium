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
public class LiveDashboardLocators extends AndroidActions{
	
	AndroidDriver driver;
	public LiveDashboardLocators(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//Menu button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[1]")
	private WebElement menuButton;
	
	//Dashboard button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[4]")
	private WebElement dashboardButton;
	//Dashboard page title locators
	@AndroidFindBy(xpath="(//android.view.View)[6]")
	private WebElement dashboardPageTitle;
	
	//Notification button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[2]")
	private WebElement notificationButton;
	//Dashboard page title locators
	@AndroidFindBy(xpath="(//android.view.View)[6]")
	private WebElement notificationPageTitle;
	
	//Search button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[3]")
	private WebElement searchButton;
	//Dashboard page title locators
	@AndroidFindBy(xpath="(//android.view.View)[8]")
	private WebElement searchPageTitle;
	
	//Back button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[1]")
	private WebElement backButton;
	//Dashboard page title locators
	@AndroidFindBy(xpath="(//android.view.View)[6]")
	private WebElement menuTitle;
	
	//Dashboard channel logo locators
	@AndroidFindBy(xpath="(//android.view.View)[10]")
	private WebElement channelLogo;
	//Dashboard channel name locators
	@AndroidFindBy(xpath="(//android.view.View)[8]")
	private WebElement channelName;
	//Dashboard page title locators
	@AndroidFindBy(xpath="(//android.view.View)[7]")
	private WebElement channelTitle;
	//Dashboard video locators
	@AndroidFindBy(xpath="(//android.view.View)[9]")
	private WebElement liveVideo;
	//Dashboard video player page locators
	@AndroidFindBy(accessibility = "Related Videos")
	private WebElement liveVideoPlayerPage;
	
	//Subscribe button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[4]")
	private WebElement subscribeButton;
	@AndroidFindBy(xpath="(//android.widget.ImageView)[4]")
	private WebElement subscribeButtonTitle;
	@AndroidFindBy(accessibility = "Yes")
	private WebElement yesButton;
	
	//Ellipsis button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[5]")
	private WebElement elipsisButton;
	//Share button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[1]")
	private WebElement shareButton;
	@AndroidFindBy(id="com.android.intentresolver:id/headline")
	private WebElement sharePageTitle;
	
	//Share button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[2]")
	private WebElement addFavouriteButton;
	
	//Share button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[3]")
	private WebElement reportButton;
	
	
	public void clickMenu() {
		menuButton.click();
	}
	public void clickDashboard() throws InterruptedException {
		Thread.sleep(1000);
		dashboardButton.click();
	}
	public void clickNotification() {
		notificationButton.click();
	}
	public void clickSearch() {
		searchButton.click();
	}
	public void clickBackButton() {
		backButton.click();
	}
	public void clickChannelLogo() throws InterruptedException {
		Thread.sleep(1000);
		channelLogo.click();
	}
	public void clickChannelName() throws InterruptedException {
		Thread.sleep(1000);
		channelName.click();
	}
	public void playLiveVideo() throws InterruptedException {
		Thread.sleep(1000);
		liveVideo.click();
	}
	public void clickSubscribeButton() {
		subscribeButton.click();
	}
	public void clickUnSubscribeButton() {
		subscribeButton.click();
		yesButton.click();
	}
	public void clickElipsis() throws InterruptedException {
		Thread.sleep(1000);
		elipsisButton.click();
	}
	public void clickShare() throws InterruptedException {
		Thread.sleep(1000);
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
	

	
	
	
	public void checkTitle(String page, String title) {
		String actualTitle="";
		if(page.equals("dashboardPageTitle"))
		{
			actualTitle=dashboardPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("notificationPageTitle"))
		{
			actualTitle=notificationPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("searchPageTitle"))
		{
			actualTitle=searchPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("menuTitle"))
		{
			actualTitle=menuTitle.getAttribute("contentDescription");
		}
		else if(page.equals("channelTitle"))
		{
			actualTitle=channelTitle.getAttribute("contentDescription");
		}
		else if(page.equals("liveVideoPlayerPage"))
		{
			actualTitle=liveVideoPlayerPage.getAttribute("contentDescription");
		}
		else if(page.equals("subscribeButtonTitle"))
		{
			actualTitle=subscribeButtonTitle.getAttribute("contentDescription");
		}
		else if(page.equals("sharePageTitle"))
		{
			actualTitle=sharePageTitle.getText();
		}
		else if(page.equals("addFavouriteButton"))
		{
			actualTitle=addFavouriteButton.getAttribute("contentDescription");
		}
		else if(page.equals("reportButton"))
		{
			actualTitle=reportButton.getAttribute("contentDescription");
		}
	
		System.out.println(actualTitle);
		String expectedTitle=title;
		Assert.assertEquals(actualTitle,expectedTitle,"Title didn't matched");

	}
	
	


}
