package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Login {

	public static void main(String[] args) {
	
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bs0452\\Downloads\\browsers\\chromedriver.exe");
		
		
	   WebDriver driver= new ChromeDriver();
	   
	   driver.get("https://portal.bankit.in:9090/RO/");
	   driver.manage().window().maximize();
	   driver.switchTo().frame("Main");
	   
	   driver.findElement(By.name("userName")).sendKeys("8957181611");
	   driver.findElement(By.id("password")).sendKeys("119705");
	   driver.findElement(By.id("login")).click();
	   
	   System.out.println("Login Successfully");
		System.out.println("-------------------Login Page--------------------");
	}

}
