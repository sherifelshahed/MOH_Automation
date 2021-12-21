package reference;

import static org.testng.Assert.assertEquals;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class PrepareDischargeAdvice extends PrepareDischargeAdviceUI{

	public Object SearchForPatient() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod");

		WebElement PatientID = driver.findElement(By.xpath("//table/tbody/tr[4]/td/table/tbody/tr/td"));
		System.out.println("Patinet ID is Existing with Title: "+PatientID.getText());
		WebElement PatientIDTXT = driver.findElement(By.xpath("//table/tbody/tr[4]/td/table/tbody/tr/td[2]/input"));
		PatientIDTXT.sendKeys("A200000498");
		assertEquals("Patient ID", PatientID.getText());


		WebElement SearchBTN = driver.findElement(By.xpath("//table[2]/tbody/tr/td[2]/input"));
		System.out.println("Search button is existing with title:  "+SearchBTN.getAttribute("value"));
		SearchBTN.click();
		Thread.sleep(1000);

		return new Object();
	}

	public Object OpenPatientDiscargeAdvice() throws InterruptedException {

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

	public Object PrepareAdvice() throws InterruptedException {

		Set<String> windows1 = driver.getWindowHandles();  
		for (String window1 : windows1) 
		{ 
			driver.switchTo().window(window1); 
			if (driver.getTitle().contains("Prepare Discharge Advice")) 
			{ 
				
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("f_query_add_mod");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				WebElement AuthorizationPractitionerBTN = driver.findElement(By.xpath("//table/tbody/tr/td[2]/input[2]"));
				AuthorizationPractitionerBTN.click();
				Thread.sleep(1000);
				
				WebElement DischargeDate = driver.findElement(By.xpath("//table/tbody/tr/td[4]/input"));
				DischargeDate.sendKeys("31/12/2021 14:10");
				
				WebElement DischargeType = driver.findElement(By.xpath("//table[2]/tbody/tr/td[2]/select"));
				DischargeType.click();
				DischargeType.sendKeys(Keys.ARROW_DOWN);
				DischargeType.sendKeys(Keys.TAB);
				
				WebElement DischargeStatus = driver.findElement(By.xpath("//table[2]/tbody/tr/td[4]/select"));
				DischargeStatus.click();
				DischargeStatus.sendKeys(Keys.ARROW_DOWN);
				DischargeStatus.sendKeys(Keys.TAB);
				
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("f_query_add_mod_button");
				
				WebElement RecordBTN = driver.findElement(By.xpath("//table/tbody/tr/td[2]/input"));
				RecordBTN.click();
				
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
