package SwagLabs.Products;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import SwagLabs.BaseTests.BaseTest;
import SwagLabs.Pages.CartPage;
import SwagLabs.Pages.CataloguePage;
import SwagLabs.Pages.ConfirmPage;
import SwagLabs.Pages.InformationPage;
import SwagLabs.Pages.LoginPage;
import SwagLabs.Pages.OrderPlaced;

public class CompleteTest extends BaseTest{

	@Test
	public void CompleteRun() throws IOException{
		
		//Static items
		String[] items = {"Sauce Labs Backpack","Sauce Labs Bolt T-Shirt"};
		List<String> itemsList = Arrays.asList(items);
		
		//Login using id password
		LoginPage login = goToURL();
		CataloguePage  catalogue = login.login(prop.getProperty("email"),prop.getProperty("password"));
		
		//Catalogue Page and adding item
		CartPage cart =  catalogue.addItems(itemsList);
		
		//Proceeding with cart
		InformationPage info = cart.checkOut();
		
		//Fill Information Page
		ConfirmPage confirm = info.sendInfo(prop.getProperty("firstName"),prop.getProperty("lastName"),prop.getProperty("pinCode"));
		
		//Confirmation Page
		OrderPlaced order = confirm.confirm();
		
		//Order Placed Page
		String confirmMsg = order.orderConfirm();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thank you for your order!"));
		
		//Closing browser
		driver.close();

	}

}
