package reference;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class TransferPatientOut_Search_AdmissionDate extends TransferPatientOutUI{

	public Object SearchWithAdmissionDate() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod");

		WebElement AdmissionDateFrom = driver.findElement(By.xpath("//table/tbody/tr[5]/td[4]/input"));
		AdmissionDateFrom.sendKeys("01/11/2021");
		WebElement AdmissionDateTO= driver.findElement(By.xpath("//table/tbody/tr[5]/td[4]/input[2]"));
		AdmissionDateTO.sendKeys("01/12/2021");

		WebElement SearchBTN = driver.findElement(By.xpath("//table[2]/tbody/tr/td[2]/input"));
		SearchBTN.click();
		Thread.sleep(500);

		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("f_query_add_mod1");
		
		for(int i=2 ; i<20; i++) {


			try {
				
				WebElement PatientIDres = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]"));
				WebElement AdmTime = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]"));
				System.out.println(PatientIDres.getText()+" Patient is existing in the result. in: "+AdmTime.getText());
		
			} catch (NoSuchElementException e) {

			}

		}



		return new Object();
	}
}
