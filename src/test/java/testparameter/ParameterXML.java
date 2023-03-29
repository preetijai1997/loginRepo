package testparameter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Base;

public class ParameterXML extends Base {
	
	public WebDriver driver;
	
	public DesiredCapabilities desired= new DesiredCapabilities();
	
	//@Parameters({"browsers","username","password"})
	@Test(dataProvider="getData")
	public void launchBrowser(String browsers,String username, String password) throws MalformedURLException
	{
		Date d= new Date();
		
		System.out.println(browsers + d.toString());
		if(browsers.equals("chrome"))
		{
			desired.setBrowserName("chrome");
			
			ChromeOptions opt= new ChromeOptions();
			opt.merge(desired);
			
					
		}
		else if(browsers.equals("firefox"))
		{
			desired.setBrowserName("firefox");
			FirefoxOptions opt= new FirefoxOptions();
			opt.merge(desired);
			
		}
		
		driver= new RemoteWebDriver(new URL("http://localhost:4444"),desired);
		
		  driver.get("https://portal.bankit.in:9090/RO/");
		  System.out.println(driver.getTitle());
		  
		  driver.switchTo().frame("Main");
		  
		  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
		  driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(password);
		  driver.findElement(By.xpath("//input[@id='login']")).click();
		  
		
	}
	
	@DataProvider(parallel=true)
	public  Object[][] getData()
	{
		
		Object [][]data= new Object[2][3];
		
		data[0][0]="chrome";
		data[0][1]="8957181611";
		data[0][2]="119705";
		
		data[1][0]="firefox";
		data[1][1]="smitha.p@bankit.in";
		data[1][2]="Smitha@123";
		
		return data;
		
	}

}
