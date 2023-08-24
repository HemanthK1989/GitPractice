package hemanthPractice.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hemanthPractice.AbstractComponents.AbstractComponents;

public class OrdersPageObjects extends AbstractComponents {
	
	
	WebDriver driver;
	
	public OrdersPageObjects(WebDriver driver)
	{	
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> prdNames;
	
	@FindBy(xpath="//h1[text()='Your Orders']")
	WebElement yourOrdersText;
	
	
	public boolean validateOrder(String productName)
	{
		goToOrdersPage();
		waitForElementToLoad(yourOrdersText);
		Boolean match=prdNames.stream().anyMatch(ordPrd->ordPrd.getText().equalsIgnoreCase(productName));
		return match;
	}
}
