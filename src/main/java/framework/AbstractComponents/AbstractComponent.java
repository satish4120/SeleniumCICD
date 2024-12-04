package framework.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.pageobjects.CartPage;

public class AbstractComponent {

	WebDriver driver;
	
	
	
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartbutton;
	
	@FindBy(css="button[routerlink='/dashboard/myorders']")
	WebElement ordersbutton;
	
	
	public void waitForElementToAppear(By ByFind) 
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ByFind));
	}
	
	public void waitForWebElementToAppear(WebElement e) 
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	

	public void	 waitForElementToDisappear() throws InterruptedException
	{
		Thread.sleep(3000);
	/*	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(e));   */
	}
	
	public CartPage goToCartPage() {
		cartbutton.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
		
	}
	
	public OrdersPage goToOrdersPage() {
		ordersbutton.click();
		OrdersPage orderspage = new OrdersPage(driver);
		return orderspage;
		
		
	}
	
}
