package MobileAutomation.Mahfil_app;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class settingsLocator {
	AndroidDriver driver;
	public settingsLocator(AndroidDriver driver) {
//		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	//Settings page title locators
	@AndroidFindBy(xpath="(//android.view.View)[6]")
	private WebElement settingsPageTitle;
	//profile settings button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[4]")
	private WebElement profileSettingsButton;

	
	//Notification button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[2]")
	private WebElement notificationButton;
	//Notificatoin page title locators
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
	//Switch button 1 locators
	@AndroidFindBy(xpath="(//android.widget.Switch)[1]")
	private WebElement switchButton1;
	
	//Dark Mode button locators
	@AndroidFindBy(accessibility="Dark Mode")
	private WebElement darkModeButton;
	//Light Mode button locators
	@AndroidFindBy(accessibility="Light Mode")
	private WebElement lightModeButton;
	

	
	@AndroidFindBy(xpath="(//android.widget.ImageView)[3]")
	private WebElement SignupPageTitle;
	
	public void clickNotification() {
		notificationButton.click();
	}
	public void clickSearch() {
		searchButton.click();
	}
	public void clickProfileSettings() {
		profileSettingsButton.click();
	}
	public void clickBackButton() {
		backButton.click();
	}
	
	public void clickSwitch1() {
		switchButton1.click();
	}
	public void clickDarkMode() {
		darkModeButton.click();
	}
	public void clickLightMode() {
		lightModeButton.click();
	}
	
	
	
	public void checkTitle(String page, String title) {
		String actualTitle="";
		if(page.equals("settingsPageTitle"))
		{
			actualTitle=settingsPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("SignupPageTitle"))
		{
			actualTitle=SignupPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("notificationPageTitle"))
		{
			actualTitle=notificationPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("searchPageTitle"))
		{
			actualTitle=searchPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("switchButton1"))
		{
			actualTitle=switchButton1.getAttribute("checked");
		}

		System.out.println(actualTitle);
		String expectedTitle=title;
		Assert.assertEquals(actualTitle,expectedTitle,"Title didn't matched");

	}
}
