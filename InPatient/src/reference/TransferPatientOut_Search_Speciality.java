package reference;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TransferPatientOut_Search_Speciality extends TransferPatientOutUI{

	public Object SearchWithSpeciality() throws InterruptedException {
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod");
		
		WebElement Speciality = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]/input[3]"));
		Speciality.click();
		
		String currentWindow = driver.getWindowHandle();
		Set<String> windows1 = driver.getWindowHandles();  
		for (String window1 : windows1) 
		{ 
			driver.switchTo().window(window1); 
			if (driver.getTitle().contains("Specialty")) 
			{
				
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("lookup_head");
				
				WebElement SearchBTN = driver.findElement(By.xpath("//table/tbody/tr[2]/td[5]/input"));
				SearchBTN.click();
				Thread.sleep(500);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("lookup_detail");

				for(int i=2 ; i<16; i++) {
					
					WebElement SpecSelection = driver.findElement(By.xpath("//table[2]/tbody/tr["+i+"]/td[1]"));
					System.out.println(SpecSelection.getText()+" Speciality is existing.");
				}
				
				WebElement Spec = driver.findElement(By.xpath("//table[2]/tbody/tr[2]/td[1]"));
				Spec.click();
				driver.switchTo().window(currentWindow);
				
			}
		}
		
		System.out.println("Specialities are Displayed Successfully.");
		
		return new Object();
	}
	
}
