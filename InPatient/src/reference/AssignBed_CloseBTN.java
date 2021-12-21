package reference;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AssignBed_CloseBTN extends AssignBed_MarkPatientArrival{


	public Object CheckCloseBTN(String PateID, String PractitionerName) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod");

		WebElement NursingUnitTXT = driver.findElement(By.name("nursing_unit_desc"));
		NursingUnitTXT.sendKeys("A2GS");

		WebElement NursingUnitBTN = driver.findElement(By.name("nursing_unit_lookup"));
		NursingUnitBTN.click();

		WebElement PatientID = driver.findElement(By.name("patient_id"));
		PatientID.sendKeys(PateID);

		WebElement SearchBTN = driver.findElement(By.name("search"));
		SearchBTN.click();
		String currentWindowx = driver.getWindowHandle();
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod1");
		
		Thread.sleep(1000);
		WebElement ENCID = driver.findElement(By.xpath("//table[2]/tbody/tr[2]/td[4]/a"));
		ENCID.click();

		Set<String> windows1 = driver.getWindowHandles();  
		for (String window1 : windows1) 
		{ 
			driver.switchTo().window(window1);
			Thread.sleep(1000);
			if (driver.getTitle().contains("Assign Bed / Mark Patient Arrival")) 
			{ 

				driver.switchTo().defaultContent();
				driver.switchTo().frame("message");
				Thread.sleep(500);
				WebElement BedBTN = driver.findElement(By.name("bed_avail_chart"));
				BedBTN.click();
				Thread.sleep(1000);

				String currentWindow = driver.getWindowHandle();
				Set<String> windowsz = driver.getWindowHandles();  
				for (String window2 : windowsz) 
				{ 
					driver.switchTo().window(window2); 
					Thread.sleep(500);
					if (driver.getTitle().contains("Bed Availability Chart")) 
					{ 
						driver.switchTo().defaultContent();
						driver.switchTo().frame("result");

						Thread.sleep(500);
						WebElement Bed = driver.findElement(By.className("IP_GreenButton"));
						Bed.click();
						Thread.sleep(500);
						Bed.click();
						Thread.sleep(500);

						driver.switchTo().window(currentWindow);
						Thread.sleep(1000);
						
					}
				}	
				driver.switchTo().defaultContent();
				driver.switchTo().frame("message");
				Thread.sleep(500);

				WebElement CloseBTN = driver.findElement(By.xpath("//table[2]/tbody/tr/td[4]/input[4]"));
				System.out.println("Close button Button is Existing");
				CloseBTN.click();
				Thread.sleep(2000);

				driver.switchTo().window(currentWindowx);
				assertEquals("eHospital Information System", driver.getTitle());
				System.out.println(driver.getTitle()+"Window is displaying.");

			}
		}

		return new Object();
	}

}
