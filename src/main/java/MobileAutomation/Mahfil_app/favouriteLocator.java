package MobileAutomation.Mahfil_app;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class favouriteLocator {
	AndroidDriver driver;
	public favouriteLocator(AndroidDriver driver) {
//		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Favourite page title locators
	@AndroidFindBy(xpath="(//android.view.View)[6]")
	private WebElement favouritePageTitle;
	
	//Empty Download page  locators
	@AndroidFindBy(accessibility="There are no favorites yet!")
	private WebElement emptyFavouritePageTitle;
	
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
	
	//downloaed video locators
	@AndroidFindBy(xpath="(//android.view.View)[9]")
	private WebElement favouriteVideo;
	
	//offline see downloaded video locators
	@AndroidFindBy(accessibility="See Downloaded videos")
	private WebElement seeVideo;
	
	//Favourite video elipsis locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[4]")
	private WebElement ellipsisButton;
	
	//Favourite video remove button locators
	@AndroidFindBy(xpath="(//android.widget.Button)[1]")
	private WebElement removeButton;
	
	//Back button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[1]")
	private WebElement backButton;
	
	
	
	public void playFavouriteVideo() {
		favouriteVideo.click();
	}
	
	public void clickNotification() {
		notificationButton.click();
	}
	public void clickSearch() {
		searchButton.click();
	}

	public void clickSeeDownloadedVideo() {
		seeVideo.click();
	}
	
	public void clickEllipsis() throws InterruptedException {
		Thread.sleep(500);
		ellipsisButton.click();
	}
	
	public void clickRemove() throws InterruptedException {
		Thread.sleep(1000);
		removeButton.click();
	}
	public void back() {
		driver.navigate().back();
	}
	public void clickBackButton() {
		backButton.click();
	}

	
	public void checkTitle(String page, String title) {
		String actualTitle="";
		if(page.equals("favouritePageTitle"))
		{
			actualTitle=favouritePageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("emptyFavouritePageTitle"))
		{
			actualTitle=emptyFavouritePageTitle.getAttribute("contentDescription");
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
