package reference;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TransferStock_Facilities_PHAR extends PharmacistLogin{

	public Object LoginMan() throws InterruptedException {


		WebElement un = driver.findElement(By.name("name")); 
		un.sendKeys("PCYIPD01");
		WebElement pw = driver.findElement(By.name("password"));
		pw.sendKeys("egy123");
		WebElement loginBTN = driver.findElement(By.id("loginID"));
		loginBTN.click();

		WebElement Responsibility = driver.findElement(By.xpath("//table/tbody/tr[2]/td/table/tbody/tr[4]/td/span/div/input"));
		Responsibility.click();
		Responsibility.sendKeys(Keys.ARROW_DOWN);
		Responsibility.sendKeys(Keys.ARROW_DOWN);
		Responsibility.sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		///WebElement loginBTnN = driver.findElement(By.id("loginID"));
		//loginBTnN.click();
		driver.manage().window().maximize();
		Thread.sleep(200);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String homePage = it.next();
		String systemEM = it.next();

		driver.switchTo().window(systemEM);
		driver.close();
		driver.switchTo().window(homePage);
		driver.get("http://10.209.1.5:7777/HIS/eCommon/jsp/eHIS.jsp");


		return new Object();
	}

	public Object OpenSTtransaction() throws InterruptedException {

		driver.switchTo().frame(1);
		driver.switchTo().frame("menuFr");
		Thread.sleep(500);
		WebElement DispenseMed = driver.findElement(By.id("jd37"));
		DispenseMed.click();
		Thread.sleep(500);
		WebElement Issue = driver.findElement(By.id("jd43"));
		Issue.click();
		Thread.sleep(500);
		WebElement Create_ReviewReq = driver.findElement(By.id("sd45"));
		Create_ReviewReq.click();


		Thread.sleep(2000);

		return new Object();
	}

	public Object TransferStock() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame("content");
		driver.switchTo().frame("commontoolbarFrame");

		WebElement CreateBTN = driver.findElement(By.name("create"));
		CreateBTN.click();

		String currentWindow = driver.getWindowHandle();
		Set<String> windows1 = driver.getWindowHandles();  
		for (String window1 : windows1) 
		{ 
			driver.switchTo().window(window1); 
			if (driver.getTitle().contains("Modify Document Details")) 
			{
				System.out.println(driver.getCurrentUrl());

				WebElement ToStore = driver.findElement(By.name("to_store_code"));
				ToStore.click();
				ToStore.sendKeys(Keys.ARROW_DOWN);
				ToStore.sendKeys(Keys.TAB);

				WebElement OKBTN = driver.findElement(By.name("record"));
				OKBTN.click();

				driver.switchTo().window(currentWindow);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("content");
				driver.switchTo().frame("f_query_add_mod");
				driver.switchTo().frame("RequestDetailFrame");

				WebElement ItemTXT = driver.findElement(By.name("item_desc"));
				ItemTXT.sendKeys("RIFAMPIN 300MG HARD GELATIN CAPSULES");
				WebElement ItemBTN = driver.findElement(By.xpath("//table/tbody/tr/td/input[3]"));
				ItemBTN.click();
				Thread.sleep(5000);

				WebElement REQQty = driver.findElement(By.name("req_uom_qty"));
				REQQty.sendKeys("10");

				WebElement ADDBTN = driver.findElement(By.name("add"));
				ADDBTN.click();
				Thread.sleep(2000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("content");
				driver.switchTo().frame("commontoolbarFrame");

				WebElement ApplyBTN = driver.findElement(By.name("apply"));
				ApplyBTN.click();
				Thread.sleep(2000);

				String currentWindowz = driver.getWindowHandle();
				Set<String> windows1z = driver.getWindowHandles();  
				for (String window1z : windows1z) 
				{ 
					driver.switchTo().window(window1z); 
					if (driver.getTitle().contains("Current Pending Request")) 
					{
						System.out.println(driver.getCurrentUrl());

						WebElement ContinueBTN = driver.findElement(By.name("continue"));
						ContinueBTN.click();

						driver.switchTo().window(currentWindowz);

						String currentWindowx = driver.getWindowHandle();
						Set<String> windows1x = driver.getWindowHandles();  
						for (String window1x : windows1x) 
						{ 
							driver.switchTo().window(window1x); 
							if (driver.getTitle().contains("Confirm Authorize")) 
							{
								System.out.println(driver.getCurrentUrl());

								WebElement YesBTN = driver.findElement(By.name("yes"));
								YesBTN.click();
								Thread.sleep(5000);
								driver.switchTo().window(currentWindowx);

								Set<String> windows1xy = driver.getWindowHandles();  
								for (String window1xy : windows1xy) 
								{ 
									Thread.sleep(1000);
									driver.switchTo().window(window1xy); 
									if (driver.getTitle().contains("Confirm Printing")) 
									{
										System.out.println(driver.getCurrentUrl());

										WebElement NoBTN = driver.findElement(By.name("no"));
										NoBTN.click();
										Thread.sleep(2000);

										driver.switchTo().window(currentWindowx);
										driver.switchTo().parentFrame();
										driver.switchTo().defaultContent(); 
										driver.switchTo().frame("content");
										driver.switchTo().frame("messageFrame");
										WebElement Message = driver.findElement(By.xpath("/html/body/p"));
										System.out.println(Message.getText());
										assertTrue(Message.getText().contains("Operation Completed Successfully"));


									}
								}
							}
						}

					}
				}


				driver.switchTo().window(currentWindow);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("content");
				driver.switchTo().frame("commontoolbarFrame");

				WebElement MenuBTN = driver.findElement(By.name("home"));
				MenuBTN.click();
				Thread.sleep(1000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame(1);
				driver.switchTo().frame("menuFr");
				//				Thread.sleep(500);
				//				WebElement DispenseMed = driver.findElement(By.id("jd37"));
				//				DispenseMed.click();
				//				Thread.sleep(500);
				//				WebElement Issue = driver.findElement(By.id("jd43"));
				//				Issue.click();
				Thread.sleep(500);
				WebElement Authorize = driver.findElement(By.id("sd47"));
				Authorize.click();
				Thread.sleep(2000);
			}
		}

		return new Object();
	}

	public Object Transfer_Item () throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame("content");
		driver.switchTo().frame("commontoolbarFrame");

		WebElement QueryBTN = driver.findElement(By.name("query"));
		QueryBTN.click();

		String currentWindoww = driver.getWindowHandle();
		Set<String> windows1w = driver.getWindowHandles();  
		for (String window1w : windows1w) 
		{ 
			driver.switchTo().window(window1w); 
			if (driver.getTitle().contains("Documents for Authorize")) 
			{
				System.out.println(driver.getCurrentUrl());

				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("RIAuthorizeQueryResultFrame");

				WebElement DOC = driver.findElement(By.xpath("//table[2]/tbody/tr[14]/td[2]/font"));
				DOC.click();

				driver.switchTo().window(currentWindoww);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("content");
				driver.switchTo().frame("f_query_add_mod");
				driver.switchTo().frame("AuthorizeAtIssueStoreListFrame");

				WebElement ItemHLink = driver.findElement(By.xpath("//table[2]/tbody/tr[2]/td[2]/font"));
				ItemHLink.click();

				driver.switchTo().defaultContent();
				driver.switchTo().frame("content");
				driver.switchTo().frame("commontoolbarFrame");

				WebElement ApplyBTN = driver.findElement(By.name("apply"));
				ApplyBTN.click();

				String currentWindown = driver.getWindowHandle();
				Set<String> windows1n = driver.getWindowHandles();  
				for (String window1n : windows1n) 
				{ 
					driver.switchTo().window(window1n); 
					if (driver.getTitle().contains("Current Pending Request")) 
					{
						System.out.println(driver.getCurrentUrl());

						WebElement ContinueBTN = driver.findElement(By.name("continue"));
						ContinueBTN.click();

						driver.switchTo().window(currentWindown);
						driver.switchTo().parentFrame();
						driver.switchTo().defaultContent(); 
						driver.switchTo().frame("content");
						driver.switchTo().frame("messageFrame");
						WebElement Message = driver.findElement(By.xpath("/html/body/p"));
						System.out.println(Message.getText());
						assertTrue(Message.getText().contains("Operation Completed Successfully"));

					}
				}

				driver.switchTo().defaultContent();
				driver.switchTo().frame("content");
				driver.switchTo().frame("commontoolbarFrame");

				WebElement MenuBTN = driver.findElement(By.name("home"));
				MenuBTN.click();
				Thread.sleep(1000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame(1);
				driver.switchTo().frame("menuFr");

				Thread.sleep(500);
				WebElement Issue = driver.findElement(By.id("sd48"));
				Issue.click();
				Thread.sleep(2000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("content");
				driver.switchTo().frame("commontoolbarFrame");

				WebElement QueryBTN1 = driver.findElement(By.name("query"));
				QueryBTN1.click();

				Thread.sleep(2000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("content");
				driver.switchTo().frame("f_query_add_mod");
				driver.switchTo().frame("IssueQueryResult");

				WebElement DocTypeHyp = driver.findElement(By.xpath("//table[2]/tbody/tr[3]/td/font"));
				DocTypeHyp.click();

				Thread.sleep(1000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("content");
				driver.switchTo().frame("f_query_add_mod");
				driver.switchTo().frame("frameIssueDetail");

				WebElement HyperItem = driver.findElement(By.xpath("//table[2]/tbody/tr[2]/td[3]/font/a"));
				HyperItem.click();

				driver.switchTo().defaultContent();
				driver.switchTo().frame("content");
				driver.switchTo().frame("commontoolbarFrame");

				WebElement ApplyBn = driver.findElement(By.name("apply"));
				ApplyBn.click();


				String currentWindowx = driver.getWindowHandle();
				Set<String> windows1x = driver.getWindowHandles();  
				for (String window1x : windows1x) 
				{ 
					driver.switchTo().window(window1x); 
					if (driver.getTitle().contains("Confirm Finalize")) 
					{
						System.out.println(driver.getCurrentUrl());

						WebElement YesBTN = driver.findElement(By.name("yes"));
						YesBTN.click();
						Thread.sleep(5000);
						driver.switchTo().window(currentWindowx);

						Set<String> windows1xy = driver.getWindowHandles();  
						for (String window1xy : windows1xy) 
						{ 
							Thread.sleep(1000);
							driver.switchTo().window(window1xy); 
							if (driver.getTitle().contains("Confirm Printing")) 
							{
								System.out.println(driver.getCurrentUrl());

								WebElement NoBTN = driver.findElement(By.name("no"));
								NoBTN.click();
								Thread.sleep(2000);

								driver.switchTo().window(currentWindowx);
								driver.switchTo().parentFrame();
								driver.switchTo().defaultContent(); 
								driver.switchTo().frame("content");
								driver.switchTo().frame("messageFrame");
								WebElement Message = driver.findElement(By.xpath("/html/body/p"));
								System.out.println(Message.getText());
								assertTrue(Message.getText().contains("Operation Completed Successfully"));

							}}
					}}

				driver.switchTo().defaultContent();
				driver.switchTo().frame("content");
				driver.switchTo().frame("commontoolbarFrame");

				WebElement MenuBTNn = driver.findElement(By.name("home"));
				MenuBTNn.click();
				Thread.sleep(1000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame(1);
				driver.switchTo().frame("menuFr");

				Thread.sleep(1000);
				WebElement Acknowledge = driver.findElement(By.id("jd68"));
				Acknowledge.click();
				Thread.sleep(500);
				WebElement AcknowledgeBTN = driver.findElement(By.id("sd69"));
				AcknowledgeBTN.click();


				Thread.sleep(2000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("content");
				driver.switchTo().frame("commontoolbarFrame");

				WebElement CreateBn = driver.findElement(By.name("create"));
				CreateBn.click();

				driver.switchTo().defaultContent();
				driver.switchTo().frame("content");
				driver.switchTo().frame("f_query_add_mod");
				driver.switchTo().frame("frameAcknowledgeHeader");



				WebElement Store = driver.findElement(By.name("store_code"));
				Store.click();
				Store.sendKeys(Keys.ARROW_DOWN);
				Store.sendKeys(Keys.TAB);


				WebElement DocType = driver.findElement(By.name("doc_type_code"));
				DocType.click();
				DocType.sendKeys(Keys.ARROW_DOWN);
				DocType.sendKeys(Keys.ARROW_DOWN);
				DocType.sendKeys(Keys.ARROW_DOWN);
				DocType.sendKeys(Keys.ARROW_DOWN);
				DocType.sendKeys(Keys.ARROW_DOWN);
				DocType.sendKeys(Keys.ARROW_DOWN);
				DocType.sendKeys(Keys.ARROW_DOWN);
				DocType.sendKeys(Keys.TAB);

				WebElement SrchBTN = driver.findElement(By.name("search"));
				SrchBTN.click();


				driver.switchTo().defaultContent();
				driver.switchTo().frame("content");
				driver.switchTo().frame("f_query_add_mod");
				driver.switchTo().frame("frameAcknowledgeDetail");

				WebElement DOCNOhyp = driver.findElement(By.xpath("//table/tbody/tr[2]/td/font"));
				DOCNOhyp.click();


				driver.switchTo().defaultContent();
				driver.switchTo().frame("content");
				driver.switchTo().frame("f_query_add_mod");
				driver.switchTo().frame("frameAcknowledgeList");


				WebElement SavBTN = driver.findElement(By.name("save"));
				SavBTN.click();

				driver.switchTo().defaultContent();
				driver.switchTo().frame("content");
				driver.switchTo().frame("commontoolbarFrame");

				WebElement ApplyBn1 = driver.findElement(By.name("apply"));
				ApplyBn1.click();

				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent(); 
				driver.switchTo().frame("content");
				driver.switchTo().frame("messageFrame");
				WebElement Message = driver.findElement(By.xpath("/html/body/p"));
				System.out.println(Message.getText());
				assertTrue(Message.getText().contains("Operation Completed Successfully"));


				driver.switchTo().defaultContent();
				driver.switchTo().frame("content");
				driver.switchTo().frame("commontoolbarFrame");

				WebElement MenuBTNnx = driver.findElement(By.name("home"));
				MenuBTNnx.click();
				Thread.sleep(1000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame(1);
				driver.switchTo().frame("menuFr");

				WebElement IssueReturn = driver.findElement(By.id("sd49"));
				IssueReturn.click();

				driver.switchTo().defaultContent();
				driver.switchTo().frame("content");
				driver.switchTo().frame("commontoolbarFrame");

				WebElement CRTBTN = driver.findElement(By.name("create"));
				CRTBTN.click();
				Thread.sleep(1000);

				String currentWindow = driver.getWindowHandle();
				Set<String> windows1 = driver.getWindowHandles();  
				for (String window1 : windows1) 
				{ 
					driver.switchTo().window(window1); 
					if (driver.getTitle().contains("Modify Document Details")) 
					{
						System.out.println(driver.getCurrentUrl());

						WebElement ToStore = driver.findElement(By.name("to_store_code"));
						ToStore.click();
						ToStore.sendKeys(Keys.ARROW_DOWN);
						ToStore.sendKeys(Keys.TAB);

						WebElement OKBTN = driver.findElement(By.name("record"));
						OKBTN.click();

						driver.switchTo().window(currentWindow);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("content");
						driver.switchTo().frame("f_query_add_mod");

						driver.switchTo().frame("frameIssueReturnList");
						driver.switchTo().frame("frameIssueReturnListHeader");



						WebElement ItemTXT = driver.findElement(By.name("item_desc"));
						ItemTXT.sendKeys("RIFAMPIN 300MG HARD GELATIN CAPSULES");
						WebElement ItemBTN = driver.findElement(By.name("item_search"));
						ItemBTN.click();

						WebElement ItemQTY= driver.findElement(By.name("item_qty"));
						ItemQTY.sendKeys("5");

						Thread.sleep(500);
						WebElement AddBTN = driver.findElement(By.name("apply"));
						AddBTN.click();
						Thread.sleep(2000);


						driver.switchTo().defaultContent();
						driver.switchTo().frame("content");
						driver.switchTo().frame("f_query_add_mod");
						driver.switchTo().frame("frameIssueReturnDetail");

						WebElement HyperBTN = driver.findElement(By.name("a_0"));
						HyperBTN.click();

						driver.switchTo().defaultContent();
						driver.switchTo().frame("content");
						driver.switchTo().frame("commontoolbarFrame");

						WebElement ApplyBn1x = driver.findElement(By.name("apply"));
						ApplyBn1x.click();
						Thread.sleep(1000);

						String currentWindowxu = driver.getWindowHandle();
						Set<String> windows1xu = driver.getWindowHandles();  
						for (String window1xu : windows1xu) 
						{ 
							driver.switchTo().window(window1xu); 
							if (driver.getTitle().contains("Confirm Finalize")) 
							{
								System.out.println(driver.getCurrentUrl());

								WebElement YesBTN = driver.findElement(By.name("yes"));
								YesBTN.click();
								Thread.sleep(5000);
								driver.switchTo().window(currentWindowxu);

								Set<String> windows1xy = driver.getWindowHandles();  
								for (String window1xy : windows1xy) 
								{ 
									Thread.sleep(1000);
									driver.switchTo().window(window1xy); 
									if (driver.getTitle().contains("Confirm Printing")) 
									{
										System.out.println(driver.getCurrentUrl());

										WebElement NoBTN = driver.findElement(By.name("no"));
										NoBTN.click();
										Thread.sleep(2000);

										driver.switchTo().window(currentWindowx);
										driver.switchTo().parentFrame();
										driver.switchTo().defaultContent(); 
										driver.switchTo().frame("content");
										driver.switchTo().frame("messageFrame");
										WebElement Messagex = driver.findElement(By.xpath("/html/body/p"));
										System.out.println(Messagex.getText());
										assertTrue(Messagex.getText().contains("Operation Completed Successfully"));

									}
								}
							}
						}


					}
				}
			}
		}



		return new Object();
	}
}

