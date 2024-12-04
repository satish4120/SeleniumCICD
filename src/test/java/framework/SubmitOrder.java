package framework;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import framework.AbstractComponents.OrdersPage;
import framework.TestComponents.BaseTest;
import framework.pageobjects.CartPage;
import framework.pageobjects.CheckOutPage;
import framework.pageobjects.ConfirmationPage;
import framework.pageobjects.Landingpage;
import framework.pageobjects.ProductCatalogue;

public class SubmitOrder extends BaseTest {
	
	String ProductName = "IPHONE 13 PRO";

		@Test(dataProvider = "getData", groups = {"purchaseorder"})
		public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		
		ProductCatalogue productcatalogue = landingpage.LoginApplication(input.get("email"), input.get("password"));
		List<WebElement> items = productcatalogue.getProductList();
		productcatalogue.addProductToCart(input.get("product"));
		CartPage cartpage = productcatalogue.goToCartPage();
		Boolean flag = cartpage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(flag);
		CheckOutPage checkoutpage = cartpage.Checkout();
		checkoutpage.selectCountry();
		ConfirmationPage confirmationpage = checkoutpage.submitOrder();
		String finalmssg = confirmationpage.getConfirmationMessage();
		Assert.assertTrue(finalmssg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));	
		
	}

		
		@Test(dependsOnMethods= {"submitOrder"})
		public void orderHistoryTest() {
		ProductCatalogue productcatalogue = landingpage.LoginApplication("karan@arjun.com", "Satk@bro5");
		OrdersPage orderspage = productcatalogue.goToOrdersPage();
		Assert.assertTrue(orderspage.VerifyOrderDisplay(ProductName));
			
		}
		
		
	
		
		
		
		@DataProvider
		public Object[][]  getData() throws IOException {
		/*	HashMap<String,String> map1 = new HashMap<String,String>();
			map1.put("email","karan@arjun.com");
			map1.put("password","Satk@bro5");
			map1.put("product","IPHONE 13 PRO");
			
			HashMap<String,String> map2 = new HashMap<String,String>();
			map2.put("email","anthony@mark.com");
			map2.put("password","Satk@bro5");
			map2.put("product","ZARA COAT 3");  */
			
			List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//framework//data//PurchaseOrder.json");
			return new Object[][]  {{data.get(0)},{data.get(1)}};
			
		}
		
		
		
		
}
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


