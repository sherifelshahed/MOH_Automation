package reference;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AssignBed_AttendingPractitioner_InvalidData extends AssignBed_MarkPatientArrival {

	public Object CheckAttendingPracFieldInvalid(String PateID, String PractitionerName) throws InterruptedException {

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
						Thread.sleep(1000);
					}
				}	

				WebElement Practitioner = driver.findElement(By.name("pract_desc"));
				Practitioner.sendKeys(PractitionerName);

				Thread.sleep(200);
				System.out.println(Practitioner.getAttribute("value"));

				WebElement RecordBTN = driver.findElement(By.name("record"));
				RecordBTN.click();
				Thread.sleep(2000);

				Set<String> windowszr = driver.getWindowHandles();  
				for (String window2r : windowszr) 
				{ 
					driver.switchTo().window(window2r); 
					Thread.sleep(2000);

					org.openqa.selenium.Alert alert1 = driver.switchTo().alert();
					String alertMessage1= driver.switchTo().alert().getText();
					System.out.println(alertMessage1);
					Thread.sleep(2000);
					alert1.accept();
					Thread.sleep(1000);
					Set<String> windowszrx = driver.getWindowHandles();  
					for (String window2rx : windowszrx) 
					{ 
						driver.switchTo().window(window2rx); 
						if (driver.getTitle().contains("Practitioner")) 
						{ 
							System.out.println(driver.getCurrentUrl());
							driver.switchTo().defaultContent();
							driver.switchTo().frame("close_frame");

							WebElement CloseBTN = driver.findElement(By.name("close"));
							CloseBTN.click();
							Thread.sleep(200);
							System.out.println("Assigning bed process can not be completed with invalid attending practitioner.");
						}
					}break;
				}break;
			}
		}

		return new Object();
	}
}

