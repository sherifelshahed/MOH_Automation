package tc883;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ViewWardOccupancy {
	InternetExplorerDriver driver;
	public void openURL() throws InterruptedException 
	{
	System.setProperty("webdriver.ie.driver", "D:\\EM\\IEDriverServer.exe"); 
	 driver=new InternetExplorerDriver();
	 driver.get("http://10.209.1.5:7777/HIS/eSM/jsp/login.jsp");
	 driver.manage().window().maximize();
	}
public void View_Ward_occupancy (String usernameS, String passwordS) throws InterruptedException {
		
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
	    WebElement Ward_occupancy = driver.findElement(By.id("sd6"));
	    Ward_occupancy.click();
	    
	    driver.switchTo().parentFrame();
	    driver.switchTo().defaultContent();
	    //driver.switchTo().frame(2);
	    driver.switchTo().frame("content");   
	    driver.switchTo().frame("criteria");
	    
	    WebElement nursing_unit = driver.findElement(By.name("fr_nursing_unit_desc"));
	    nursing_unit.sendKeys("A2IM");
	  
	    WebElement search = driver.findElement(By.name("search"));
	    search.click();
	    if(search.isEnabled()) {System.out.println("search button is enabled and functional");
	    }
	    driver.switchTo().parentFrame();
	    driver.switchTo().defaultContent();
	    //driver.switchTo().frame(2);
	    driver.switchTo().frame("content");   
	    driver.switchTo().frame("result");
	    WebElement result = driver.findElement(By.xpath("//table/tbody/tr[2]/td"
));
	    if(result.isDisplayed()) {System.out.println("results are displayed");
	    }
}}
