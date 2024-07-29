package MobileAutomation.Mahfil_app;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import MobileAutomation.Mahfil_app.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
public class homePageLocators extends AndroidActions{
	
	
	AndroidDriver driver;
	public homePageLocators(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Menu locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[1]")
	private WebElement menuButton;
	@AndroidFindBy(xpath="(//android.view.View)[5]")
	private WebElement menuPageTitle;
	
	//Notification Page locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[3]")
	private WebElement notificationButton;
	@AndroidFindBy(xpath="(//android.widget.ImageView)[3]")
	private WebElement SignupPageTitle;
	
	//Search Page locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[4]")
	private WebElement searchButton;
	@AndroidFindBy(xpath="(//android.view.View)[7]")
	private WebElement searchPageTitle;
	
	
	//Popular channel locators
	@AndroidFindBy(xpath="(//android.widget.HorizontalScrollView/android.view.View)[1]")
	private WebElement popularChannelButton;
	@AndroidFindBy(xpath="(//android.widget.HorizontalScrollView/android.view.View)[2]")
	private WebElement popularChannelName;
	@AndroidFindBy(xpath="(//android.view.View)[6]")
	private WebElement channelPageTitle;
	
	//Notification Page locators
	@AndroidFindBy(xpath="(//android.widget.HorizontalScrollView/android.widget.ImageView)[1]")
	private WebElement subscribeButton;
	
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
	
	//home video locators
	@AndroidFindBy(xpath="(//android.widget.ScrollView//android.view.View)[3]")
	private WebElement video;
	
	public void clickMenu() {
		menuButton.click();
	}

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
	
	public void clickSubscribe() {
		subscribeButton.click();
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
	public void clickReport() {
		reportButton.click();
	}
	
	public void playPremiumVideo() {
		while(true)
		{
			String text=video.getAttribute("contentDescription");
			if(text.contains("Premium"))
			{
				video.click();
				break;
			}
			else
			{
				Scroll(1);
			}
		}
	}
	
	public void playGeneralVideo() {
		while(true)
		{
			String text=video.getAttribute("contentDescription");
			if(text.contains("Premium"))
			{
				Scroll(1);
			}
			else
			{
				video.click();
				break;
			}
		}
	}
	
	
	public void checkTitle(String page, String title) {
		String actualTitle="";
		if(page.equals("SignupPageTitle"))
		{
			actualTitle=SignupPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("menuPageTitle"))
		{
			actualTitle=menuPageTitle.getAttribute("contentDescription");
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
		System.out.println(actualTitle);
		String expectedTitle=title;
		Assert.assertEquals(actualTitle,expectedTitle,"Title didn't matched");

	}
	
	


}
