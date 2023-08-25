package hemanthPractice.Tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hemanthPractice.PageObjects.CheckoutPageObjects;
import hemanthPractice.PageObjects.OrdersPageObjects;
import hemanthPractice.PageObjects.PaymentPageObjects;
import hemanthPractice.PageObjects.ProductCatalogPageObjects;
import hemanthPractice.TestComponent.BaseTest;

public class SubmitOrder extends BaseTest{
	String productName="ZARA COAT 3";
	String countryName="india";
	
	@Test(dataProvider="getData",groups="Purchase")
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException{
		// TODO Auto-generated method stub
		ProductCatalogPageObjects PC=LP.loginToApplication(input.get("email"), input.get("password"));
		CheckoutPageObjects CP=PC.addProductToCart(input.get("productname"));
		Assert.assertTrue(CP.verifyProductInCheckout(input.get("productname")));
		PaymentPageObjects PP=CP.clickCheckout();
		PP.selectCountryDropDown(countryName);
		String ConfMessage=PP.verifyConfMesage();
		assertTrue(ConfMessage.equalsIgnoreCase("Thankyou for the order."));
		LP.signOut();
	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void verifyOrder()
	{
		LP.loginToApplication("hemanthkrishnarao1989@gmail.com", "Hemanth12$");
		OrdersPageObjects orp=LP.goToOrdersPage();
		Assert.assertTrue(orp.validateOrder(productName));
	}
	
	
	
	//Data Provider with Json File
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\hemanthPractice\\data\\products.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}
	
	
	
	
	/* Data provider method 
	 * @DataProvider public Object[][] getData() { return new Object[][]
	 * {{"hemanthkrishnarao1989@gmail.com","Hemanth12$","ZARA COAT 3"},{
	 * "hemanthkrishnarao1989@yopmail.com","Hemanth12$","ADIDAS ORIGINAL"}}; }
	 */
	
	
	

	//DataProvider method with Hashmap
	/*
	 * @DataProvider public Object[][] getData() { HashMap<String,String> map=new
	 * HashMap<String,String>(); map.put("email",
	 * "hemanthkrishnarao1989@gmail.com"); map.put("password", "Hemanth12$");
	 * map.put("productname", "ZARA COAT 3"); HashMap<String,String> map1=new
	 * HashMap<String,String>(); map1.put("email",
	 * "hemanthkrishnarao1989@yopmail.com"); map1.put("password", "Hemanth12$");
	 * map1.put("productname", "ADIDAS ORIGINAL"); return new Object[][]
	 * {{map},{map1}}; }
	 */

}
