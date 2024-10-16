package MobileAutomation.Mahfil_app;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class salatReminder extends configAppium {
	public menuPageLocators menu;
	public homePageLocators home;
	public videoPlayerLocator videoPlayer;
	public salatReminderLocators salatReminder;

	@BeforeMethod
	public void before() throws InterruptedException {

		menu = new menuPageLocators(driver);
		home = new homePageLocators(driver);
		salatReminder = new salatReminderLocators(driver);
		Thread.sleep(200);
	}

	@AfterMethod
	public void home() {
		home.returnHome();
	}

	@Test(priority = 1, description = "Salat Reminder Testcase 01: Check Salat Reminder button is working", groups = {
			"general", "premium" })
	public void salatReminderButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSalatReminder();
		salatReminder.checkTitle("salatReminderPageTitle", "Salat Time");
	}

	@Test(priority = 2, description = "Salat Reminder Testcase 02: Check back button is working from Salat Reminder page", groups = {
			"general", "premium" })
	public void backButtonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSalatReminder();
		salatReminder.clickBackButton();
		menu.checkTitle("menuTitle", "Others");

	}

	@Test(priority = 3, description = "Salat Reminder Testcase 03: Check reminder switch button turns off in Salat Reminder page", groups = {
			"general", "premium" })
	public void reminderSwitchbuttonCheck() throws InterruptedException {
		home.clickMenu();
		menu.clickSalatReminder();
		salatReminder.clickReminder();
		salatReminder.checkTitle("reminderButton", "false");

	}

	@Test(priority = 4, description = "Salat Reminder Testcase 04: Check turning off reminder switch button turns off all other salat switches in Salat Reminder page", groups = {
			"general", "premium" })
	public void reminderSwitchbuttoncheck2() throws InterruptedException {
		home.clickMenu();
		menu.clickSalatReminder();
		salatReminder.checkTitle("reminderButtonFajr", "false");
		salatReminder.checkTitle("reminderButtonDhuhr", "false");
		salatReminder.checkTitle("reminderButtonAsr", "false");
		salatReminder.checkTitle("reminderButtonMaghrib", "false");
		salatReminder.checkTitle("reminderButtonIsha", "false");

	}

	@Test(priority = 5, description = "Salat Reminder Testcase 05: Check turning on reminder switch button  turns on all other salat switches in Salat Reminder page", groups = {
			"general", "premium" })
	public void reminderSwitchbuttoncheck3() throws InterruptedException {
		home.clickMenu();
		menu.clickSalatReminder();
		salatReminder.clickReminder();
		salatReminder.checkTitle("reminderButton", "true");
		salatReminder.checkTitle("reminderButtonFajr", "true");
		salatReminder.checkTitle("reminderButtonDhuhr", "true");
		salatReminder.checkTitle("reminderButtonAsr", "true");
		salatReminder.checkTitle("reminderButtonMaghrib", "true");
		salatReminder.checkTitle("reminderButtonIsha", "true");
	}

	@Test(priority = 6, description = "Salat Reminder Testcase 06: Check turning on reminder shows set reminder pop up and on time reminder button is working", groups = {
			"general", "premium" })
	public void reminderSwitchbuttoncheck4() throws InterruptedException {
		home.clickMenu();
		menu.clickSalatReminder();
		salatReminder.clickFajr();
		Thread.sleep(500);
		salatReminder.clickFajr();
		driver.findElement(By.xpath("(//android.widget.Switch)[2]")).click();
		driver.findElement(By.xpath("(//android.widget.Switch)[2]")).click();
		salatReminder.checkTitle("reminderTitle", "Set Reminder");
		salatReminder.clickOnTimeReminder();
	}


}
