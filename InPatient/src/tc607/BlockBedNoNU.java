package tc607;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BlockBedNoNU {
	InternetExplorerDriver driver;
	public void openURL() throws InterruptedException 
	{
	System.setProperty("webdriver.ie.driver", "D:\\EM\\IEDriverServer.exe"); 
	 driver=new InternetExplorerDriver();
	 driver.get("http://10.209.1.5:7777/HIS/eSM/jsp/login.jsp");
	 driver.manage().window().maximize();
	}
	
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    // Finding Elements & Actions on Elements 
	
	public void Block_bed_No_NU(String usernameS, String passwordS) throws InterruptedException {
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
    WebElement Block_bed_btn = driver.findElement(By.id("sd7"));
    Block_bed_btn.click(); 
    
    driver.switchTo().defaultContent();
    driver.switchTo().frame(2);
    driver.switchTo().frame("f_query_add_mod");
   // WebElement BedNumber = driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]"));
    WebElement BedNumber = driver.findElement(By.name("search_bed"));
    BedNumber.click();
    Thread.sleep(900);
    
    org.openqa.selenium.Alert alert = driver.switchTo().alert();
    String alertMessage= driver.switchTo().alert().getText();
    System.out.println(alertMessage);

    alert.accept();
    
//    String currentWindow = driver.getWindowHandle();
//    Set<String> windows1 = driver.getWindowHandles();  
//    for (String window1 : windows1) 
//    { 
//        driver.switchTo().window(window1); 
//        if (driver.getTitle().contains("Bed Availability Chart")) 
//        { 
//            driver.switchTo().parentFrame();
//            driver.switchTo().defaultContent();
//            driver.switchTo().frame("result");
//            //    System.out.println(driver.getTitle());
//            Thread.sleep(2000);
           // System.out.println(driver.getCurrentUrl());
            //BedNumber.click();
            
//    System.out.println(BedNumber.getText());
//    Thread.sleep(900);
// }
    //}
}
}
