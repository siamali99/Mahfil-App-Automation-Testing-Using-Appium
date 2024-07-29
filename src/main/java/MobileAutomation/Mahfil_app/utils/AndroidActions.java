package MobileAutomation.Mahfil_app.utils;

import org.openqa.selenium.JavascriptExecutor;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;

public class AndroidActions {
	
	AndroidDriver driver;
	
	
	public AndroidActions(AndroidDriver driver2) {
		// TODO Auto-generated constructor stub
	}

	public void scrolltest() {
		boolean scroll=(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width",100,"height",1000,"direction","down","percent",2.0));
	}
}
