package framework.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.pageobjects.Orders_PageObjects;

public class AbstractComponents {
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement OrdersLink;
	
	public void waitforelementtovisible(By Elementby) {
	WebDriverWait wait=new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(Elementby));
	}
	
	public void waitforelementtovisible(WebElement Element) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(Element));
		}

	
	public void waitforelementtoinvisible(WebElement Element) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOf(Element));
		}
	
	public void clickjs(WebElement Element)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Element);
	}
	
	public Orders_PageObjects gotoOrdersPage()
	{
		OrdersLink.click();
		return new Orders_PageObjects(driver);
	}
}
