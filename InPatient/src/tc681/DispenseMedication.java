package tc681;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DispenseMedication {
	InternetExplorerDriver driver;
	public void openURL() throws InterruptedException 
	{
	System.setProperty("webdriver.ie.driver", "D:\\EM\\IEDriverServer.exe"); 
	 driver=new InternetExplorerDriver();
	 driver.get("http://10.209.1.5:7777/HIS/eSM/jsp/login.jsp");
	 driver.manage().window().maximize();
	}
	public void Dispense_Medication (String usernameS, String passwordS) throws InterruptedException {
		
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
	    
	    int count = driver.findElements(By.tagName("frame")).size();
	    driver.switchTo().frame(1);
	    driver.switchTo().frame("menuFr");
	    WebElement charges_patientissue_btn = driver.findElement(By.id("sd13"));
	    charges_patientissue_btn.click();	
	    
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame("content");
	    driver.switchTo().frame("commontoolbarFrame");
	    WebElement create = driver.findElement(By.name("create"));
	    create.click();
//	    
//	    driver.switchTo().parentFrame();
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame("f_query_add_mod");
//		driver.switchTo().frame("frameSalesHeader");
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(2);
	    driver.switchTo().frame("f_query_add_mod");
	    driver.switchTo().frame("frameSalesHeader");
		
		WebElement sales_type = driver.findElement(By.id("sal_trn_type"));
		sales_type.click();
		sales_type.sendKeys(Keys.ARROW_DOWN);
		sales_type.sendKeys(Keys.ENTER);
		
//		driver.switchTo().defaultContent();
//	    driver.switchTo().frame(2);
//	    driver.switchTo().frame("f_query_add_mod");
//	    driver.switchTo().frame("frameSalesHeader");
	    
//	    driver.switchTo().parentFrame();
//        driver.switchTo().defaultContent();
//        driver.switchTo().frame("f_query_add_mod");
//        driver.switchTo().frame("frameSalesHeader");
	    
		WebElement Patient_ID = driver.findElement(By.name("patient_id"));
		Patient_ID.click();
		Patient_ID.sendKeys("A200000400");
		Thread.sleep(500);
		
		WebElement remark = driver.findElement(By.name("remarks"));
		remark.click();
		remark.sendKeys("A200000400");
		
//		 	driver.switchTo().defaultContent();
//		    driver.switchTo().frame(2);
//		    driver.switchTo().frame("frameSalesList");
//		    driver.switchTo().frame("frameSalesListHeader");

		//driver.switchTo().parentFrame();
      driver.switchTo().defaultContent();
      driver.switchTo().frame("content");
      driver.switchTo().frame("f_query_add_mod");
      //driver.switchTo().frame("frameSalesHeader");
      driver.switchTo().frame("frameSalesList");
      driver.switchTo().frame("frameSalesListHeader");
      WebElement itemdsc = driver.findElement(By.name("item_desc"));
      itemdsc.click();
      itemdsc.sendKeys("one two three");
	  WebElement item = driver.findElement(By.name("item_search"));
	  item.click();
	  WebElement quantity = driver.findElement(By.name("item_qty"));
	  quantity.click();
	  quantity.sendKeys("1");
	  WebElement add_btn = driver.findElement(By.name("apply"));
	  add_btn.click();
	  
	  driver.switchTo().defaultContent();
	    driver.switchTo().frame("content");
	    driver.switchTo().frame("commontoolbarFrame");
	    WebElement apply = driver.findElement(By.name("apply"));
	    apply.click();
	    
	    String currentWindow = driver.getWindowHandle();
	    Set<String> windows1 = driver.getWindowHandles();
	    for (String window1 : windows1) 
	    { 
	        driver.switchTo().window(window1); 
	        if (driver.getTitle().contains("Confirm Finalize")) 
	        {  
	        	WebElement yes = driver.findElement(By.name("yes"));
	    	    yes.click();
	        	//System.out.println(driver.getCurrentUrl());
	        	}
	        }
		
	}
}
