package tc882;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CancelDischargePatient {
	InternetExplorerDriver driver;
	public void openURL() throws InterruptedException 
	{
	System.setProperty("webdriver.ie.driver", "D:\\EM\\IEDriverServer.exe"); 
	 driver=new InternetExplorerDriver();
	 driver.get("http://10.209.1.5:7777/HIS/eSM/jsp/login.jsp");
	 driver.manage().window().maximize();
	}
	
public void Cancel_Discharge_patient (String usernameS, String passwordS , String encounterId) throws InterruptedException {
		
		WebElement username = driver.findElement(By.name("name"));
	    username.clear();
		username.sendKeys(usernameS);
	    // usernametxt.sendKeys("NURIPD01");
	    WebElement password = driver.findElement(By.name("password"));
	    password.clear();
		password.sendKeys(passwordS);
	    //passwordtxt.sendKeys("egy123");
	    WebElement loginbtn = driver.findElement(By.id("loginID"));
	    loginbtn.click();
	    Thread.sleep(800);
	    loginbtn.click();
	    System.out.println(driver.getCurrentUrl());
	    Set<String> windows = driver.getWindowHandles();


	    Iterator<String> it = windows.iterator();
	    String ParentPage = it.next();
	    String ChildPage = it.next();
	    //driver.close();
	    driver.switchTo().window(ChildPage);
	    System.out.println(driver.getCurrentUrl());
	    driver.close();
	    driver.switchTo().window(ParentPage);
	    driver.get("http://10.209.1.5:7777/HIS/eCommon/jsp/eHIS.jsp");
	    
	    int count = driver.findElements(By.tagName("frameB")).size();
	    driver.switchTo().frame(1);
	    driver.switchTo().frame("menuFr");
	    WebElement canceldischarge_btn = driver.findElement(By.id("sd10"));
	    canceldischarge_btn.click();
	    
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(2);
	    driver.switchTo().frame("f_query_add_mod");
	    WebElement nursing_unit = driver.findElement(By.name("nursing_unit_desc"));
	    nursing_unit.sendKeys("A2GS");
	    WebElement search_btn = driver.findElement(By.name("search"));
	    search_btn.click();
	    Thread.sleep(500);
	    search_btn.click();
	    
	    driver.switchTo().parentFrame();
	    driver.switchTo().defaultContent();
	    //driver.switchTo().frame(2);
	    driver.switchTo().frame("content");   
	    driver.switchTo().frame("f_query_add_mod1"); 
//	    WebElement frame1 = driver.findElement(By.xpath("//frame[@name='f_query_add_mod'][1]"));
//	    driver.switchTo().frame(frame1);
	    WebElement Encounter_ID_hyperlink  = driver.findElement(By.partialLinkText(encounterId));
	    Encounter_ID_hyperlink.click();
	   
	    String currentWindow = driver.getWindowHandle();
	    Set<String> windows1 = driver.getWindowHandles();
	    for (String window1 : windows1)
	    { driver.switchTo().window(window1);
	    if (driver.getTitle().contains("Cancel Discharge Patient")) 
	        { 
	    	//System.out.println(driver.getCurrentUrl());
	    	driver.switchTo().parentFrame();
		    driver.switchTo().defaultContent();
		    //driver.switchTo().frame(2);
		   // driver.switchTo().frame("content");   
		    driver.switchTo().frame("Transfer_frame");
	    	WebElement reason_for_Cancelation = driver.findElement(By.xpath("//table/tbody/tr[16]/td[2]/select"));
	    	reason_for_Cancelation.sendKeys(Keys.ARROW_DOWN);
	    	
	    	driver.switchTo().parentFrame();
		    driver.switchTo().defaultContent();
		    driver.switchTo().frame("Transfer_frame_buttons");
		    WebElement Confirm_Cancelation = driver.findElement(By.name("confirm"));
		    Confirm_Cancelation.click();
		    
		    org.openqa.selenium.Alert alert = driver.switchTo().alert();
		    String alertMessage= driver.switchTo().alert().getText();
		    System.out.println(alertMessage);

		    alert.accept();
	        }
	        }
	    
}
}