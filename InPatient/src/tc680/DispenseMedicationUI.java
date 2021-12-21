package tc680;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DispenseMedicationUI {
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
	    if(create.isEnabled()) {
	    System.out.println("create button is exiting and enabled");
	    }
	    WebElement query = driver.findElement(By.name("query"));
	    if(query.isEnabled()) {
	    System.out.println("query button is exiting and enabled");
	    }
	    WebElement apply = driver.findElement(By.name("apply"));
	    if(apply.isEnabled()) {
	    System.out.println("apply button is exiting and enabled");
	    }
	    WebElement reset = driver.findElement(By.name("reset"));
	    if(reset.isEnabled()) {
	    System.out.println("reset button is exiting and enabled");
	    }
	    WebElement home = driver.findElement(By.name("home"));
	    if(home.isEnabled()) {
	    System.out.println("menue button is exiting and enabled");
	    }
	    WebElement Delete = driver.findElement(By.xpath("//table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td[3]/input"));
	    if(Delete.isEnabled()) {
	    System.out.println("delete button is exiting and enabled");
	    }
	    
	}
	
}
