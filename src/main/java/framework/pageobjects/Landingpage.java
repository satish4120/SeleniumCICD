package framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponents.AbstractComponent;

public class Landingpage extends AbstractComponent {
	
	WebDriver driver;
	
	public Landingpage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//WebElement useremail = driver.findElement(By.id("userEmail"));   //we can write same step using PageFactory
	
	@FindBy(id="userEmail")
	WebElement useremail;
	

	@FindBy(id="userPassword")
	WebElement userpassword;
	
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errormssg;
	
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	public ProductCatalogue LoginApplication(String email, String password) {
		useremail.sendKeys(email);
		userpassword.sendKeys(password);
		submit.click();
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		return productcatalogue;
		
	}
	
	
	
	public String getErrorMessage() {
		
		waitForWebElementToAppear(errormssg);
		return errormssg.getText();
		
	}
	
}
	
	
	
	
	
	

