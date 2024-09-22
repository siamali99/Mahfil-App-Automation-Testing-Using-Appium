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

	//premium pop up identifier
	@AndroidFindBy(xpath="(//android.widget.Button)")
	private WebElement premiumPopUpTitle;
	//Premium pop up close button
	@AndroidFindBy(xpath="(//android.widget.ImageView)[2]")
	private WebElement premiumClose;
	//Menu page title locators
	@AndroidFindBy(xpath="(//android.view.View)[6]")
	private WebElement menuTitle;
	
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
	public void closePremiumPopUp() {
		premiumClose.click();
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

		System.out.println(actualTitle);
		String expectedTitle=title;
		Assert.assertEquals(actualTitle,expectedTitle,"Title didn't matched");

	}
}
