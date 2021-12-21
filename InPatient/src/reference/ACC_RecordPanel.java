package reference;

import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ACC_RecordPanel extends ACC_AddSeparateService{
	
	public Object RecordPanel() throws InterruptedException {
		
		Set<String> windows1 = driver.getWindowHandles();
		for (String window1 : windows1) 
		{ 
			driver.switchTo().window(window1); 
			if (driver.getTitle().contains("Charge Patient")) 
			{
				
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("BLChargePatientEncounterTab");
				Thread.sleep(1000);
				WebElement NewOrder = driver.findElement(By.id("NewOrder"));
				NewOrder.click();
				
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("BLChargePatientEncounterTabPage");
				
				WebElement PanelBox = driver.findElement(By.id("serviceOrPanel"));
				PanelBox.click();
				
				WebElement SearchBTN = driver.findElement(By.name("add_mod"));
				SearchBTN.click();
				
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("BLChargePatientExisOrderTraverse");
				
				WebElement ServiceCode = driver.findElement(By.id("servCode_1"));
				ServiceCode.click();
				System.out.println("Service "+driver.findElement(By.xpath("//table/tbody/tr/td[2]"))+" is Selected.");
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("BLChargePatientExisOrderServDetails");
				
				WebElement RecordBTN = driver.findElement(By.xpath("//table/tbody/tr[2]/td/input"));
				RecordBTN.click();
				
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("messageFrame");
				WebElement SuccessMSG = driver.findElement(By.xpath("/html/body/p"));
				System.out.println(SuccessMSG.getText());
				assertTrue(SuccessMSG.getText().contains("Operation Completed Successfully"));
	
				
			}
		}
		
		return new Object();
	}
	
}
