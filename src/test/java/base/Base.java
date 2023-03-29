package base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;

public class Base {
	
	public WebDriver initializeBrowser(String browserName) throws MalformedURLException
	{
		WebDriver driver;
		DesiredCapabilities dc= new DesiredCapabilities();
		
		
		if(browserName.equals("chrome"))
		{
			dc.setBrowserName("chrome");
		}
		else if(browserName.equals("firefox"))
		{
			dc.setBrowserName("firefox");
		}
		else if(browserName.equals("edge"))
		{
			dc.setBrowserName("MicrosoftEdge");
		}
		
		driver= new RemoteWebDriver(new URL("http://localhost:4444"),dc);
		
		return driver;
	}
	
	
	@DataProvider(parallel=true)
	public Object[][] getData()
	{
		
		Object[][] data=new Object[2][2];
		data[0][0]="8957181611";
		data[0][1]="119705";
		
		
		data[1][0]="smitha.p@bankit.in";
		data[1][1]="Smitha@123";
		
		
		return data;
		
	}

}
