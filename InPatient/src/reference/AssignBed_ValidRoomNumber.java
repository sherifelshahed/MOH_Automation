package reference;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebElement;

public class AssignBed_ValidRoomNumber extends AssignBed_MarkPatientArrival{

	public Object CheckRoomNumber(String PateID, String PractitionerName, String RoomNumber) throws InterruptedException {
		
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

		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod1");

		WebElement ENCID = driver.findElement(By.xpath("//table[2]/tbody/tr[2]/td[4]/a"));
		ENCID.click();

		Set<String> windows1 = driver.getWindowHandles();  
		for (String window1 : windows1) 
		{ 
			driver.switchTo().window(window1); 
			if (driver.getTitle().contains("Assign Bed / Mark Patient Arrival")) 
			{ 
				driver.switchTo().defaultContent();
				driver.switchTo().frame("message");
				Thread.sleep(500);
				WebElement BedBTN = driver.findElement(By.name("bed_avail_chart"));
				BedBTN.click();


				String currentWindow = driver.getWindowHandle();
				Set<String> windowsz = driver.getWindowHandles();  
				for (String window2 : windowsz) 
				{ 
					driver.switchTo().window(window2); 
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
						driver.switchTo().defaultContent();
						driver.switchTo().frame("message");
						Thread.sleep(500);
						WebElement RoomNo = driver.findElement(By.name("to_room_no"));
						try {
							
						RoomNo.clear();
						RoomNo.sendKeys(RoomNumber);
						} catch (InvalidElementStateException e) {
							
							System.out.println("Room number Field is ReadOnly Field");
						}
						
					}
				}	
			}
		}
		
		return new Object();
	}
	
}
