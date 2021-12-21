package reference;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class RecievePatientFromAnotherNursingUnit extends NUR_BlockBedpageUICheck{

	public Object OpenTransferPatientInPage() throws InterruptedException {
		driver.switchTo().frame(1);
		driver.switchTo().frame("menuFr");
		Thread.sleep(500);
		WebElement AsignBed = driver.findElement(By.id("sd5"));
		AsignBed.click();
		Thread.sleep(500);
		System.out.println("Nurse is Navigated to Transfer Patient In Page Successfully");
		return new Object();
	}

	public Object SearchForPatient() {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod");

		WebElement PatientID = driver.findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr/td[2]/input"));
		PatientID.sendKeys("A200000382");

		WebElement SearchBTN = driver.findElement(By.xpath("//table[2]/tbody/tr/td[2]/input"));
		SearchBTN.click();

		return new Object();
	}

	public Object OpenTransferForm() throws InterruptedException {

		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod1");
		Thread.sleep(2000);
		WebElement PatientEncID = driver.findElement(By.xpath("//table[2]/tbody/tr[2]/td[3]/a"));
		System.out.println(PatientEncID.getText());
		PatientEncID.click();
		return new Object();
	}

	public Object TransferPatient() throws InterruptedException {

		Set<String> windows1 = driver.getWindowHandles();  
		for (String window1 : windows1) 
		{ 
			driver.switchTo().window(window1); 
			if (driver.getTitle().contains("Transfer Patient In")) 
			{ 
				System.out.println(driver.getCurrentUrl());
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("Transfer_in");


				WebElement TransferInStatus = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]/select"));
				TransferInStatus.click();
				TransferInStatus.sendKeys(Keys.ARROW_DOWN);
				TransferInStatus.sendKeys(Keys.TAB);

				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("Transfer_frame");

				WebElement NursingUnitTXT = driver.findElement(By.xpath("//table/tbody/tr[3]/td[4]/input"));
				try {
					NursingUnitTXT.clear();
				} catch (InvalidElementStateException e) {
					Thread.sleep(500);
					NursingUnitTXT.sendKeys("A2OR");
				}

				WebElement NursingUnit = driver.findElement(By.xpath("//table/tbody/tr[3]/td[4]/input[2]"));
				NursingUnit.click();
				Thread.sleep(500);

				WebElement Service = driver.findElement(By.xpath("//table/tbody/tr[4]/td[4]/select"));
				Service.click();
				Service.sendKeys(Keys.ARROW_DOWN);
				Service.sendKeys(Keys.TAB);

				WebElement BedNo = driver.findElement(By.xpath("//table/tbody/tr[8]/td[4]/input[2]"));
				BedNo.click();

				String currentWindow = driver.getWindowHandle();
				Set<String> windowsx = driver.getWindowHandles();  
				for (String windowz : windowsx) 
				{ 
					driver.switchTo().window(windowz); 
					if (driver.getTitle().contains("Bed Availability Chart")) 
					{ 

					//	driver.switchTo().parentFrame();
						driver.switchTo().defaultContent();
						driver.switchTo().frame("result");

						Thread.sleep(2000);
						WebElement Bednumber = driver.findElement(By.xpath("//input[@class = 'IP_GreenButton']"));
						Bednumber.click();
						Thread.sleep(500);
						Bednumber.click();
						Thread.sleep(3000);
				
						driver.switchTo().window(currentWindow);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("Transfer_frame");
					}
				}

				WebElement Speciality = driver.findElement(By.xpath("//table/tbody/tr[10]/td[4]/input"));
				Speciality.sendKeys("Gen Surg Splty");
				
				WebElement Practitioner = driver.findElement(By.xpath("//table/tbody/tr[11]/td[4]/input[2]"));
				Practitioner.sendKeys("Khaled Ali elZend");
				
	
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("Button_frame");

				WebElement RecordBTN = driver.findElement(By.xpath("//table/tbody/tr/td/input"));
				RecordBTN.click();
				Thread.sleep(2000);
				org.openqa.selenium.Alert alert = driver.switchTo().alert();
				String alertMessage= driver.switchTo().alert().getText();
				System.out.println(alertMessage);
				Thread.sleep(2000);
				alert.accept();

			}
		}

		return new Object();
	}
}
