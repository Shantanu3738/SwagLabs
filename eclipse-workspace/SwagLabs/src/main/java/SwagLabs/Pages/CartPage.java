package SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SwagLabs.AbstractObjects.AbstractItems;

public class CartPage extends AbstractItems{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="checkout")
	WebElement checkout;
	
	By elePresent = By.xpath("//button");
	
	public InformationPage checkOut()
	{
		presenceOfAllElementsLocatedBy(elePresent);
		checkout.click();
		InformationPage info = new InformationPage(driver);
		return info;
	}
	
}
