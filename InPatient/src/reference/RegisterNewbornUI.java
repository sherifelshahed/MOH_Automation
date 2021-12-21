package reference;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterNewbornUI extends PrepareDischargeAdviceUI{

	public Object OpenRegisterNewbornPage() throws InterruptedException {
		driver.switchTo().frame(1);
		driver.switchTo().frame("menuFr");
		Thread.sleep(500);
		WebElement ReleaseBlockBedPage = driver.findElement(By.id("sd22"));
		ReleaseBlockBedPage.click();
		Thread.sleep(500);
		System.out.println("Nurse is Navigated to Prepare Discharge Advice Page Successfully");
		return new Object();
	}
	
}
