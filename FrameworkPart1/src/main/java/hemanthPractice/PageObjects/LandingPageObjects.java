package hemanthPractice.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hemanthPractice.AbstractComponents.AbstractComponents;

public class LandingPageObjects extends AbstractComponents{
	
	
	WebDriver driver;
	
	public LandingPageObjects(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="userEmail")
	WebElement Email;
	
	@FindBy(id="userPassword")
	WebElement Password;
	
	@FindBy(id="login")
	WebElement LoginBtn;
	@FindBy(css=".fa-sign-out")
	WebElement signOut;
	@FindBy(css="[class*='flyInOut']")
	WebElement EmailerrorMessage;
	
	public ProductCatalogPageObjects loginToApplication(String userName,String password)
	{
		driver.get("https://www.rahulshettyacademy.com/client/");
		Email.sendKeys(userName);
		Password.sendKeys(password);
		LoginBtn.click();
		ProductCatalogPageObjects PCP=new ProductCatalogPageObjects(driver);
		return PCP;
	}
	
	public String getErrorMessage()
	{
		waitForElementToLoad(EmailerrorMessage);
		return EmailerrorMessage.getText();
	}
	public void signOut()
	{
		clickJS(signOut);
	}
}
