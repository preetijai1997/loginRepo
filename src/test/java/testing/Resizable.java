package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Resizable {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bs0452\\Downloads\\browsers\\chromedriver.exe");
        ChromeOptions option= new ChromeOptions();
		
		option.addArguments("--remote-allow-origins=*");
	   WebDriver driver= new ChromeDriver(option);
		
		driver.get("https://jqueryui.com/resources/demos/resizable/default.html");
        WebElement icon=driver.findElement(By.xpath("//div[contains(@class,'ui-icon-gripsmall-diagonal-se')]"));
        
        new Actions(driver).dragAndDropBy(icon, 300, 270).perform();
	}

}
