package MobileAutomation.Mahfil_app;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class salatReminderLocators {
	AndroidDriver driver;
	public salatReminderLocators(AndroidDriver driver) {
//		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Salat reminder page title locators
	@AndroidFindBy(xpath="(//android.view.View)[7]")
	private WebElement salatReminderPageTitle;
	
	
	//All Reminder button locators
	@AndroidFindBy(xpath="(//android.widget.Switch)[1]")
	private WebElement reminderButton;
	//All Reminder button locators
	@AndroidFindBy(xpath="(//android.widget.Switch)[2]")
	private WebElement reminderButtonFajr;
	//All Reminder button locators
	@AndroidFindBy(xpath="(//android.widget.Switch)[3]")
	private WebElement reminderButtonDhuhr;
	//All Reminder button locators
	@AndroidFindBy(xpath="(//android.widget.Switch)[4]")
	private WebElement reminderButtonAsr;
	//All Reminder button locators
	@AndroidFindBy(xpath="(//android.widget.Switch)[5]")
	private WebElement reminderButtonMaghrib;
	//All Reminder button locators
	@AndroidFindBy(xpath="(//android.widget.Switch)[6]")
	private WebElement reminderButtonIsha;
	//On time reminder button
	@AndroidFindBy(accessibility="On Time Reminder")
	private WebElement onTimeReminder;

	
	//Back button locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[1]")
	private WebElement backButton;
	//Set reminder title
	@AndroidFindBy(xpath="(//android.view.View)[5]")
	private WebElement reminderTitle;
	
	public void back() {
		driver.navigate().back();
	}
	public void clickBackButton() {
		backButton.click();
	}
	
	public void clickReminder() {
		reminderButton.click();
	}
	public void clickFajr() throws InterruptedException {
		Thread.sleep(1000);
		reminderButtonFajr.click();
	}
	public void clickOnTimeReminder() {
		onTimeReminder.click();
	}
	
	
	public void checkTitle(String page, String title) {
		String actualTitle="";
		if(page.equals("salatReminderPageTitle"))
		{
			actualTitle=salatReminderPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("reminderButton"))
		{
			actualTitle=reminderButton.getAttribute("checked");
		}
		else if(page.equals("reminderButtonFajr"))
		{
			actualTitle=reminderButtonFajr.getAttribute("checked");
		}
		else if(page.equals("reminderButtonDhuhr"))
		{
			actualTitle=reminderButtonDhuhr.getAttribute("checked");
		}
		else if(page.equals("reminderButtonAsr"))
		{
			actualTitle=reminderButtonAsr.getAttribute("checked");
		}
		else if(page.equals("reminderButtonMaghrib"))
		{
			actualTitle=reminderButtonMaghrib.getAttribute("checked");
		}
		else if(page.equals("reminderButtonIsha"))
		{
			actualTitle=reminderButtonIsha.getAttribute("checked");
		}
		else if(page.equals("reminderTitle"))
		{
			actualTitle=reminderTitle.getAttribute("checked");
		}


		System.out.println(actualTitle);
		String expectedTitle=title;
		Assert.assertEquals(actualTitle,expectedTitle,"Title didn't matched");

	}
	
}
