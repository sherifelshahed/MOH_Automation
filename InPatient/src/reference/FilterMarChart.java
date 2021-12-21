package reference;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FilterMarChart extends ViewMarChart{

	public Object CheckResult() throws InterruptedException {
	driver.switchTo().defaultContent();
	driver.switchTo().frame("content");
	driver.switchTo().frame("f_query_add_mod");
	driver.switchTo().frame("f_patient_details");
	driver.switchTo().frame("f_bedheader");
	
	WebElement PatientID = driver.findElement(By.id("patient_id_1"));
	System.out.println("The Search Result is Displaying: "+ PatientID.getText());
	PatientID.click();
	Thread.sleep(2000);
	
	return new Object();
	}
}
