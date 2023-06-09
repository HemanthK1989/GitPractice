package HemanthAcademy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import framework.resources.ExtentReportNG;

public class Listeners extends BaseTest implements ITestListener
{
	ExtentReports Extent=ExtentReportNG.getExtentreport();
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result)
	{
		test=Extent.createTest(result.getMethod().getMethodName());
	}
	@Override
	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS, "Test Passed");
	}
	@Override
	public void onTestSkipped(ITestResult result)
	{
		
	}
	@Override
	public void onTestFailure(ITestResult result)
	{
		test.fail(result.getThrowable());
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String filepath=null;
		try {
			filepath=getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}
	@Override
	public void onStart(ITestContext context)
	{
		
	}
	
	@Override
	public void onFinish(ITestContext context)
	{
		Extent.flush();
	}
}
