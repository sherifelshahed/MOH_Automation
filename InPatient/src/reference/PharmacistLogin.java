package reference;

import java.awt.AWTException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class PharmacistLogin {
	InternetExplorerDriver driver;

	public Object openurl() {
		System.setProperty("webdriver.ie.driver", "D:\\Data\\Automation\\IEDriverServer_Win32\\IEDriverServer.exe");
		driver = new InternetExplorerDriver(); 
		driver.get("http://10.209.1.5:7777/HIS/eSM/jsp/login.jsp");
		driver.manage().window().maximize();
		return new Object();
	}	
	public Object Login() throws InterruptedException, AWTException {

		WebElement un = driver.findElement(By.name("name")); 
		un.sendKeys("PCYIPD01");
		WebElement pw = driver.findElement(By.name("password"));
		pw.sendKeys("egy123");
		WebElement loginBTN = driver.findElement(By.id("loginID"));
		loginBTN.click();

		Thread.sleep(500);
		WebElement loginBTnN = driver.findElement(By.id("loginID"));
		loginBTnN.click();
		driver.manage().window().maximize();
		Thread.sleep(200);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String homePage = it.next();
		String systemEM = it.next();
		
		driver.switchTo().window(systemEM);
		driver.close();
		driver.switchTo().window(homePage);
		driver.get("http://10.209.1.5:7777/HIS/eCommon/jsp/eHIS.jsp");
		return new Object();
	}
	
	public Object DispenseMedicationPage() throws InterruptedException {
		
		
		driver.switchTo().frame(1);
		driver.switchTo().frame("menuFr");
		Thread.sleep(500);
		WebElement DispenseMed = driver.findElement(By.id("sd1"));
		DispenseMed.click();
		
		Thread.sleep(2000);
		
		String currentWindow = driver.getWindowHandle();
		Set<String> windows1 = driver.getWindowHandles();  
		for (String window1 : windows1) 
		{ 
			driver.switchTo().window(window1); 
			if (driver.getTitle().contains("Dispensing Medication Login")) 
			{ 
				
				
				WebElement PassW = driver.findElement(By.name("password"));
				PassW.sendKeys("egy123");
				
				WebElement OKBTN = driver.findElement(By.xpath("//table/tbody/tr[10]/td/input"));
				OKBTN.click();
				
				driver.switchTo().window(currentWindow);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("content");
				driver.switchTo().frame("f_query_add_mod");
				
			}
		}
		
		return new Object();
	}
	
	
	
	public Object CloseDriver() {
		
		driver.quit();
		return new Object();
	}
	
	
	
}
