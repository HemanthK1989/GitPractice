package framework.pageobjects;

import java.util.List;

import org.apache.http.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponents.AbstractComponents;


public class Cart_PageObjects extends AbstractComponents{
	
	WebDriver driver;
	public Cart_PageObjects(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> CartProducts;
	
	@FindBy(xpath="(//button[@class='btn btn-primary'])[3]")
	WebElement checkout;
	
	public Billing_PageObjects CheckoutCart(String ProductName)
	{
		boolean match=CartProducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(ProductName));
		Asserts.check(match, "Product matched successfully");
		
		clickjs(checkout);
		return new Billing_PageObjects(driver);
	}
	

}
