package reference;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TransferPatientOut_Search_PatientID extends TransferPatientOutUI{

	public Object SearchWithPatientID() {
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod");
		
		WebElement PatientIDTXT = driver.findElement(By.xpath("//table/tbody/tr[7]/td/table/tbody/tr/td[2]/input"));
		PatientIDTXT.sendKeys("A100000883");
		
		WebElement PatientIDBTN = driver.findElement(By.xpath("//table/tbody/tr[7]/td/table/tbody/tr/td[2]/input[2]"));
		PatientIDBTN.click();
		
		String currentWindow = driver.getWindowHandle();
		Set<String> windows1 = driver.getWindowHandles();  
		for (String window1 : windows1) 
		{ 
			driver.switchTo().window(window1); 
			if (driver.getTitle().contains("Search Patient")) 
			{
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("Pat_Search_Criteria_Frame");
				
				WebElement PatientIDSer = driver.findElement(By.name("Patient_Id"));
				PatientIDSer.sendKeys("A100000883");
				
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("Pat_Search_Toolbar_Frame");
				
				WebElement SearchBTN = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td[5]/input"));
				SearchBTN.click();
				
				driver.switchTo().window(currentWindow);
			}
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod");
		
		WebElement Search = driver.findElement(By.name("search"));
		Search.click();
				
		
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod1");
		
		WebElement PatientIDSel = driver.findElement(By.xpath("//table[2]/tbody/tr[2]/td[4]"));
		assertEquals("A100000883", PatientIDSel.getText());
		
		System.out.println("Search is done successfully for patient: "+PatientIDSel.getText());
		
		return new Object();
	}
	
}
