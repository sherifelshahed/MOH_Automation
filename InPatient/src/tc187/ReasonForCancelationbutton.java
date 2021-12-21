package tc187;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReasonForCancelationbutton {
	InternetExplorerDriver driver;
	public void openURL() throws InterruptedException 
	{
	System.setProperty("webdriver.ie.driver", "D:\\EM\\IEDriverServer.exe"); 
	 driver=new InternetExplorerDriver();
	 driver.get("http://10.209.1.5:7777/HIS/eSM/jsp/login.jsp");
	 driver.manage().window().maximize();
	}
	
public void Reason_For_Cancelation_btn (String usernameS, String passwordS , String encounterId) throws InterruptedException {
		
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
	    WebElement canceladmission_btn = driver.findElement(By.id("sd3"));
	    canceladmission_btn.click(); 
	    
	    
	    
	    
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(2);
	    driver.switchTo().frame("f_query_add_mod");
	    WebElement patient_search = driver.findElement(By.name("patient_id"));
	    patient_search.sendKeys("A700000004");
	    
	    WebElement search_btn = driver.findElement(By.name("search"));
	    search_btn.click();
	    if(search_btn.isEnabled()) {
		    System.out.println("search button is exiting and enabled");
		    }
	    driver.switchTo().parentFrame();
	    driver.switchTo().defaultContent();
	    //driver.switchTo().frame(2);
	    driver.switchTo().frame("content");                          
	    WebElement frame1 = driver.findElement(By.xpath("//frame[@name='f_query_add_mod'][2]"));
	    driver.switchTo().frame(frame1);
	    WebElement Encounter_ID_hyperlink  = driver.findElement(By.partialLinkText(encounterId));
	    Encounter_ID_hyperlink.click();
	    
	    
	    
	    String currentWindow = driver.getWindowHandle();
	    Set<String> windows1 = driver.getWindowHandles();
	    for (String window1 : windows1)
	    { driver.switchTo().window(window1);
	    if (driver.getTitle().contains("Cancel Admission")) 
	        { 
	    driver.switchTo().parentFrame();
	    driver.switchTo().defaultContent();
	    //driver.switchTo().frame("PLINE");
	    driver.switchTo().frame("f_query_add_mod");
	    WebElement Cancel_addmission_btn  = driver.findElement(By.name("cancel_admission"));
	    Cancel_addmission_btn.click();
	    WebElement reason_btn  = driver.findElement(By.xpath("//table[2]/tbody/tr/td[2]/select"));
	    
	    reason_btn.sendKeys(Keys.ARROW_DOWN);
	    reason_btn.getText();
	    if(reason_btn.isEnabled()) {
	    	
	    	System.out.println("Dropdown is enabled");
	    }
	    if(reason_btn.isDisplayed()) {
	    	
	    	System.out.println("Dropdown is visible");
	    	System.out.println(reason_btn.getSize());
	    }
}}}}
