package framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {
	
	WebDriver driver;
	
	@FindBy(css=".hero-primary")
	WebElement confirmationmssg;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public String getConfirmationMessage() {
		return confirmationmssg.getText();
	}
	

}
