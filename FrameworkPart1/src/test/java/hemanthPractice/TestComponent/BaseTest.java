package hemanthPractice.TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import hemanthPractice.PageObjects.LandingPageObjects;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPageObjects LP;
	public WebDriver initializeBrowser() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream FIS=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\hemanthPractice\\Resources\\data.properties");
		prop.load(FIS);
		String browserName=System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
		//String browserName=prop.getProperty("browser");
		if(browserName.contains("chrome"))
		{
		ChromeOptions nChromeOptions = new ChromeOptions();
		nChromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		WebDriverManager.getInstance(DriverManagerType.CHROME).version("2.42").setup();
		if(browserName.contains("headless"))
		{
			nChromeOptions.addArguments("headless");
		}
		driver=new ChromeDriver(nChromeOptions);
		driver.manage().window().setSize(new Dimension(1440,900));
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumSoftwares\\geckodriver.exe");
		driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	@BeforeTest(alwaysRun=true)
	public LandingPageObjects launchApplication() throws IOException 
	{
		driver=initializeBrowser();
		LP=new LandingPageObjects(driver);
		return LP;
		
	}
	
	@AfterTest(alwaysRun=true)
	public void tearDown()
	{
		driver.close();
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		//Convert Json to String
		String jsonContent=FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		
		//String to HshMap
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
		return data;
		
	}
	
	public String getScreenShot(String testName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Source=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//"+testName+".png");
		FileUtils.copyFile(Source, file);
		return System.getProperty("user.dir")+"//reports//"+testName+".png";
	}

}
