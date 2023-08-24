package hemanthPractice.Tests;


import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Standalone {
	
	public static void main(String[] args) throws InterruptedException
	{	
		ChromeOptions nChromeOptions = new ChromeOptions();
		nChromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		WebDriverManager.getInstance(DriverManagerType.CHROME).version("2.42").setup();
		WebDriver driver=new ChromeDriver(nChromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.rahulshettyacademy.com/client/");
		driver.findElement(By.id("userEmail")).sendKeys("hemanthkrishnarao1989@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Hemanth12$");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4")));
	
		List<WebElement> products=driver.findElements(By.cssSelector(".col-lg-4"));
		WebElement prd=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		prd.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match=cartProducts.stream().anyMatch(cartPrd->cartPrd.getText().equals("ZARA COAT 3"));
		Assert.assertTrue(match);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".totalRow button")));
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.cssSelector(".totalRow button"))).click().build().perform();
		//driver.findElement(By.cssSelector(".totalRow button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='Select Country']")));
		driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("india");
		//act.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"India");
		driver.findElement(By.cssSelector(".ta-item:last-child")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".actions a")));
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@class='actions']/a")));
		//act.moveToElement(driver.findElement(By.xpath("//div[@class='actions']/a"))).click().build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
		String ConfMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
		assertTrue(ConfMessage.equalsIgnoreCase("Thankyou for the order."));
		
		executor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(".fa-sign-out")));
		driver.close();
		
	}

}
