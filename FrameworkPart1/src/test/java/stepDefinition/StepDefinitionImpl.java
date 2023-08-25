package stepDefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;

import hemanthPractice.PageObjects.CheckoutPageObjects;
import hemanthPractice.PageObjects.LandingPageObjects;
import hemanthPractice.PageObjects.OrdersPageObjects;
import hemanthPractice.PageObjects.PaymentPageObjects;
import hemanthPractice.PageObjects.ProductCatalogPageObjects;
import hemanthPractice.TestComponent.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest{
	LandingPageObjects LP;
	ProductCatalogPageObjects PC;
	CheckoutPageObjects CP;
	PaymentPageObjects PP;
	OrdersPageObjects orp;
	String countryName="india";
	String successmessage;
	@Given("I landed on Ecommerce Login Page")
	public void I_landed_on_Ecommerce_Login_Page() throws IOException {
		
		LP=launchApplication();
	}
	
	@Given("^I Logged in with username (.+) and password (.+)$")
	public void I_Logged_in_with_username_and_password (String username,String password)
	{
		PC=LP.loginToApplication(username, password);
		
	}
	@When("^I add product (.+) to Cart$")
	public void I_add_Product_to_Cart(String productName) throws InterruptedException
	{
		CP=PC.addProductToCart(productName);
	}
	
	@When("^Checkout (.+) and Submit the Order$")
	public void Checkout_product_and_Submit_the_Order(String productName)
	{
		Assert.assertTrue(CP.verifyProductInCheckout(productName));
		PP=CP.clickCheckout();
		PP.selectCountryDropDown(countryName);
	}
	
	@Then("I verify the Confirmation Message {string} on Confirmation Page")
	public void verify_the_Confirmation_Message_on_Confirmation_Page(String string)
	{
		String ConfMessage=PP.verifyConfMesage();
		assertTrue(ConfMessage.equalsIgnoreCase(string));
		LP.signOut();	
		driver.close();
	}
	
	@Then("{string} message should display")
	public void Validation_message_should_display(String string)
	{
		Assert.assertEquals(string, LP.getErrorMessage());
		driver.close();
	}
	@When("I Go to Orders Page")
	public void Go_To_OrdersPage()
	{
		orp=LP.goToOrdersPage();
	}
	@And("Click on Delete button for the Order")
	public void ClickonDeleteButton()
	{
	successmessage=orp.deleteOrder();	
	}
	@Then("^I verify the Success Message (.+) in Orders Page$")
	public void verify_the_Success_Message_in_Orders_Page(String Message)
	{
		Assert.assertEquals(successmessage, Message);
		driver.close();
	}
}
