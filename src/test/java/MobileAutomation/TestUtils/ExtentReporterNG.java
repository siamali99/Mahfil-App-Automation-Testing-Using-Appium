package MobileAutomation.TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extent;

	public static ExtentReports getReporterObject() {
		// Setup Extent report configurations
		String path = System.getProperty("user.dir") + "\\reports\\testReport.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("Mahfil Test Report");
		report.config().setDocumentTitle("Test Report");
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Siam");
		return extent;
	}
}
