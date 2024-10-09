package MobileAutomation.Mahfil_app;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class privacyLocators {
	AndroidDriver driver;
	public privacyLocators(AndroidDriver driver) {
//		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//privacy page title locators
	@AndroidFindBy(xpath="(//android.view.View)[6]")
	private WebElement privacyPageTitle;
	
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
	
	//Back button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[1]")
	private WebElement backButton;
	
	public void clickNotification() {
		notificationButton.click();
	}
	public void clickSearch() {
		searchButton.click();
	}
	public void clickBackButton() {
		backButton.click();
	}
	
	public void checkTitle(String page, String title) {
		String actualTitle="";
		if(page.equals("privacyPageTitle"))
		{
			actualTitle=privacyPageTitle.getAttribute("contentDescription");
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
