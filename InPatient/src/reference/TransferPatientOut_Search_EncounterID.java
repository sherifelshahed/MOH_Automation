package reference;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TransferPatientOut_Search_EncounterID extends TransferPatientOutUI{

	public Object SearchWithEncounterID() throws InterruptedException {
		String Encounter_ID = "10000054";
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod");
		
		WebElement EncounterIDTXT = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]/input"));
		EncounterIDTXT.clear();
		EncounterIDTXT.sendKeys(Encounter_ID);
		Thread.sleep(500);
		
		WebElement SearchBTN = driver.findElement(By.xpath("//table[2]/tbody/tr/td[2]/input"));
		SearchBTN.click();
		Thread.sleep(500);
		
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod1");
		
		WebElement ENCID = driver.findElement(By.xpath("//table[2]/tbody/tr[2]/td[3]/a"));
		assertEquals(Encounter_ID, ENCID.getText());
		
		System.out.println("EncounterID is displaying successfully: "+ENCID.getText());
		
		return new Object();
	}
	
}
