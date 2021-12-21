package reference;

import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class RecordStockConsumption extends NUR_BlockBedpageUICheck{

	public Object OpenStockItemConsumptionPage() throws InterruptedException {
		driver.switchTo().frame(1);
		driver.switchTo().frame("menuFr");
		Thread.sleep(500);
		WebElement ReleaseBlockBedPage = driver.findElement(By.id("sd14"));
		ReleaseBlockBedPage.click();
		Thread.sleep(500);
		System.out.println("Nurse is Navigated to Stock Item Consumption Page Successfully");
		
		return new Object();
	}
	
	public Object CreateDOC() throws InterruptedException {
		
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("content");
		driver.switchTo().frame("commontoolbarFrame");
		
		WebElement CreateBTN = driver.findElement(By.xpath("//table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/input"));
		CreateBTN.click();
		
		String currentWindowx = driver.getWindowHandle();
		Set<String> windowsx = driver.getWindowHandles();  
		for (String window1 : windowsx) 
		{ 
			driver.switchTo().window(window1); 
			if (driver.getTitle().contains("Modify Document Details")) 
			{ 
				
				WebElement DocTypeList = driver.findElement(By.xpath("//table/tbody/tr/td/select"));
				DocTypeList.click();
				DocTypeList.sendKeys(Keys.ARROW_DOWN);
				DocTypeList.sendKeys(Keys.TAB);
				
				WebElement OKBTN = driver.findElement(By.xpath("//table/tbody/tr[3]/td[4]/input"));
				OKBTN.click();
				Thread.sleep(500);
				driver.switchTo().window(currentWindowx);
			}
		}
		
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("content");
		driver.switchTo().frame("f_query_add_mod");
		driver.switchTo().frame("frameStockItemConsumptionHeader");
		
		WebElement Remarks = driver.findElement(By.xpath("//table[2]/tbody/tr/td[4]/input[3]"));
		Remarks.click();
		
		String currentWindowy = driver.getWindowHandle();
		Set<String> windowsy = driver.getWindowHandles();  
		for (String windowq : windowsy) 
		{ 
			driver.switchTo().window(windowq); 
			if (driver.getTitle().contains("Remarks")) 
			{ 
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("lookup_head");
				WebElement SearchBTN = driver.findElement(By.xpath("//table/tbody/tr[2]/td[5]/input"));
				SearchBTN.click();
				Thread.sleep(500);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("lookup_detail");
				WebElement Remark = driver.findElement(By.xpath("//table[2]/tbody/tr[2]/td[1]"));
				System.out.println(Remark.getText());
				Remark.click();
				Thread.sleep(500);
				
				driver.switchTo().window(currentWindowy);
			}
		}
		
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("content");
		driver.switchTo().frame("f_query_add_mod");
		driver.switchTo().frame("frameStockItemConsumptionList");
		driver.switchTo().frame("frameStockItemConsumptionListHeader");
		
		WebElement Item = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/input"));
		Item.sendKeys("A-VITON 50000I.U. SOFT GELATIN CAPSULE");
		
		WebElement ItemBTN = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/input[2]"));
		ItemBTN.click();
		Thread.sleep(500);
				
		WebElement Quantity = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]/input"));
		Quantity.sendKeys("1");
		
		WebElement AddBTN = driver.findElement(By.xpath("//table/tbody/tr[7]/td[1]/input[3]"));
		AddBTN.click();
		
		
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("content");
		driver.switchTo().frame("commontoolbarFrame");
		
		WebElement ApplyBTN = driver.findElement(By.xpath("//table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td[2]/input"));
		ApplyBTN.click();
		
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("content");
		driver.switchTo().frame("messageFrame");
		WebElement Message = driver.findElement(By.xpath("/html/body/p"));
		System.out.println(Message.getText());
		assertTrue(Message.getText().contains("Operation Completed Successfully"));
		
		return new Object();
	}
	
	
	
}
