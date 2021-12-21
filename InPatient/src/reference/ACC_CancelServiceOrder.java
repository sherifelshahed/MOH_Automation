package reference;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ACC_CancelServiceOrder extends ACC_AddSeparateService{

	
public Object CancelOrder() throws InterruptedException {
		
		
		Set<String> windows1 = driver.getWindowHandles();
		for (String window1 : windows1) 
		{ 
			driver.switchTo().window(window1); 
			if (driver.getTitle().contains("Charge Patient")) 
			{
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("BLChargePatientEncounterTab");
				
				System.out.println(driver.getCurrentUrl());
				WebElement ExistingOrder = driver.findElement(By.id("ExistingOrder"));
				ExistingOrder.click();
				
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("BLChargePatientEncounterTabPage");
				
				WebElement SearchBTN = driver.findElement(By.name("add_mod"));
				SearchBTN.click();
				
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("BLChargePatientExisOrderServDetails");
				
				WebElement GRPCode = driver.findElement(By.id("serv_grp_code0"));
				GRPCode.click();
				
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("BLChargePatientExisOrderServEdit");
				
				
				WebElement DocRefNo = driver.findElement(By.id("chk_blng_serv0"));
				DocRefNo.click();
				
				WebElement Cancel = driver.findElement(By.id("cancelAll"));
				Cancel.click();
				
				Thread.sleep(1000);
				
				org.openqa.selenium.Alert alert = driver.switchTo().alert();
				Thread.sleep(1000);
				alert.accept();
				Thread.sleep(2000);
				
				String currentWindow = driver.getWindowHandle();
				Set<String> windowsc = driver.getWindowHandles();
				for (String windowc : windowsc) 
				{ 
					driver.switchTo().window(windowc); 
					if (driver.getTitle().contains("Error / Warnings")) 
					{
						
						WebElement Close = driver.findElement(By.id("btnClose"));
						Close.click();
						
						Thread.sleep(500);
						driver.switchTo().window(currentWindow);
						Thread.sleep(1000);
						
					}
				}
				
				Thread.sleep(3000);
				org.openqa.selenium.Alert alert1 = driver.switchTo().alert();
				String alertMessage1= driver.switchTo().alert().getText();
				System.out.println(alertMessage1);
				Thread.sleep(1000);
				alert1.accept();
				Thread.sleep(2000);
				
			}
		}
		
		
		return new Object();
}
}
