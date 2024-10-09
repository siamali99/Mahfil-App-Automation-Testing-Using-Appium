package MobileAutomation.Mahfil_app;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class watchHistoryLocators {
	AndroidDriver driver;
	public watchHistoryLocators(AndroidDriver driver) {
//		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Watch History page title locators
	@AndroidFindBy(accessibility="Watch History")
	private WebElement watchHistoryPageTitle;
	
	//Empty Watch History page  locators
	@AndroidFindBy(accessibility="There are no favorites yet!")
	private WebElement emptyWatchHistoryPageTitle;
	
	//Notification button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[2]")
	private WebElement notificationButton;
	//Dashboard page title locators
	@AndroidFindBy(xpath="(//android.view.View)[6]")
	private WebElement notificationPageTitle;
	
	//Search button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[3]")
	private WebElement searchButton;
	//Search page title locators
	@AndroidFindBy(xpath="(//android.view.View)[8]")
	private WebElement searchPageTitle;
	
	//Watch History video locators
	@AndroidFindBy(xpath="(//android.view.View)[10]")
	private WebElement watchHistoryVideo;
	

	
	//Watch History video elipsis locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[4]")
	private WebElement ellipsisButton;
	
	//Watch History video remove button locators
	@AndroidFindBy(xpath="(//android.widget.Button)[1]")
	private WebElement removeButton;
	@AndroidFindBy(accessibility="Yes")
	private WebElement yesButton;
	
	
	
	
	public void playwatchHistoryVideo() {
		watchHistoryVideo.click();
	}
	
	public void clickNotification() {
		notificationButton.click();
	}
	public void clickSearch() {
		searchButton.click();
	}
	//Back button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[1]")
	private WebElement backButton;

	
	public void clickEllipsis() throws InterruptedException {
		Thread.sleep(500);
		ellipsisButton.click();
	}
	
	public void clickRemove() throws InterruptedException {
		Thread.sleep(1000);
		removeButton.click();
		yesButton.click();
	}
	public void back() {
		driver.navigate().back();
	}
	public void clickBackButton() {
		backButton.click();
	}

	
	public void checkTitle(String page, String title) {
		String actualTitle="";
		if(page.equals("watchHistoryPageTitle"))
		{
			actualTitle=watchHistoryPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("emptyWatchHistoryPageTitle"))
		{
			actualTitle=emptyWatchHistoryPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("notificationPageTitle"))
		{
			actualTitle=notificationPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("searchPageTitle"))
		{
			actualTitle=searchPageTitle.getAttribute("contentDescription");
		}

		System.out.println(actualTitle);
		String expectedTitle=title;
		Assert.assertEquals(actualTitle,expectedTitle,"Title didn't matched");

	}
}
