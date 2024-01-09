package SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//input[@id='login-button']")
	WebElement login;
	
	public CataloguePage login(String email, String passwrd)
	{
		username.sendKeys(email);
		password.sendKeys(passwrd);
		login.click();
		CataloguePage  catalogue = new CataloguePage(driver);
		return catalogue;
	}

}
