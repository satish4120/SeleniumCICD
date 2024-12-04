package framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
	
	WebDriver driver;
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement country;

	@FindBy(xpath = "//section[@class='ta-results list-group ng-star-inserted']/button[2]")
	WebElement selectcountry;
	
	@FindBy(css = ".btnn.action__submit.ng-star-inserted")
	WebElement submit;
	
	By countrylist = By.xpath("//section[@class='ta-results list-group ng-star-inserted']");

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void selectCountry( ) {
		country.sendKeys("india");
		waitForElementToAppear(countrylist);
		selectcountry.click();

		
	}
	
	
	public ConfirmationPage submitOrder() {
		submit.click();
		ConfirmationPage confirmationpage = new ConfirmationPage(driver);
		return confirmationpage;
	}
	

}
