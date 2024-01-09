package SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SwagLabs.AbstractObjects.AbstractItems;

public class ConfirmPage extends AbstractItems{
	
	WebDriver driver;

	public ConfirmPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@id='finish']")
	WebElement finishBtn;
	
	By elePresent = By.xpath("//button[@id='finish']");
	
	public OrderPlaced confirm()
	{
		presenceOfElementLocated(elePresent);
		finishBtn.click();
		OrderPlaced order = new OrderPlaced(driver);
		return order;
	}
	
//	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='finish']")));
//	driver.findElement(By.xpath("//button[@id='finish']")).click();

}
