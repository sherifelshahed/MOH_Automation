package reference;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AO_DischargePatient_SearchBTN {
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
		un.sendKeys("CMOIPD01");
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

	public Object OpenPatientDischargePage() throws InterruptedException {
		driver.switchTo().frame(1);
		driver.switchTo().frame("menuFr");
		Thread.sleep(500);
		WebElement AsignBed = driver.findElement(By.id("sd9"));
		AsignBed.click();
		Thread.sleep(500);
		System.out.println("Admission Officer is Navigated to Patient Discharge Page Successfully");
		return new Object();
	}
	
	public Object SearchForPatient(String Patient) throws InterruptedException {
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod");
		
		WebElement Patient_ID = driver.findElement(By.name("patient_id"));
		Patient_ID.sendKeys(Patient);
		
		WebElement SearchBTN = driver.findElement(By.name("search"));
		SearchBTN.click();
		
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod1");
		Thread.sleep(2000);
		WebElement PatID = driver.findElement(By.xpath("//table[2]/tbody/tr[2]/td[4]"));
		assertEquals(Patient, PatID.getText());
		System.out.println("Search button is working and result is displaying: "+PatID.getText());
		
		return new Object();
	}
	
	public Object CloseDriver() {
		
		driver.quit();
		
		return new Object();
	}

}
