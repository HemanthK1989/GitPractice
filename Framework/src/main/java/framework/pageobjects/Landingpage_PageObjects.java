package framework.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponents.AbstractComponents;

public class Landingpage_PageObjects extends AbstractComponents {
	
	WebDriver driver;
	
	public Landingpage_PageObjects(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement Email=driver.findElement(By.xpath("//input[@id='userEmail']"));
	
	@FindBy(id="userEmail")
	WebElement UserEmail;
	
	@FindBy(id="userPassword")
	WebElement Password;
	
	@FindBy(id="login")
	WebElement Submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorValidation;
	
	public Catalog_PageObjects LogintoApplication(String Email,String password)
	{
		UserEmail.sendKeys(Email);
		Password.sendKeys(password);
		Submit.click();
		return new Catalog_PageObjects(driver);
			}
	public void gettoURL(String URL)
	{
		driver.get(URL);
	}
	
	public String  geterroremessage()
	{
		waitforelementtovisible(errorValidation);
		return errorValidation.getText();
	}
		
}
