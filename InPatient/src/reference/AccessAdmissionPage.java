package reference;
import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccessAdmissionPage extends CMOLogin{

	public Object AccessAdmitPage() throws InterruptedException, AWTException {

		driver.switchTo().frame(1);
		driver.switchTo().frame("menuFr");
		Thread.sleep(500);
		WebElement CancelPatient = driver.findElement(By.id("sd1"));
		CancelPatient.click();
		Thread.sleep(2000);
		return new Object();
	}
}
