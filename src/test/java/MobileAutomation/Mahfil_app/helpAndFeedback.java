package MobileAutomation.Mahfil_app;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class helpAndFeedback extends configAppium {
	public menuPageLocators menu;
	public homePageLocators home;
	public helpAndFeedbackLocators feedback;
	public authenticationLocators authentication;

	@BeforeClass
	public void before() throws InterruptedException {
		menu = new menuPageLocators(driver);
		home = new homePageLocators(driver);
		feedback = new helpAndFeedbackLocators(driver);
		authentication = new authenticationLocators(driver);
		Thread.sleep(200);

	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		home.clickMenu();
		menu.Scroll(1);
		menu.clickHelpAndFeedback();
	}

	@BeforeGroups(value = "general")
	public void General() throws InterruptedException {
		home.clickMenu();
		menu.Scroll(2);
		menu.clickSignIn();
		authentication.clickEmailLogin();
		authentication.enterEmail("general.mahfil@gmail.com");
		authentication.clickContinue();
		authentication.enterOTP("0", "1", "1", "0");
		authentication.clickContinue();
		menu.checkTitle("authButton", "Logout");
		menu.back();
	}

	@AfterMethod
	public void home() {
		home.returnHome();
	}

	@Test(priority = 1, description = "Help and feedback Testcase 01: Check Help and feedback button is working", groups = {
			"general" })
	public void feebackButtonCheck() throws InterruptedException {
		feedback.checkTitle("feedbackPageTitle", "Help and Feedback");
	}

	@Test(priority = 2, description = "Help and feedback Testcase 02: Check notification button is working in Help and feedback page", groups = {
			"general" })
	public void notificationButtonCheck() throws InterruptedException {
		feedback.clickNotification();
		feedback.checkTitle("notificationPageTitle", "Notifications");
	}

	@Test(priority = 3, description = "Help and feedback Testcase 03: Check search button is working in Help and feedback page", groups = {
			"general" })
	public void searchButtonCheck() {

		feedback.clickSearch();
		feedback.checkTitle("searchPageTitle", "Popular Search");
	}

	@Test(priority = 4, description = "Help and feedback Testcase 04: Check back button is working from Help and feedback page", groups = {
			"general" })
	public void backButtonCheck() {
		feedback.clickBackButton();
		menu.checkTitle("menuTitle", "Others");
	}

	@Test(priority = 5, description = "Help and feedback Testcase 05: Check question is not sent by keeping all the field empty from Help and feedback page", groups = {
			"general" })
	public void FAQCheck1() {
		feedback.clickSendButton();
		feedback.checkTitle("toastMessage", "Fields are incorrect");
	}

	@Test(priority = 6, description = "Help and feedback Testcase 06: Check question is not sent by giving only spaces in inputs from Help and feedback page", groups = {
			"general" })
	public void FAQCheck2() {
		feedback.enterEmail("     ");
		feedback.Scroll(1);
		feedback.enterName("     ");
		feedback.enterSubject("     ");
		feedback.enterDescription("     ");
		feedback.clickSendButton();
		feedback.checkTitle("toastMessage", "Fields are incorrect");
	}

	@Test(priority = 7, description = "Help and feedback Testcase 07: Check question is not sent by giving invalid email in Help and feedback page", groups = {
			"general" })
	public void FAQCheck3() {
		feedback.enterEmail("siam@com");
		feedback.Scroll(1);
		feedback.enterName("siam");
		feedback.enterSubject("test");
		feedback.enterDescription("Test");
		feedback.clickSendButton();
		feedback.checkTitle("toastMessage", "Fields are incorrect");
	}

	@Test(priority = 8, description = "Help and feedback Testcase 08: Check question is not sent by giving invalid email in Help and feedback page", groups = {
			"general" })
	public void FAQCheck4() {
		feedback.enterEmail("siam.com");
		feedback.Scroll(1);
		feedback.enterName("siam");
		feedback.enterSubject("test");
		feedback.enterDescription("Test");
		feedback.clickSendButton();
		feedback.checkTitle("toastMessage", "Fields are incorrect");
	}

	@Test(priority = 9, description = "Help and feedback Testcase 09: Check question is not sent by giving spaces in name fields in Help and feedback page", groups = {
			"general" })
	public void FAQCheck5() {
		feedback.enterEmail("siam@gmail.com");
		feedback.Scroll(1);
		feedback.enterName("     ");
		feedback.enterSubject("test");
		feedback.enterDescription("Test");
		feedback.clickSendButton();
		feedback.checkTitle("toastMessage", "Fields are incorrect");
	}

	@Test(priority = 10, description = "Help and feedback Testcase 10: Check question is not sent by giving spaces in other fields in Help and feedback page", groups = {
			"general" })
	public void FAQCheck6() {
		feedback.enterEmail("siam@gmail.com");
		feedback.Scroll(1);
		feedback.enterName("siam");
		feedback.enterSubject("   ");
		feedback.enterDescription("    ");
		feedback.clickSendButton();
		feedback.checkTitle("toastMessage", "Fields are incorrect");
	}

	@Test(priority = 11, description = "Help and feedback Testcase 11: Check question is  sent by giving  valid input in Help and feedback page", groups = {
			"general" })
	public void FAQCheck7() {
		feedback.enterEmail("siam@gmail.com");
		feedback.Scroll(1);
		feedback.enterName("siam");
		feedback.enterSubject("test");
		feedback.enterDescription("test");
		feedback.clickSendButton();
		feedback.checkTitle("successMessage", "Report sending successful");
	}

}
