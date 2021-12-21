package reference;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;
@SuppressWarnings("unused")
public class AccessAssignBedPage extends CMOLogin{


	public Object AccessAsignBed() throws InterruptedException {
		driver.switchTo().frame(1);
		driver.switchTo().frame("menuFr");
		Thread.sleep(500);
		WebElement AsignBed = driver.findElement(By.id("sd2"));
		AsignBed.click();
		Thread.sleep(500);

		return new Object();
	}
	public Object SearchWithSpeciality() throws InterruptedException {

		driver.switchTo().defaultContent(); 
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod");

		String cellText = driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]")).getText();
		System.out.println("Text is: "+cellText);
		WebElement Speciality = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/input"));
		Speciality.sendKeys("Cardiology");
		Thread.sleep(500);

		WebElement ConfirmSpeciality = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/input[3]"));
		Thread.sleep(500);
		ConfirmSpeciality.click();
		Thread.sleep(2000);

		/*
		Set<String> windowx = driver.getWindowHandles();
		Iterator<String> it = windowx.iterator();
		String homePage = it.next();
		String systemEM = it.next();

		driver.switchTo().window(systemEM);
		driver.close();
		driver.switchTo().window(homePage);
		driver.get("http://10.209.1.5:7777/HIS/eCommon/jsp/CommonLookup.jsp?title=Specialty");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		//driver.switchTo().frame("lookup_cancel");
		WebElement CancelBTN = driver.findElement(By.xpath("//table/tbody/tr/td/input"));
		CancelBTN.click();
		 */

		String currentWindow = driver.getWindowHandle();
		Set<String> windows1 = driver.getWindowHandles();  
		for (String window1 : windows1) 
		{ 
			driver.switchTo().window(window1); 
			if (driver.getTitle().contains("Specialty")) 
			{ 
				System.out.println("as");
				System.out.println(driver.getCurrentUrl());
				System.out.println(driver.getPageSource());
				driver.switchTo().defaultContent();
				driver.switchTo().frame("lookup_head");
				WebElement SearchTXT = driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]/input"));
				//SearchTXT.clear();
				//SearchTXT.sendKeys("Car");
				WebElement SearchBTN = driver.findElement(By.xpath("//table/tbody/tr[2]/td[5]/input"));
				SearchBTN.click();
				Thread.sleep(500);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("lookup_detail");

				//System.out.println(driver.getPageSource());

				WebElement SpecSelection = driver.findElement(By.xpath("//table[2]/tbody/tr[2]/td[1]"));
				System.out.println(SpecSelection.getText());
				SpecSelection.click();
				Thread.sleep(500);
				driver.switchTo().window(currentWindow);
			}
		}
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod");

		WebElement SearchBTN1= driver.findElement(By.xpath("//table[2]/tbody/tr/td[2]/input"));
		System.out.println(SearchBTN1.getText());
		SearchBTN1.click();
		Thread.sleep(2000); 

		driver.switchTo().defaultContent();
		driver.switchTo().frame("f_query_add_mod1");
		driver.switchTo().frame(3);
		
		WebElement PatientID= driver.findElement(By.xpath("//table[2]/tbody/tr[2]/td[5]"));
		System.out.println(PatientID.getText());
		Thread.sleep(500); 
		

		return new Object();
	}
}
