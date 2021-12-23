package reference;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ACC_CheckPanelCharging extends ACC_RecordPanel{

	public Object SearchPatientNe(String Patient) throws InterruptedException {

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

		WebElement EncPeriod = driver.findElement(By.id("encounter_period"));
		EncPeriod.click();
		EncPeriod.sendKeys(Keys.ARROW_DOWN);
		EncPeriod.sendKeys(Keys.TAB);


		WebElement dateFrom = driver.findElement(By.id("encounter_from_date"));
		try {
			dateFrom.clear();
		} catch (Exception e) {
		}
		
		dateFrom.sendKeys("01/08/2021");
		dateFrom.sendKeys(Keys.TAB);


		WebElement dateTo = driver.findElement(By.id("encounter_to_date"));
		try {
			dateTo.clear();
		} catch (Exception e) {
		}
		dateTo.sendKeys("23/12/2021");
		dateTo.sendKeys(Keys.TAB);


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

	public Object LoginCMO() throws InterruptedException, AWTException {

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

	public Object OpenBillGenerationPage() throws InterruptedException {
		driver.switchTo().frame(1);
		driver.switchTo().frame("menuFr");
		Thread.sleep(500);
		WebElement AsignBed = driver.findElement(By.id("sd15"));
		AsignBed.click();
		Thread.sleep(500);
		System.out.println("Admission Officer is Navigated to Bill Generation Page Successfully");
		return new Object();
	}

	public Object SearchPatientCMO(String Patient) throws InterruptedException {

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

		WebElement EncPeriod = driver.findElement(By.id("encounter_period"));
		EncPeriod.click();
		EncPeriod.sendKeys(Keys.ARROW_DOWN);
		EncPeriod.sendKeys(Keys.TAB);


		WebElement dateFrom = driver.findElement(By.id("encounter_from_date"));
		try {
			dateFrom.clear();
		} catch (Exception e) {
		}
		
		dateFrom.sendKeys("01/08/2021");
		dateFrom.sendKeys(Keys.TAB);


		WebElement dateTo = driver.findElement(By.id("encounter_to_date"));
		try {
			dateTo.clear();
		} catch (Exception e) {
		}
		dateTo.sendKeys("23/12/2021");
		dateTo.sendKeys(Keys.TAB);


		
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
		return new Object();
	}
	public Object GenerateBill() throws InterruptedException {
		Thread.sleep(1000);
		try {
			Thread.sleep(1000);

			org.openqa.selenium.Alert alert1 = driver.switchTo().alert();
			String alertMessage1= driver.switchTo().alert().getText();
			System.out.println(alertMessage1);
			Thread.sleep(1000);
			alert1.accept();
			Thread.sleep(1000);
		} catch (Exception e) {

		}

		Set<String> windows1 = driver.getWindowHandles();  
		for (String window1 : windows1) 
		{ 
			driver.switchTo().window(window1); 
			if (driver.getTitle().contains("Bill Generation")) 
			{
				System.out.println(driver.getCurrentUrl());
				Thread.sleep(1000);
				try {
					org.openqa.selenium.Alert alert = driver.switchTo().alert();
					String alertMessage= driver.switchTo().alert().getText();
					System.out.println(alertMessage);
					Thread.sleep(1000);
					alert.accept();
				} catch (Exception e) {
					// TODO: handle exception
				}

				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("BillReceiptInfo");

				WebElement BillType = driver.findElement(By.id("inPatBillType"));
				BillType.click();
				BillType.sendKeys(Keys.ARROW_UP);
			//	BillType.sendKeys(Keys.ARROW_UP);
				BillType.sendKeys(Keys.ENTER);

				try {
					org.openqa.selenium.Alert alert = driver.switchTo().alert();
					String alertMessage= driver.switchTo().alert().getText();
					System.out.println(alertMessage);
					Thread.sleep(1000);
					alert.accept();
				} catch (Exception e) {

				}

				WebElement GenerateBillBTN = driver.findElement(By.name("compute"));
				GenerateBillBTN.click();
				System.out.println("Generate button is Working.");
				Thread.sleep(3000);

				try {
					org.openqa.selenium.Alert alert = driver.switchTo().alert();
					String alertMessage= driver.switchTo().alert().getText();
					System.out.println(alertMessage);
					Thread.sleep(1000);
					alert.accept();
					Thread.sleep(1000);
				} catch (Exception e) {

				}

				
				

			}
		}


		return new Object();
	}




}
