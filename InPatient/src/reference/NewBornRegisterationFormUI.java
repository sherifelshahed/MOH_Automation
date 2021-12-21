package reference;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class NewBornRegisterationFormUI extends RegisterNewbornUI{

	public Object OpenMotherBabyLink(String Patient_ID) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod");

		WebElement PatientID = driver.findElement(By.xpath("//table/tbody/tr[4]/td/table/tbody/tr/td"));
		System.out.println("Patinet ID is Existing with Title: "+PatientID.getText());
		WebElement PatientIDTXT = driver.findElement(By.xpath("//table/tbody/tr[4]/td/table/tbody/tr/td[2]/input"));
		PatientIDTXT.sendKeys(Patient_ID);

		WebElement SearchBTN = driver.findElement(By.xpath("//table[2]/tbody/tr/td[2]/input"));
		System.out.println("Search button is existing with title:  "+SearchBTN.getAttribute("value"));
		SearchBTN.click();
		Thread.sleep(1000);


		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod1");
		Thread.sleep(2000);
		WebElement PatientIDHL = driver.findElement(By.xpath("//table[2]/tbody/tr[2]/td[4]/a"));
		System.out.println(PatientIDHL.getText());
		PatientIDHL.click();
		Thread.sleep(3000);

		return new Object();
	}

	public Object RegisterBaby(String Pat_ID) throws InterruptedException {

		String currentWindow = driver.getWindowHandle();
		Set<String> windows1 = driver.getWindowHandles();  
		for (String window1 : windows1) 
		{ 
			driver.switchTo().window(window1); 
			if (driver.getTitle().contains("Mother Baby Link")) 
			{ 

				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("babylink1_frame");
				Thread.sleep(1000);
				WebElement PatID = driver.findElement(By.xpath("//table/tbody/tr/td[2]/span[4]"));
				assertEquals(Pat_ID,  PatID.getText() );

				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("babylink3_frame");
				Thread.sleep(1000);
				WebElement RegisterBTN = driver.findElement(By.xpath("//table/tbody/tr/td[2]/input"));
				RegisterBTN.click();
				Thread.sleep(6000);
				driver.switchTo().window(currentWindow);
			}


			Set<String> windowsx = driver.getWindowHandles();  
			for (String window2 : windowsx) 
			{ 
				driver.switchTo().window(window2); 
				Thread.sleep(1000);
				if (driver.getTitle().contains("Register New Born")) 
				{ 
					System.out.println(driver.getCurrentUrl());
					driver.switchTo().parentFrame();
					driver.switchTo().defaultContent();
					driver.switchTo().frame("f_query_add_mod");
					driver.switchTo().frame("newbornmain_frame");
					Thread.sleep(3000);
					WebElement Gestation_1 = driver.findElement(By.xpath("//table/tbody/tr[2]/td/div/table/tbody/tr[6]/td[2]/input[2]"));
					Gestation_1.sendKeys("30");
					Gestation_1.sendKeys(Keys.TAB);
					
					WebElement Gestation_2 = driver.findElement(By.xpath("//table/tbody/tr[2]/td/div/table/tbody/tr[6]/td[2]/input[3]"));
					Gestation_2.sendKeys("4");

					WebElement deliveryType = driver.findElement(By.xpath("//table/tbody/tr[2]/td/div/table/tbody/tr[6]/td[4]/select"));
					deliveryType.click();
					deliveryType.sendKeys(Keys.ARROW_DOWN);
					deliveryType.sendKeys(Keys.TAB);

					WebElement Gravida = driver.findElement(By.xpath("//table/tbody/tr[2]/td/div/table/tbody/tr[7]/td[2]/input"));
					Gravida.sendKeys("3");

					WebElement Parity = driver.findElement(By.xpath("//table/tbody/tr[2]/td/div/table/tbody/tr[7]/td[4]/input"));
					Parity.sendKeys("3");

					WebElement AttPractitioner = driver.findElement(By.xpath("//table/tbody/tr[2]/td/div/table/tbody/tr[8]/td[2]/input"));
					AttPractitioner.sendKeys("AHMEDSHERIF");

					WebElement AttPractitionerBTN = driver.findElement(By.xpath("//table/tbody/tr[2]/td/div/table/tbody/tr[8]/td[2]/input[2]"));
					AttPractitionerBTN.click();

					driver.switchTo().parentFrame();
					driver.switchTo().defaultContent();
					driver.switchTo().frame("f_query_add_mod");
					driver.switchTo().frame("newbornmain_frame");

					WebElement Gender = driver.findElement(By.xpath("//div/div[2]/table/tbody/tr[3]/td[2]/select"));
					Gender.click();
					Gender.sendKeys(Keys.ARROW_DOWN);
					Gender.sendKeys(Keys.TAB);

					WebElement BirthTime = driver.findElement(By.xpath("//div/div[2]/table/tbody/tr[3]/td[4]/input[2]"));
					BirthTime.sendKeys("09:00");

					WebElement BirthWeight = driver.findElement(By.xpath("//div/div[2]/table/tbody/tr[9]/td[2]/input[2]"));
					BirthWeight.sendKeys("6");

					WebElement UmbilicalCordCutTXT = driver.findElement(By.xpath("//div/div[2]/table/tbody[3]/tr/td[4]/input[2]"));
					UmbilicalCordCutTXT.sendKeys("AHMEDSHERIF");

					WebElement UmbilicalCordCutBTN = driver.findElement(By.xpath("//div/div[2]/table/tbody[3]/tr//td[4]/font/input"));
					UmbilicalCordCutBTN.click();
					
					///

					WebElement ApgarScore = driver.findElement(By.xpath("//div/div[2]/table/tbody/tr[11]/td/span/input"));
					ApgarScore.click();

					WebElement Activity = driver.findElement(By.xpath("//div/div[2]/table/tbody[2]/tr/td[2]/select"));
					Activity.click();
					Activity.sendKeys(Keys.ARROW_DOWN);
					Activity.sendKeys(Keys.ARROW_DOWN);
					Activity.sendKeys(Keys.ARROW_DOWN);
					Activity.sendKeys(Keys.TAB);

					WebElement Pulse = driver.findElement(By.xpath("//div/div[2]/table/tbody[2]/tr[2]/td[2]/select"));
					Pulse.click();
					Pulse.sendKeys(Keys.ARROW_DOWN);
					Pulse.sendKeys(Keys.ARROW_DOWN);
					Pulse.sendKeys(Keys.ARROW_DOWN);
					Pulse.sendKeys(Keys.TAB);

					WebElement Grimace = driver.findElement(By.xpath("//div/div[2]/table/tbody[2]/tr[3]/td[2]/select"));
					Grimace.click();
					Grimace.sendKeys(Keys.ARROW_DOWN);
					Grimace.sendKeys(Keys.ARROW_DOWN);
					Grimace.sendKeys(Keys.TAB);

					WebElement Appearance = driver.findElement(By.xpath("//div/div[2]/table/tbody[2]/tr[4]/td[2]/select"));
					Appearance.click();
					Appearance.sendKeys(Keys.ARROW_DOWN);
					Appearance.sendKeys(Keys.ARROW_DOWN);
					Appearance.sendKeys(Keys.TAB);

					WebElement Respiration = driver.findElement(By.xpath("//div/div[2]/table/tbody[2]/tr[5]/td[2]/select"));
					Respiration.click();
					Respiration.sendKeys(Keys.ARROW_DOWN);
					Respiration.sendKeys(Keys.ARROW_DOWN);
					Respiration.sendKeys(Keys.TAB);

					ApgarScore.click();
					Thread.sleep(1000);
					
					
					driver.switchTo().parentFrame();
					driver.switchTo().defaultContent();
					driver.switchTo().frame("f_query_add_mod");
					driver.switchTo().frame("newbornheader_frame");

					WebElement PatientSeries = driver.findElement(By.xpath("//table/tbody/tr/td[2]/select"));
					PatientSeries.click();
					PatientSeries.sendKeys(Keys.ARROW_DOWN);
					PatientSeries.sendKeys(Keys.TAB);

					WebElement RegBTN = driver.findElement(By.xpath("//table/tbody/tr/td[5]/input"));
					RegBTN.click();
					Thread.sleep(1000);
					
					org.openqa.selenium.Alert alert = driver.switchTo().alert();
					String alertMessage= driver.switchTo().alert().getText();
					System.out.println(alertMessage);
					Thread.sleep(1000);
					alert.accept();
					

				}
			}
		}
		return new Object();
	}


}
