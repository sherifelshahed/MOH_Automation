package reference;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ACC_AddSeparateService {


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
		un.sendKeys("ACCIPD01");
		WebElement pw = driver.findElement(By.name("password"));
		pw.sendKeys("egy123");
		WebElement loginBTN = driver.findElement(By.id("loginID"));
		loginBTN.click();

		Thread.sleep(500);
//		WebElement loginBTnN = driver.findElement(By.id("loginID"));
//		loginBTnN.click();
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

	public Object OpenManagePatientOrderPage() throws InterruptedException {
		driver.switchTo().frame(1);
		driver.switchTo().frame("menuFr");
		Thread.sleep(500);
		WebElement AsignBed = driver.findElement(By.id("sd1"));
		AsignBed.click();
		Thread.sleep(500);
		System.out.println("Accountant is Navigated to Manage Patient Order Page Successfully");
		return new Object();
	}

	public Object SearchPatient(String Patient) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame("content");
		driver.switchTo().frame("BLChargePatientQueryFrame");
		driver.switchTo().frame("search_frame");

		WebElement Patient_ID = driver.findElement(By.name("patient_id"));
		try {
			Patient_ID.clear();
		} catch (Exception e) {
		}
		Patient_ID.sendKeys(Patient);

		WebElement SearchBTN = driver.findElement(By.name("search_button"));
		SearchBTN.click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("content");
		driver.switchTo().frame("BLChargePatientQueryFrame");
		driver.switchTo().frame("result_frame");
		Thread.sleep(2000);
		WebElement PatID = driver.findElement(By.xpath("//table[2]/tbody/tr[2]/td[4]/a"));
		assertEquals(Patient, PatID.getText());
		System.out.println("Search button is working and result is displaying: "+PatID.getText());
		PatID.click();
		Thread.sleep(1000);
		return new Object();
	}
	
	public Object RecordOrder() throws InterruptedException {
		
		
		Set<String> windows1 = driver.getWindowHandles();
		for (String window1 : windows1) 
		{ 
			driver.switchTo().window(window1); 
			if (driver.getTitle().contains("Charge Patient")) 
			{
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("BLChargePatientEncounterTab");
				Thread.sleep(1000);
				WebElement NewOrder = driver.findElement(By.id("NewOrder"));
				NewOrder.click();
				
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("BLChargePatientEncounterTabPage");
				
				WebElement ServiceGroup = driver.findElement(By.id("serviceGroup"));
				ServiceGroup.click();
				ServiceGroup.sendKeys(Keys.ARROW_DOWN);
				ServiceGroup.sendKeys(Keys.ARROW_DOWN);
				ServiceGroup.sendKeys(Keys.ENTER);
				
				WebElement Classification = driver.findElement(By.id("serviceClassification"));
				Classification.sendKeys("Audiology");
				WebElement ClassificationBTN = driver.findElement(By.id("serviceClass_btn"));
				ClassificationBTN.click();
				
				
				WebElement SearchBTN = driver.findElement(By.name("add_mod"));
				SearchBTN.click();
				
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("BLChargePatientExisOrderTraverse");
				
				WebElement ServiceCode = driver.findElement(By.id("servCode_1"));
				ServiceCode.click();
				
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("BLChargePatientExisOrderServDetails");
				
				WebElement RecordBTN = driver.findElement(By.xpath("//table/tbody/tr[2]/td/input"));
				RecordBTN.click();
				
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("messageFrame");
				WebElement SuccessMSG = driver.findElement(By.xpath("/html/body/p"));
				System.out.println(SuccessMSG.getText());
				assertTrue(SuccessMSG.getText().contains("Operation Completed Successfully"));
	
			}
		}
		
		
		return new Object();
	}
	
	
	public Object CloseDriver() {
		driver.quit();
		return new Object();
	}

}
