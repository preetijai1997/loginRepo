package test;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;

public class FireFox extends Base {
	
public WebDriver driver;
	
	@Test(dataProvider="getData")
	public void loginTwo(String username, String password)
	{
	   driver.get("https://portal.bankit.in:9090/RO/");
	  System.out.println(driver.getTitle()+ "from firefox");
driver.switchTo().frame("Main");
	  
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
	  driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@id=\"login\"]")).click();
	}
	
	@BeforeMethod
	public void setUp() throws MalformedURLException
	{
		driver=initializeBrowser("firefox");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
