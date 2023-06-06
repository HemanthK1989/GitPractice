package framework.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	public static ExtentReports getExtentreport()
	{
		String path=System.getProperty("user.dir")+"\\reports\\"+"index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		
		return extent;
		
		
	}

}
