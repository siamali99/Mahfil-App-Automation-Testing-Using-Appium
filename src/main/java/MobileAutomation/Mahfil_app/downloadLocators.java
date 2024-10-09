package MobileAutomation.Mahfil_app;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class downloadLocators {
	AndroidDriver driver;
	public downloadLocators(AndroidDriver driver) {
//		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Download page title locators
	@AndroidFindBy(xpath="(//android.view.View)[5]")
	private WebElement downloadPageTitle;
	
	//Empty Download page  locators
	@AndroidFindBy(accessibility="Videos you download will appear here!")
	private WebElement emptyDownloadPageTitle;
	
	//downloaed video locators
	@AndroidFindBy(xpath="(//android.view.View)[8]")
	private WebElement downloadedVideo;
	
	//offline see downloaded video locators
	@AndroidFindBy(accessibility="See Downloaded videos")
	private WebElement seeVideo;
	
	//downloaed video elipsis locators
	@AndroidFindBy(xpath="(//android.widget.ImageView)[2]")
	private WebElement ellipsisButton;
	
	//downloaed video remove button locators
	@AndroidFindBy(xpath="(//android.widget.Button)[1]")
	private WebElement removeButton;
	
	public void playDownloadedVideo() {
		downloadedVideo.click();
	}
	
	public void clickSeeDownloadedVideo() {
		seeVideo.click();
	}
	
	public void clickEllipsis() {
		ellipsisButton.click();
	}
	
	public void clickRemove() throws InterruptedException {
		Thread.sleep(1000);
		removeButton.click();
	}
	public void back() {
		driver.navigate().back();
	}
	public void toggleInternet() throws InterruptedException {
        ((AndroidDriver) driver).toggleWifi();
        Thread.sleep(5000);
	}
	
	public void checkTitle(String page, String title) {
		String actualTitle="";
		if(page.equals("downloadPageTitle"))
		{
			actualTitle=downloadPageTitle.getAttribute("contentDescription");
		}
		else if(page.equals("emptyDownloadPageTitle"))
		{
			actualTitle=emptyDownloadPageTitle.getAttribute("contentDescription");
		}

		System.out.println(actualTitle);
		String expectedTitle=title;
		Assert.assertEquals(actualTitle,expectedTitle,"Title didn't matched");

	}
}
