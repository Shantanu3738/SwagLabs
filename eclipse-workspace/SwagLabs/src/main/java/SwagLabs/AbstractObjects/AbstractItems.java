package SwagLabs.AbstractObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractItems {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public AbstractItems(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void presenceOfElementLocated(By findBy)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(findBy));
	}
	
	public void presenceOfAllElementsLocatedBy(By findBy)
	{
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(findBy));
	}

}
