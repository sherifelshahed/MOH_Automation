package tc616;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReleaseBlockedBed {

	InternetExplorerDriver driver;
	public void openURL() throws InterruptedException 
	{
	System.setProperty("webdriver.ie.driver", "D:\\EM\\IEDriverServer.exe"); 
	 driver=new InternetExplorerDriver();
	 driver.get("http://10.209.1.5:7777/HIS/eSM/jsp/login.jsp");
	 driver.manage().window().maximize();
	}
	
	
	public void Release_Bed(String usernameS, String passwordS) throws InterruptedException {
		
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
	    WebElement Release_bed_btn = driver.findElement(By.id("sd9"));
	    Release_bed_btn.click();	
		
	    //contentFrameset
	    //f_query_add_mod

//	    driver.switchTo().defaultContent();
//	    driver.switchTo().frame(2);
//	    driver.switchTo().frame("f_query_add_mod");
//	    WebElement NursingUnit = driver.findElement(By.name("nursing_unit_desc"));
//	    System.out.println(NursingUnit.getText());
//	    WebElement NursingUnitTXT = driver.findElement(By.name("nursing_unit_desc"));
//	    NursingUnitTXT.sendKeys("A2GS");
//	    System.out.println("Nursing Unit is Text Field. "+NursingUnitTXT.getAttribute("value"));
//	    Thread.sleep(5000);
	    
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(2);
	    driver.switchTo().frame("f_query_add_mod");
	    driver.switchTo().frame("ReleaseBed_main");
	    WebElement search = driver.findElement(By.name("search"));
		search.click();
		//ReleaseBedDetail_Form
		driver.switchTo().defaultContent();
	    driver.switchTo().frame(2);
	    driver.switchTo().frame("f_query_add_mod");
	    driver.switchTo().frame("ReleaseBed_details");
	    WebElement checkbx = driver.findElement(By.name("select_1"));
		checkbx.click();
		    driver.switchTo().parentFrame();
			driver.switchTo().defaultContent();
			driver.switchTo().frame("content");
			driver.switchTo().frame("commontoolbarFrame");
			System.out.println(driver.getPageSource());
			WebElement apply = driver.findElement(By.name("apply"));
			apply.click();
	}
	
	
	
}
