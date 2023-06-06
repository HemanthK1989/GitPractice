package HemanthAcademy;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import framework.pageobjects.Billing_PageObjects;
import framework.pageobjects.Cart_PageObjects;
import framework.pageobjects.Catalog_PageObjects;
import framework.pageobjects.OrderConfirmation_PageObjects;

public class ErrorValidation extends BaseTest{

	@Test(retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException
	{
		// TODO Auto-generated method stub
		
		Catalog_PageObjects CP=LP.LogintoApplication("hemanthkrisharao1989@gmail.com", "Hemanth12$");	
		AssertJUnit.assertEquals("Incorrect email or password.", LP.geterroremessage());
		
	}
	
	@Test(groups={"Error Validation"})
	public void ProductValidation() throws IOException
	{
		// TODO Auto-generated method stub
		
		String ProductName="ADIDAS ORIGINAL";
		Catalog_PageObjects CP=LP.LogintoApplication("hemanthkrishnarao1989@gmail.com", "Hemanth12$");
		List<WebElement> products=CP.getproductsList();
		CP.addProductToCart("ADIDAS ORIGINAL");
		Cart_PageObjects cartpage=CP.clickCartLink();
		Billing_PageObjects BPO=cartpage.CheckoutCart("ADIDAS ORIGINAL");
		System.out.println(ProductName);

		
	}
	
	
}
