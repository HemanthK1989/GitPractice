package framework.pageobjects;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponents.AbstractComponents;


public class OrderConfirmation_PageObjects extends AbstractComponents{
	
	WebDriver driver;
	
	public OrderConfirmation_PageObjects(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement OrderConfirmMessage;
	
	public void verifyConfirmationMessage(String ActConfmsg)
	{
		waitforelementtovisible(By.cssSelector(".hero-primary"));
		String confmsg=OrderConfirmMessage.getText();
		Asserts.check(confmsg.equalsIgnoreCase(ActConfmsg), "Confirmation message is confirmed successfully");
		
	}
}
