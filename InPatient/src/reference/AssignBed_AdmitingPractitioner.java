package reference;

import static org.testng.Assert.assertNotEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AssignBed_AdmitingPractitioner extends AssignBed_MarkPatientArrival {

	public Object CheckAdmittingPractitioner() throws InterruptedException {


		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod");

		WebElement NursingUnitTXT = driver.findElement(By.name("nursing_unit_desc"));
		NursingUnitTXT.sendKeys("A2GS");

		WebElement NursingUnitBTN = driver.findElement(By.name("nursing_unit_lookup"));
		NursingUnitBTN.click();

		WebElement PatientID = driver.findElement(By.name("patient_id"));
		PatientID.sendKeys("I700000008");

		WebElement SearchBTN = driver.findElement(By.name("search"));
		SearchBTN.click();
		Thread.sleep(500);

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
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("message");

				WebElement AdmittingPrac = driver.findElement(By.xpath("//table/tbody/tr[7]/td[2]"));
				System.out.println(AdmittingPrac.getText());
				AdmittingPrac.sendKeys("Test");
				assertNotEquals("Test", AdmittingPrac.getText());
				if(AdmittingPrac.getText() != "Test") {
					System.out.println("Admitting Practitioner Field is uneditable");
				}
			}
		}

		return new Object();
	}
}
