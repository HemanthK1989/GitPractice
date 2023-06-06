package framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponents.AbstractComponents;

public class Billing_PageObjects extends AbstractComponents{
	
	WebDriver driver;
	
	public Billing_PageObjects(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="[placeholder='Select Country']")
	WebElement CountryDrpDown;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement Country;
	
	@FindBy(css=".action__submit")
	WebElement submitButton;
	
	By CntryListSuggestions=By.xpath("//section[@class='ta-results list-group ng-star-inserted']");
	
	public OrderConfirmation_PageObjects enterBillingDetails()
	{
		Actions CountryDrpDwn=new Actions(driver);
		CountryDrpDwn.sendKeys(CountryDrpDown,"India").build().perform();
		waitforelementtovisible(CntryListSuggestions);
		clickjs(Country);
		clickjs(submitButton);
		return new OrderConfirmation_PageObjects(driver);
	}
	
}
