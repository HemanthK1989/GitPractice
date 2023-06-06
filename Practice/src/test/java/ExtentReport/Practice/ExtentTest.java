package ExtentReport.Practice;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentTest {
	
	ExtentReports extent;
	@BeforeTest
	public void generateReport()
	{
		String report=System.getProperty("user.dir")+"\\report\\"+"index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(report);
		reporter.config().setReportName("Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Hemanth Krishna Rao");
		
	}
	
	@Test
	public void initialDemo()
	{
		
		com.aventstack.extentreports.ExtentTest test1=extent.createTest("Demo Test");
		//System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		ChromeOptions nChromeOptions = new ChromeOptions();
		//nChromeOptions.setExperimentalOption("prefs", prefs);
		nChromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		nChromeOptions.addArguments("--disable-notifications");
		nChromeOptions.addArguments("--enable-allow-sync-xhr-in-page-dismissal");
		nChromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

		WebDriverManager.getInstance(DriverManagerType.CHROME).version("2.42").setup();
		WebDriver driver=new ChromeDriver(nChromeOptions);
		driver.get("https://www.rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.close();
		extent.flush();
	}
	
}
