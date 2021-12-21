package reference;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AO_BillGeneration_Open_Search extends AO_DischargePatient_SearchBTN{

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
		return new Object();
	}


}
