package hemanthPractice.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hemanthPractice.AbstractComponents.AbstractComponents;

public class PaymentPageObjects extends AbstractComponents {
	
	
	WebDriver driver;
	
	public PaymentPageObjects(WebDriver driver)
	{	
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement selectCountry;
	@FindBy(css=".ta-item:last-child")
	WebElement lastItem;;
	@FindBy(xpath="//div[@class='actions']/a")
	WebElement placeOrderBtn;
	
	
	By country=By.cssSelector("[placeholder='Select Country']");
	By confirmationMessage=By.cssSelector(".hero-primary");
			
	public void selectCountryDropDown(String countryName)
	{
		waitForElementToLoad(country);
		selectCountry.sendKeys(countryName);
		clickJS(lastItem);
		clickJS(placeOrderBtn);
		waitForElementToLoad(confirmationMessage);	
	}
	
	public String verifyConfMesage()
	{
		String ConfMessage=driver.findElement(confirmationMessage).getText();
		return ConfMessage;
		
	}
	
}
