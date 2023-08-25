package hemanthPractice.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hemanthPractice.AbstractComponents.AbstractComponents;

public class ProductCatalogPageObjects extends AbstractComponents {
	
	
	WebDriver driver;
	
	public ProductCatalogPageObjects(WebDriver driver)
	{	
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".col-lg-4")
	List<WebElement> prods;
	
	@FindBy(css=".ng-animating")
	WebElement loadingScreen;
	
	
	
	By products =By.cssSelector(".col-lg-4");
	By addTocart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");

	
	
	public List<WebElement> getProducts()
	{
		waitForElementToLoad(products);	
		return prods;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prd=getProducts().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prd;
	}
	
	public CheckoutPageObjects addProductToCart(String productName) throws InterruptedException
	{
		WebElement prd=getProductByName(productName);
		prd.findElement(addTocart).click();
		waitForElementToLoad(toastMessage);
		waitForElementToInvisible(loadingScreen);
		goToCartPage();
		CheckoutPageObjects CP=new CheckoutPageObjects(driver);
		return CP;
	}
	

}
