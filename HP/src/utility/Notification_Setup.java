package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Notification_Setup {
	WebDriver driver ;
	
	
	public Object invoke_browser()  
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\eclipse-workspace\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://10.107.159.226/" ; 
		driver.navigate().to(url);
		return new Object();
	}

	public Object Login_to_BMS(String username, String password) {
		//Implicit Wait 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Finding Elements & Actions on Elements 
		WebElement usernametxt = driver.findElement(By.id("username"));
		usernametxt.sendKeys(username);
		WebElement passwordtxt = driver.findElement(By.id("password"));
		passwordtxt.sendKeys(password);
		WebElement loginbtn = driver.findElement(By.name("login"));
		loginbtn.click();
		if(driver.getTitle()=="Beneficiary Management System") {
			System.out.println("the user is logged in successfully");
		}
		//System.out.println(Actual_Result);
		//Assert.assertEquals(Actual_Result,Expected_Result);
		return new Object();
	}
	

}
