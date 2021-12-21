package reference;

import java.awt.AWTException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class NUR_BlockBedpageUICheck {


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
		un.sendKeys("NURIPD01");
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

	public Object OpenBlockBedPage() throws InterruptedException {
		driver.switchTo().frame(1);
		driver.switchTo().frame("menuFr");
		Thread.sleep(500);
		WebElement AsignBed = driver.findElement(By.id("sd7"));
		AsignBed.click();
		Thread.sleep(500);
		System.out.println("Nurse is Navigated to Block Bed Page Successfully");
		return new Object();
	}

	public Object CheckFields() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod");
		WebElement NursingUnit = driver.findElement(By.xpath("//table/tbody/tr[2]/td"));
		System.out.println("Nursing Unit is existing with Title: "+NursingUnit.getText());
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
				System.out.println(driver.getCurrentUrl());
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("result");
				
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
			}
		}   

		System.out.println("Bed Number is Text Field. "+BedNumberTXTF.getAttribute("value"));
		WebElement BedClass = driver.findElement(By.xpath("//table/tbody/tr[3]/td[1]"));
		WebElement BedClassR = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
		System.out.println("Bed Class field is existing with title: " +BedClass.getText() +" With Type: "+BedClassR.getText());



		WebElement RoomNO = driver.findElement(By.xpath("//table/tbody/tr[3]/td[3]"));
		WebElement RoomNOR = driver.findElement(By.xpath("//table/tbody/tr[3]/td[4]"));
		System.out.println("Room number field is existing with title: " +RoomNO.getText()+ " With Room number: "+RoomNOR.getText());
		RoomNO.click();

		WebElement ReasonForBlocking = driver.findElement(By.xpath("//table/tbody/tr[6]/td[1]"));
		System.out.println("Reason for Blocking list is existing with title: " +ReasonForBlocking.getText());

		WebElement Reason = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]/select"));
		Reason.click();
		Reason.sendKeys(Keys.ARROW_DOWN);
		Reason.sendKeys(Keys.ARROW_DOWN);
		Reason.sendKeys(Keys.ARROW_DOWN);
		Reason.sendKeys(Keys.TAB);

		WebElement OverRide = driver.findElement(By.xpath("//table/tbody/tr[7]/td[1]"));
		System.out.println("OverRide field is existing with title: " +OverRide.getText());

		WebElement Remarks = driver.findElement(By.xpath("//table/tbody/tr[8]/td[1]"));
		System.out.println("Remarks field is existing with title: " +Remarks.getText());

		WebElement RemarksTXT = driver.findElement(By.xpath("//table/tbody/tr[8]/td[2]/input"));
		RemarksTXT.sendKeys("ATEST");

		WebElement FromDate = driver.findElement(By.xpath("//table/tbody/tr[9]/td[1]"));
		System.out.println("From Date field is existing with title: " +FromDate.getText());

		WebElement FromDateTXT = driver.findElement(By.xpath("//table/tbody/tr[9]/td[2]/input"));
		FromDateTXT.sendKeys("19/12/2021 19:40");
		FromDateTXT.sendKeys(Keys.TAB);

		WebElement UntilDate = driver.findElement(By.xpath("//table/tbody/tr[9]/td[3]"));
		System.out.println("Until Date field is existing with title: " +UntilDate.getText());

		WebElement UntilDateTXT = driver.findElement(By.xpath("//table/tbody/tr[9]/td[4]/input"));
		UntilDateTXT.sendKeys(Keys.TAB);

		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("content");
		driver.switchTo().frame("commontoolbarFrame");
		
		WebElement ApplyBTN = driver.findElement(By.xpath("//table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td[1]/input"));
		System.out.println("Apply Button is Existing. "+ApplyBTN.getAttribute("value"));
		WebElement ResetBTN = driver.findElement(By.xpath("//table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td[2]/input"));
		System.out.println("Reset Button is Existing. "+ResetBTN.getAttribute("value"));
		ResetBTN.click();

		WebElement Menu = driver.findElement(By.xpath("//table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td[4]/input"));
		System.out.println("Menu Button is Existing. "+Menu.getAttribute("value"));
		Menu.click();
		return new Object();
	}


	public Object CloseDriver() {

		driver.quit();
		return new Object();
	}

}
