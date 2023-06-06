package framework.pageobjects;

import java.util.List;

import org.apache.http.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponents.AbstractComponents;


public class Orders_PageObjects extends AbstractComponents{
	
	WebDriver driver;
	public Orders_PageObjects(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> OrdersList;
	
	public boolean VerifyOrders(String ProductName)
	{
		boolean match=OrdersList.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(ProductName));
		System.out.println(match);
		return match;
	}
	

}
