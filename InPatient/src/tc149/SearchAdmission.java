package tc149;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SearchAdmission {
	InternetExplorerDriver driver;
	public void openURL() throws InterruptedException 
	{
	System.setProperty("webdriver.ie.driver", "D:\\EM\\IEDriverServer.exe"); 
	 driver=new InternetExplorerDriver();
	 driver.get("http://10.209.1.5:7777/HIS/eSM/jsp/login.jsp");
	 driver.manage().window().maximize();
	}
public void Search_admission (String usernameS, String passwordS ) throws InterruptedException {
		
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
	    
	    
	    
//	    WebElement nursingunit = driver.findElement(By.name("nursing_unit_desc"));
//	    nursingunit.sendKeys("A2GS");
	    WebElement search_btn = driver.findElement(By.name("search"));
	    search_btn.click();
//	    Thread.sleep(900);
//	    search_btn.click();
	    if(search_btn.isEnabled()) {
		    System.out.println("search button is exiting and functional");
}
	    driver.switchTo().parentFrame();
	    driver.switchTo().defaultContent();
	    //driver.switchTo().frame(2);
	    driver.switchTo().frame("content");                          
	    WebElement frame1 = driver.findElement(By.xpath("//frame[@name='f_query_add_mod'][2]"));
	    driver.switchTo().frame(frame1);
	    WebElement resultstable = driver.findElement(By.id("table_header"));
	    if(resultstable.isDisplayed()) {
	    	
	    	System.out.println("Search results are displayed");
}}}
