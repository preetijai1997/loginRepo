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

public class ParameterXMLThreadLocal extends Base {
	
	public ThreadLocal<WebDriver> dr= new ThreadLocal<WebDriver>();
	
	public WebDriver driver;
	
	public ThreadLocal<DesiredCapabilities> dc= new ThreadLocal<DesiredCapabilities>();
	public DesiredCapabilities desired;
	
	public WebDriver getDriver()
	{
		return dr.get();
		
	}
	
	public void setDriver(WebDriver driver)
	{
		dr.set(driver);
	}
	
	public DesiredCapabilities getDesiredCapabilities()
	{
		return dc.get();
		
	}
	
	public void setDesiredCapabilities(DesiredCapabilities cap)
	{
		dc.set(cap);
	}
	
	//@Parameters({"browsers","username","password"})
	@Test(dataProvider="getData")
	public void launchBrowser(String browsers,String username, String password) throws MalformedURLException
	{
		Date d= new Date();
		
		System.out.println(browsers + d.toString());
		if(browsers.equals("chrome"))
		{
			desired= new DesiredCapabilities();
			setDesiredCapabilities(desired);
			getDesiredCapabilities().setBrowserName("chrome");
			
			ChromeOptions opt= new ChromeOptions();
			opt.merge(getDesiredCapabilities());
			
					
		}
		else if(browsers.equals("firefox"))
		{
			desired= new DesiredCapabilities();
			setDesiredCapabilities(desired);
			getDesiredCapabilities().setBrowserName("firefox");
			FirefoxOptions opt= new FirefoxOptions();
			opt.merge(getDesiredCapabilities());
			
		}
		
		driver= new RemoteWebDriver(new URL("http://localhost:4444"),desired);
		setDriver(driver);
		getDriver().get("https://portal.bankit.in:9090/RO/");
		  System.out.println(getDriver().getTitle());
		  
		  getDriver().switchTo().frame("Main");
		  
		  getDriver().findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
		  getDriver().findElement(By.xpath("//input[@name='pass']")).sendKeys(password);
		  getDriver().findElement(By.xpath("//input[@id='login']")).click();
		  
		
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
