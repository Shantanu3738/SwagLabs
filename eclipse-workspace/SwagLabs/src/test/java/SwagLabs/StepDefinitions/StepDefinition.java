package SwagLabs.StepDefinitions;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import SwagLabs.BaseTests.BaseTest;
import SwagLabs.Pages.CartPage;
import SwagLabs.Pages.CataloguePage;
import SwagLabs.Pages.ConfirmPage;
import SwagLabs.Pages.InformationPage;
import SwagLabs.Pages.LoginPage;
import SwagLabs.Pages.OrderPlaced;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseTest{
	
	public LoginPage login;
	CataloguePage  catalogue;
	CartPage cart;
	InformationPage info;
	ConfirmPage confirm ;
	OrderPlaced order;
	
	@Given("I access the URL")
	public void I_access_the_URL() throws IOException
	{
		login = goToURL();
	}
	
	@Given("^I login using username (.+) and password (.+)$")
	public void I_login_using_username_and_password(String userName, String password)
	{
		catalogue = login.login(userName , password);
	}
	
	@When("I add items to cart")
	public void I_add_items_to_cart()
	{
		String[] items = {"Sauce Labs Backpack","Sauce Labs Bolt T-Shirt"};
		List<String> itemsList = Arrays.asList(items);
		cart =  catalogue.addItems(itemsList);
	}
	
	@And("I proceed with checkout")
	public void I_proceed_to_checkout()
	{
		info = cart.checkOut();
	}
	
	@And("^I fill information page with (.+) , (.+) and (.+)$")
	public void fill_up_information(String fname, String lname, String pincode)
	{
		confirm = info.sendInfo(fname, lname, pincode);
	}
	
	@And("Confirm the order added")
	public void confirm_the_order()
	{
		order = confirm.confirm();
	}
	
	@Then("{string} is displayed")
	public void confirmation_msg(String string)
	{
		String confirmMsg = order.orderConfirm();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase(string));
		driver.close();
	}

}
