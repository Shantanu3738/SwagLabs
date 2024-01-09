package SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SwagLabs.AbstractObjects.AbstractItems;

public class InformationPage extends AbstractItems {

	WebDriver driver;

	public InformationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[contains(@placeholder,'First Name')]")
	WebElement fname;

	@FindBy(xpath = "//input[contains(@placeholder,'Last Name')]")
	WebElement lname;

	@FindBy(xpath = "//input[contains(@placeholder,'Zip/Postal Code')]")
	WebElement pin;

	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueBtn;

	By elePresent = By.xpath("//div[@class='checkout_info']");

	public ConfirmPage sendInfo(String fisrtName, String lastName, String pinCode) 
	{
		presenceOfElementLocated(elePresent);
		fname.sendKeys(fisrtName);
		lname.sendKeys(lastName);
		pin.sendKeys(pinCode);
		continueBtn.click();
		ConfirmPage confirm = new ConfirmPage(driver);
		return confirm;
	}
}
