package framework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//	List<WebElement> items = driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement> items;
	
	By products = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector("button[class='btn w-10 rounded']");
	By toastMssg = By.cssSelector("#toast-container");
	
	@FindBy(css=".ng-animating")
	WebElement spinner;   //better to not use spinner and go with thread.sleep
	

	
	public List<WebElement> getProductList() {
		
		waitForElementToAppear(products);
		return items;
		
	}
	

	public WebElement getProductByName(String ProductName) {
		
		WebElement product = getProductList().stream().filter(s->s.findElement(By.cssSelector("b")).getText().contains(ProductName)).findFirst().orElse(null);
		return product;
		
	}
	
	
	public void addProductToCart(String ProductName) throws InterruptedException {
		
		WebElement item = getProductByName(ProductName);
		item.findElement(addToCart).click();
		waitForElementToAppear(toastMssg);
		waitForElementToDisappear();
		
	}
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	

