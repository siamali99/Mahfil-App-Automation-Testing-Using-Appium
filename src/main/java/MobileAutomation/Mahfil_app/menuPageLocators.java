package MobileAutomation.Mahfil_app;
import java.util.NoSuchElementException;

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
public class menuPageLocators extends AndroidActions{
	
	AndroidDriver driver;
	public menuPageLocators(AndroidDriver driver) {
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
	//Download button
	@AndroidFindBy(xpath="(//android.widget.ImageView)[5]")
	private WebElement downloadButton;
	//Favourite button
	@AndroidFindBy(xpath="(//android.widget.ImageView)[6]")
	private WebElement favouriteButton;
	//Watch Hisotry button
	@AndroidFindBy(xpath="(//android.widget.ImageView)[7]")
	private WebElement watchHisotryButton;
	//Subscribed Channel button
	@AndroidFindBy(xpath="(//android.widget.ImageView)[8]")
	private WebElement subscribedChannelButton;
	//Salat Reminder button
	@AndroidFindBy(xpath="(//android.widget.ImageView)[9]")
	private WebElement salatReminderButton;
	//Settings button
	@AndroidFindBy(xpath="(//android.widget.ImageView)[10]")
	private WebElement settingsButton;
	//Subscription button
	@AndroidFindBy(xpath="(//android.widget.ImageView)[11]")
	private WebElement subscriptionButton;
	//Help and Feedback button
	@AndroidFindBy(accessibility="Help and feedback")
	private WebElement helpAndFeedbackButton;
	//Privacy button
	@AndroidFindBy(accessibility="Privacy")
	private WebElement privacyButton;
	//Rate us button
	@AndroidFindBy(accessibility="Privacy")
	private WebElement rateUsButton;
	//Share button
	@AndroidFindBy(accessibility="Privacy")
	private WebElement shareButton;
	//Sign in button
	@AndroidFindBy(accessibility="Sign In")
	private WebElement signInButton;
	//Authentication accessbutton//android.widget.ScrollView/android.widget.ImageView[9]
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.widget.ImageView[9]")
	private WebElement authButton;
	//logout button
	@AndroidFindBy(accessibility="Logout")
	private WebElement logoutButton;
	//Yes button
	@AndroidFindBy(accessibility="Yes")
	private WebElement yesButton;
	
	//premium pop up identifier
	@AndroidFindBy(xpath="(//android.widget.Button)")
	private WebElement premiumPopUpTitle;
	//Premium pop up close button
	@AndroidFindBy(xpath="(//android.widget.ImageView)[2]")
	private WebElement premiumClose;
	//Menu page title locators
	@AndroidFindBy(xpath="(//android.view.View)[6]")
	private WebElement menuTitle;
	
	@AndroidFindBy(xpath="(//android.widget.ImageView)[3]")
	private WebElement SignupPageTitle;
	
	public void clickMenu() {
		menuButton.click();
	}
	public void clickDashboard() throws InterruptedException {
		Thread.sleep(1000);
		dashboardButton.click();
	}
	public void clickDownload() throws InterruptedException {
		Thread.sleep(1000);
		downloadButton.click();
	}
	public void clickFavourite() throws InterruptedException {
		Thread.sleep(1000);
		favouriteButton.click();
	}
	public void clickWatchHisotry() throws InterruptedException {
		Thread.sleep(500);
		watchHisotryButton.click();
		Thread.sleep(1000);
	}
	
	public void clickSubscribedChannel() throws InterruptedException {
		Thread.sleep(500);
		subscribedChannelButton.click();
	}
	public void clickSalatReminder() throws InterruptedException {
		Thread.sleep(500);
		salatReminderButton.click();
	}
	public void clickSettings() throws InterruptedException {
		Thread.sleep(500);
		settingsButton.click();
	}
	public void clickSubscription() throws InterruptedException {
		Thread.sleep(500);
		subscriptionButton.click();
	}
	public void clickHelpAndFeedback() throws InterruptedException {
		Thread.sleep(500);
		helpAndFeedbackButton.click();
	}
	public void clickPrivacy() throws InterruptedException {
		Thread.sleep(500);
		privacyButton.click();
	}
	public void clickRateUs() throws InterruptedException {
		Thread.sleep(500);
		rateUsButton.click();
	}
	public void clickShare() throws InterruptedException {
		Thread.sleep(500);
		shareButton.click();
	}
	public void back() throws InterruptedException {
		driver.navigate().back();
	}
	
	public void clickSignIn() throws InterruptedException {
		String text=authButton.getAttribute("contentDescription");
		System.out.println(text);
		if(text.equals("Logout"))
		{
			logoutButton.click();
			yesButton.click();
			signInButton.click();
		}
		else
		{
			signInButton.click();
		}
	}
	public void clickLogout() throws InterruptedException {
		Thread.sleep(500);
		String text=authButton.getAttribute("contentDescription");
		if(text.equals("Logout"))
		{
			logoutButton.click();
			yesButton.click();
		}
	}
	public void closePremiumPopUp() {
		premiumClose.click();
	}
	
	public void Scroll(int times) throws InterruptedException {
		Thread.sleep(300);
		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",times));
	}
	
	public void checkTitle(String page, String title) {
		String actualTitle="";
		if(page.equals("premiumPopUpTitle"))
		{
			actualTitle=premiumPopUpTitle.getAttribute("contentDescription");
		}
		else if(page.equals("menuTitle"))
		{
			actualTitle=menuTitle.getAttribute("contentDescription");
		}
		else if(page.equals("downloadButton"))
		{
			actualTitle=downloadButton.getAttribute("contentDescription");
		}
		else if(page.equals("watchHisotryButton"))
		{
			actualTitle=watchHisotryButton.getAttribute("contentDescription");
		}
		else if(page.equals("subscribedChannelButton"))
		{
			actualTitle=subscribedChannelButton.getAttribute("contentDescription");
		}
		else if(page.equals("SignupPageTitle"))
		{
			actualTitle=SignupPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("authButton"))
		{
			actualTitle=authButton.getAttribute("contentDescription");
		}

		System.out.println(actualTitle);
		String expectedTitle=title;
		Assert.assertEquals(actualTitle,expectedTitle,"Title didn't matched");

	}
	
}
