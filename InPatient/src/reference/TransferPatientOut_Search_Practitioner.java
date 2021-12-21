package reference;

import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TransferPatientOut_Search_Practitioner extends TransferPatientOutUI{

	public Object SearchWithPractitioner() throws InterruptedException {
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod");
		
		WebElement PractitionerBTN = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]/input[3]"));
		PractitionerBTN.click();
		
		String currentWindow = driver.getWindowHandle();
		Set<String> windows1 = driver.getWindowHandles();  
		for (String window1 : windows1) 
		{ 
			driver.switchTo().window(window1); 
			if (driver.getTitle().contains("Practitioner")) 
			{ 

				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("result_frame");
				
				for(int i=2 ; i<16; i++) {
					WebElement PracSel = driver.findElement(By.xpath("//table[2]/tbody/tr["+i+"]/td[3]/a"));
					System.out.println("Practitioner "+PracSel.getText()+" is existing. ");
				}
				
				WebElement PractitionerSel = driver.findElement(By.xpath("//table[2]/tbody/tr[6]/td[3]/a"));
				PractitionerSel.click();
				driver.switchTo().window(currentWindow);
			}
		}
				
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod");
		
		WebElement SearchBTN = driver.findElement(By.xpath("//table[2]/tbody/tr/td[2]/input"));
		SearchBTN.click();
		Thread.sleep(500);
		
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod1");
		
		WebElement PatientID = driver.findElement(By.xpath("//table[2]/tbody/tr[2]/td[4]"));
		System.out.println("Search result is existing: "+PatientID.getText());
		
		assertTrue(PatientID.isDisplayed());
		
		
		return new Object();
	}
	
}
