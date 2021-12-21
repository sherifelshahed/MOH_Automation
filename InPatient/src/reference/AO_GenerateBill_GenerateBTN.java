package reference;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AO_GenerateBill_GenerateBTN extends AO_BillGeneration_Open_Search{

	public Object GenerateBill() throws InterruptedException {
		
		Set<String> windows1 = driver.getWindowHandles();  
		for (String window1 : windows1) 
		{ 
			driver.switchTo().window(window1); 
			if (driver.getTitle().contains("Bill Generation")) 
			{
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("BillReceiptInfo");
				
				WebElement GenerateBillBTN = driver.findElement(By.name("compute"));
				GenerateBillBTN.click();
				System.out.println("Generate button is Working.");
				Thread.sleep(3000);
				org.openqa.selenium.Alert alert = driver.switchTo().alert();
				String alertMessage= driver.switchTo().alert().getText();
				System.out.println(alertMessage);
				Thread.sleep(1000);
				alert.accept();
			}
		}

		
		return new Object();
	}
	
	
}
