package MobileAutomation.TestUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener {
	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReporterObject();
	
	@Override
	public void onTestStart(ITestResult result) {
		String text=result.getMethod().getMethodName()+" & "+ result.getMethod().getDescription();
		test=extent.createTest(text);
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	@Override
	public void onStart(ITestContext context) {
		
	}
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
