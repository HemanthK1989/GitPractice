package framework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponents.AbstractComponents;

public class Catalog_PageObjects extends AbstractComponents{

	
WebDriver driver;
	
	public Catalog_PageObjects(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> Products;
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartLink;
	
	By productsBy=By.cssSelector(".mb-3");
	By productnames=By.cssSelector("b");
	By addPrd=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	By spinner=By.cssSelector(".ng-animating");
	
	public List<WebElement> getproductsList()
	{
		waitforelementtovisible(productsBy);
		
		return Products;
	}
	
	public WebElement getProductByName(String prdName)
	{
		WebElement prod=getproductsList().stream().filter(product->
		product.findElement(productnames).getText().equalsIgnoreCase(prdName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String prdName)
	{
		WebElement product=getProductByName(prdName);
		product.findElement(addPrd).click();
		
		waitforelementtovisible(toastMessage);
		waitforelementtoinvisible(driver.findElement(spinner));
	}
	
	public Cart_PageObjects clickCartLink()
	{
		cartLink.click();
		return new Cart_PageObjects(driver);
	}
}
