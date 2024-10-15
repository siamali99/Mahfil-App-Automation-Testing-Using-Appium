package MobileAutomation.Mahfil_app;

import org.testng.annotations.BeforeMethod;

public class beforeGroupActions extends configAppium{
	public menuPageLocators menu;
	public homePageLocators home;
	public authenticationLocators authentication;
	 public beforeGroupActions() throws InterruptedException {

		 menu=new menuPageLocators(driver);
		 home=new homePageLocators(driver);
		 authentication=new authenticationLocators(driver);
		 Thread.sleep(200);
		 home.clickMenu();
		 menu.Scroll(2);
	 }
	 
	 public void guestUser() throws InterruptedException {
		 home.clickMenu();
		 menu.Scroll(2);
		 menu.clickLogout();
	 }
	 
	 public void generalUser() throws InterruptedException {
			menu.clickSignIn();
			authentication.clickEmailLogin();
			authentication.enterEmail("general.mahfil@gmail.com");
			authentication.clickContinue();
			authentication.enterOTP("0", "1", "1", "0");
			authentication.clickContinue();
			menu.checkTitle("authButton", "Logout");
	 }
	 
	 public void premiumUser() throws InterruptedException {
			menu.clickSignIn();
			authentication.clickEmailLogin();
			authentication.enterEmail("premium.mahfil@gmail.com");
			authentication.clickContinue();
			authentication.enterOTP("0", "1", "1", "0");
			authentication.clickContinue();
			menu.checkTitle("authButton", "Logout");
	 }
}
