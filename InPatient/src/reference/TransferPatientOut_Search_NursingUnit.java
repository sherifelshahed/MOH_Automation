package reference;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TransferPatientOut_Search_NursingUnit extends TransferPatientOutUI{

	public Object SearchWithNursingUnit() {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod");

		WebElement NursingUnitTXT = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/input"));

		WebElement NursingUnitBTN = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/input[3]"));
		NursingUnitBTN.click();

		String currentWindow = driver.getWindowHandle();
		Set<String> windows1 = driver.getWindowHandles();  
		for (String window1 : windows1) 
		{ 
			driver.switchTo().window(window1); 
			if (driver.getTitle().contains("Nursing Unit")) 
			{

				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("result_frame");


				for(int i=2 ; i<7; i++) {
					WebElement List = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]"));
					System.out.println("Nursing Unit "+List.getText()+" is existing. ");
				}
				
				WebElement Unit = driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]"));
				Unit.click();
				driver.switchTo().window(currentWindow);
			}
		}
		
		
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod");
		
		System.out.println(NursingUnitTXT.getAttribute("value"));
		WebElement SearchBTN = driver.findElement(By.xpath("//table[2]/tbody/tr/td[2]/input"));
		SearchBTN.click();
		
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod1");
		
		WebElement ENCID = driver.findElement(By.xpath("//table[2]/thead/tr[2]/th[3]"));
		
		assertEquals("Encounter ID ", ENCID.getText());
		
		System.out.println("Search result is displaying successfully");
		
		return new Object();
	}


}
