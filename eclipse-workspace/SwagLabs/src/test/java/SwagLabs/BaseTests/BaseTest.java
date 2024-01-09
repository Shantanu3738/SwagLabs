package SwagLabs.BaseTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SwagLabs.Pages.LoginPage;

public class BaseTest {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public Actions act;
	public static Properties prop;
	ChromeOptions option = new ChromeOptions();
	
	public WebDriver initializeDriver() throws IOException
	{
		driver = new ChromeDriver();
		option = new ChromeOptions();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions act = new Actions(driver);
		driver.manage().window().maximize();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\SwagLabs\\AbstractObjects\\StaticData.properties");
		prop = new Properties();
		prop.load(fis);
		
		return driver;
	}
	
	public LoginPage goToURL() throws IOException
	{
		driver = initializeDriver();
		driver.get("https://www.saucedemo.com/");
		LoginPage login = new LoginPage(driver);
		return login;
	}
	
	public void takeScreenshot(WebDriver driver1, String Testcase) throws IOException
	{
		TakesScreenshot sc= (TakesScreenshot)driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"\\reports\\"+Testcase+".jpg");
		FileUtils.copyFile(src, dest);
	}

}
