package tc611;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BlockBedNoFromDate {
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
	
	public void Block_bed_No_From_Date(String usernameS, String passwordS) throws InterruptedException {
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
    WebElement NursingUnit = driver.findElement(By.xpath("//table/tbody/tr[2]/td"));
    System.out.println(NursingUnit.getText());
    WebElement NursingUnitTXT = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/input"));
    NursingUnitTXT.sendKeys("A2GS");
    System.out.println("Nursing Unit is Text Field. "+NursingUnitTXT.getAttribute("value"));
    Thread.sleep(5000);
   
    WebElement BedNumber = driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]"));
    System.out.println(BedNumber.getText());
    Thread.sleep(900);

    WebElement BedNumberTXTF = driver.findElement(By.xpath("//table/tbody/tr[2]/td[4]/input"));
    WebElement BedNumberTXT = driver.findElement(By.xpath("//table/tbody/tr[2]/td[4]/input[2]"));
    Thread.sleep(500);
    BedNumberTXT.click();
    Thread.sleep(500);
    BedNumberTXT.click();
    
    
    String currentWindow = driver.getWindowHandle();
    Set<String> windows1 = driver.getWindowHandles();  
    for (String window1 : windows1) 
    { 
        driver.switchTo().window(window1); 
        if (driver.getTitle().contains("Bed Availability Chart")) 
        { 
            driver.switchTo().parentFrame();
            driver.switchTo().defaultContent();
            driver.switchTo().frame("result");
            //    System.out.println(driver.getTitle());
            Thread.sleep(2000);
            WebElement BedNo = driver.findElement(By.xpath("//input[@class = 'IP_GreenButton']"));
            BedNo.click();
            System.out.println(BedNo.getText());
            BedNo.click();
            Thread.sleep(3000); 
            driver.switchTo().window(currentWindow);
            driver.switchTo().defaultContent();
            driver.switchTo().frame(2);
            driver.switchTo().frame("f_query_add_mod");
            WebElement Reason = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]/select"));
            Reason.sendKeys("d");
            WebElement remarks = driver.findElement(By.name("remarks"));
            remarks.sendKeys("brub!");  
          // WebElement fromdate = driver.findElement(By.name("from_date"));  
            //fromdate.sendKeys("23/12/2021 19:40");
            WebElement untildate = driver.findElement(By.name("until_date"));  
            untildate.sendKeys("23/12/2021 20:40");
            Thread.sleep(800);
    }
    }
    driver.switchTo().parentFrame();
    driver.switchTo().defaultContent();
    driver.switchTo().frame("content");
    driver.switchTo().frame("commontoolbarFrame");

//    System.out.println(driver.getPageSource());

    WebElement Apply = driver.findElement(By.name("apply"));
    Apply.click();
    Thread.sleep(800);
    
    driver.switchTo().defaultContent();
    driver.switchTo().frame("content");
    driver.switchTo().frame("messageFrame");
    WebElement msg = driver.findElement(By.xpath("/html/body/p"));
    System.out.println(msg.getText());


}}

