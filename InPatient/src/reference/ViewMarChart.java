package reference;

import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ViewMarChart extends NUR_BlockBedpageUICheck{

	public Object OpenMedicationAdministrationPage() throws InterruptedException {
		driver.switchTo().frame(1);
		driver.switchTo().frame("menuFr");
		Thread.sleep(500);
		WebElement AsignBed = driver.findElement(By.id("sd12"));
		AsignBed.click();
		Thread.sleep(500);
		System.out.println("Nurse is Navigated to Medication Administration Page Successfully");
		return new Object();
	}

	public Object SearchForPatient() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame("content");
		driver.switchTo().frame("f_search");

		WebElement Location = driver.findElement(By.name("nursing_unit_desc"));
		Location.sendKeys("A2GS");

		WebElement LocationBTN = driver.findElement(By.id("location_search"));
		LocationBTN.click();

		String currentWindow = driver.getWindowHandle();
		Set<String> windows1 = driver.getWindowHandles();  
		for (String window1 : windows1) 
		{ 
			driver.switchTo().window(window1); 
			if (driver.getTitle().contains("Location")) 
			{ 

				driver.switchTo().defaultContent();
				driver.switchTo().frame("lookup_detail");
				WebElement LocSelection = driver.findElement(By.xpath("//table[2]/tbody/tr[2]/td[1]"));
				System.out.println("Nursing Unit: "+LocSelection.getText());
				LocSelection.click();
				Thread.sleep(500);
				driver.switchTo().window(currentWindow);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("content");
				driver.switchTo().frame("f_search");
			}
		}
			
		WebElement SearchBTN = driver.findElement(By.id("Search"));
		SearchBTN.click();
		return new Object();
	}
	
	public Object ViewChart() throws InterruptedException {
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("content");
		driver.switchTo().frame("f_query_add_mod");
		driver.switchTo().frame("f_patient_details");
		driver.switchTo().frame("f_bedheader");
		
		WebElement PatientID = driver.findElement(By.id("patient_id_1"));
		System.out.println(PatientID.getText());
		PatientID.click();
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("content");
		driver.switchTo().frame("f_query_add_mod");
		driver.switchTo().frame("f_admin_button");
		
		WebElement ViewMedAdmChart = driver.findElement(By.name("btnViewAdminDetails"));
		ViewMedAdmChart.click();
		
		
		Set<String> windowsz = driver.getWindowHandles();  
		for (String windowv : windowsz) 
		{ 
			driver.switchTo().window(windowv); 
			if (driver.getTitle().contains("Medication Administration Detail")) 
			{ 
				
				assertTrue(driver.getTitle().contains("Medication Administration Detail"));
				System.out.println("Mar Chart is Displayed Successfully.");
				
				
			}
		}
		
		return new Object();
	}

}
