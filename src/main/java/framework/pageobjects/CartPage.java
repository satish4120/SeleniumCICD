package framework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;
	
	@FindBy(css="div[class='cartSection'] h3")
	List<WebElement> productTitles;
	
	@FindBy(xpath="//li[@class='totalRow'] //button[@class='btn btn-primary']")
	WebElement checkoutbttn;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
		
	public Boolean verifyProductDisplay(String productName) {
			
		Boolean flag = productTitles.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
		return flag;
		}
	
	public CheckOutPage Checkout() {
		checkoutbttn.click();
		CheckOutPage checkoutpage = new CheckOutPage(driver);
		return checkoutpage;
		
		
	}
		
		
	}

