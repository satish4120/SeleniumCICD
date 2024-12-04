package Selenium;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class maintest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String item = "IPHONE 13 PRO";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("anthony@mark.com");
		driver.findElement(By.id("userPassword")).sendKeys("Satk@bro5");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> items = driver.findElements(By.cssSelector(".mb-3"));
	
		//Using for loop - 
	/*	for(WebElement e : items)
		{
			if(e.findElement(By.xpath(".//b")).getText().contains(item))
			{
				
				e.findElement(By.xpath(".//button[@class='btn w-10 rounded']")).click();
				break;
			}
	
		}  */
		
		//Using Streams
		WebElement product = items.stream().filter(s->s.findElement(By.cssSelector("b")).getText().contains(item)).findFirst().orElse(null);
		product.findElement(By.cssSelector("button[class='btn w-10 rounded']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		Thread.sleep(3000);
		
		
	/*	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-spinner-overlay")));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[routerlink*='cart']"))).click();  */

		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		List<WebElement> cartitems = driver.findElements(By.cssSelector("div[class='cartSection'] h3"));
		Boolean flag = cartitems.stream().anyMatch(s->s.getText().contains(item));
		Assert.assertTrue(flag);
		driver.findElement(By.xpath("//li[@class='totalRow'] //button[@class='btn btn-primary']")).click();
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("india");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='ta-results list-group ng-star-inserted']")));
		driver.findElement(By.xpath("//section[@class='ta-results list-group ng-star-inserted']/button[2]")).click();
		driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
		
		String confirmmsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
		
	}
}
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


