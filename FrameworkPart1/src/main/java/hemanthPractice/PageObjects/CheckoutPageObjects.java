package hemanthPractice.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hemanthPractice.AbstractComponents.AbstractComponents;

public class CheckoutPageObjects extends AbstractComponents {
	
	
	WebDriver driver;
	
	public CheckoutPageObjects(WebDriver driver)
	{	
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkOut;
	
	By checkoutButton=By.cssSelector(".totalRow button");
	
	
	public List<WebElement> getProductsInCheckout()
	{
		
		return cartProducts;
	}
	
	public Boolean verifyProductInCheckout(String productName)
	{
	Boolean match=getProductsInCheckout().stream().anyMatch(cartPrd->cartPrd.getText().equals(productName));
	waitForElementToLoad(checkoutButton);
	return match;
	}
	
	public PaymentPageObjects clickCheckout()
	{
		clickJS(checkOut);
		PaymentPageObjects PP=new PaymentPageObjects(driver);
		return PP;
	}
}
