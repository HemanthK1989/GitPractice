package hemanthPractice.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hemanthPractice.PageObjects.OrdersPageObjects;

public class AbstractComponents {
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartLink;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement ordersLink;
	
	public void goToCartPage()
	{
		cartLink.click();
	}
	
	public OrdersPageObjects goToOrdersPage()
	{
		ordersLink.click();
		OrdersPageObjects ordersPage=new OrdersPageObjects(driver);
		return ordersPage;
	}

	public void waitForElementToLoad(By FindBy)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}
	
	public void waitForElementToLoad(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToInvisible(WebElement Ele)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	}
	
	public void waitForElementToInvisibleCSS(WebElement Ele)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOf(Ele));
	}
	
	//*[text()='Order Deleted Successfully')]
	
	
	public void clickButtonAction(WebDriver driver,By FindBy)
	{
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(FindBy)).build().perform();
		driver.findElement(FindBy).click();
	}
	
	public void clickJS(WebElement Element)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Element);
	}

}
