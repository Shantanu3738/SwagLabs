package SwagLabs.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SwagLabs.AbstractObjects.AbstractItems;

public class CataloguePage extends AbstractItems{
	
	WebDriver driver;
	
	public CataloguePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='inventory_item_name ']")
	List<WebElement> catalogueItems;
	
	@FindBy(xpath="//div[@id='shopping_cart_container']")
	WebElement cart;
	
	By elePresent = By.xpath("//div/div[@class='inventory_item_description']");
	
	public CartPage addItems(List<String> items)
	{
		presenceOfElementLocated(elePresent);
		for(int i=0; i<catalogueItems.size(); i++)
		{
			if(items.contains(driver.findElements(By.xpath("//div[@class='inventory_item_name ']")).get(i).getText()))
			{
				driver.findElements(By.xpath("//div[@class='pricebar']/button")).get(i).click();
			}
			
		}
		cart.click();
		
		CartPage cart = new CartPage(driver);
		return cart;
	}

}
