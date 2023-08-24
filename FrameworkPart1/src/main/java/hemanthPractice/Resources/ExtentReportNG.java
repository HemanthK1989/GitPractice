package hemanthPractice.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	public static ExtentReports generateReport()
	{
		ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//reports//index.html"); 
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name", "Hemanth Kedari");
		return extent;

	}

}
