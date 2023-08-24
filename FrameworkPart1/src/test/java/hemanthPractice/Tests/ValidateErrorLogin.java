package hemanthPractice.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import hemanthPractice.PageObjects.CheckoutPageObjects;
import hemanthPractice.PageObjects.ProductCatalogPageObjects;
import hemanthPractice.TestComponent.BaseTest;
import hemanthPractice.TestComponent.Retry;

public class ValidateErrorLogin extends BaseTest{
	String productName="ZARA COAT 3";
	
	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void loginErrorValidation() throws IOException{
		// TODO Auto-generated method stub
		
		LP.loginToApplication("hemanthkrishnrao1989@gmail.com", "Hemanth12$");
		Assert.assertEquals("Incorrect email or password.", LP.getErrorMessage());
		}
	
	@Test()
	public void productErrorValidation()
	{
		ProductCatalogPageObjects PC=LP.loginToApplication("hemanthkrishnarao1989@gmail.com", "Hemanth12$");
		CheckoutPageObjects CP=PC.addProductToCart(productName);
		Assert.assertFalse(CP.verifyProductInCheckout("ZARA COAT 33"));

	}

}
