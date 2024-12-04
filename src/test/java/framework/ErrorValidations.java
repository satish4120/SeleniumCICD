package framework;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import framework.TestComponents.BaseTest;
import framework.pageobjects.CartPage;
import framework.pageobjects.ProductCatalogue;
import framework.TestComponents.Retry;


public class ErrorValidations extends BaseTest {

	@Test(groups = { "ErrorHandling" }, retryAnalyzer = Retry.class) 
	public void LoginErrorValidation() throws IOException, InterruptedException {

		String ProductName = "IPHONE 13 PRO";
		landingpage.LoginApplication("antony@mark.com", "Satk@bro");
		Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());

	}

	@Test
	public void ProductErrorValidation() throws InterruptedException {
		String ProductName = "IPHONE 13 PRO";
		ProductCatalogue productcatalogue = landingpage.LoginApplication("anthony@mark.com", "Satk@bro5");
		List<WebElement> items = productcatalogue.getProductList();
		productcatalogue.addProductToCart(ProductName);
		CartPage cartpage = productcatalogue.goToCartPage();
		Boolean flag = cartpage.verifyProductDisplay("Iphone 15 pro");
		Assert.assertFalse(flag);

	}

}
