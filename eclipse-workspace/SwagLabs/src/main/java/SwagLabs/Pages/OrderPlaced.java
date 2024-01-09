package SwagLabs.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import SwagLabs.AbstractObjects.AbstractItems;

public class OrderPlaced extends AbstractItems{
	
	WebDriver driver;

	public OrderPlaced(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2")
	WebElement header;
	
	By elePresent = By.xpath("//h2");
	
	public String orderConfirm()
	{
		presenceOfElementLocated(elePresent);
		String msg = header.getText();
		return msg;
	}
	
//	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2")));
//	String confirmMsg = driver.findElement(By.xpath("//h2")).getText();
//	Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thank you for your order!"));

}
