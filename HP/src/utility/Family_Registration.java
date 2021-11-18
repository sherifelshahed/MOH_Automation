package utility;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Family_Registration extends login{
	    		
		public Family_Registration(WebDriver driver) {
			 
		}	
		public Object invoke_browser()  
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\eclipse-workspace\\libs\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			String url = "http://10.107.159.226/" ; 
			driver.navigate().to(url);
			return new Object();
		}
		//Search for Beneficiary Function 
		public Object Search_for_Beneficiary_by_NID(String NID){
			// search for existing beneficiary 
		   // WebElement NID_btn = driver.findElement(By.xpath("//*[@id='searchform']/div[1]/div/label[1]/span[1]/input"));
			//NID_btn.click();
			WebElement NID_Search_txt = driver.findElement(By.name("searchValue"));
			NID_Search_txt.click();
			NID_Search_txt.sendKeys(NID);
			WebElement NID_SearchBtn = driver.findElement(By.xpath("//button[@form='searchform']"));
			NID_SearchBtn.click();
			JavascriptExecutor jsc = (JavascriptExecutor)driver;
			jsc.executeScript("window.scrollBy(0,500)");
			WebElement Add_family_btn = driver.findElement(By.xpath("//div[@class='add-family-btn']"));
			if(Add_family_btn.isDisplayed()) {
				System.out.println("the Test is passed- Add Family button is displayed");
			}
			/*boolean ActualResult = Add_family_btn.isDisplayed();
			boolean ExpectedResult = true;			
			//Assert.assertEquals(ActualResult, ExpectedResult, "the Test is passed");
			//System.out.println(ActualResult);
			 */
			return new Object();
		}
		//register new family Function
		public Object Add_new_Family(String Income, String PhoneNum,String Email,String Address) {
			// defining the Uploaded Documents and it's direction 
			String ImageName = "testimage.jpg" ; 
			String ImagePath = System.getProperty("user.dir")+"/uploads/"+ImageName;
			// Click to add A new Family 
			WebElement Add_family_btn = driver.findElement(By.xpath("//button[@type='button'][contains(.,'Family Registration')]"));
			Add_family_btn.click();
			WebElement Proceed_btn = driver.findElement(By.cssSelector("button.ant-btn.activate-btn"));
			Proceed_btn.click();
			// filling the Basic Information Section
			/*WebElement FirstNameTxt = driver.findElement(By.xpath("//input[@placeholder='Enter first name']"));
			FirstNameTxt.sendKeys("Test");
			WebElement LastNameTxt = driver.findElement(By.xpath("//input[@placeholder='Enter last name']"));
			LastNameTxt.sendKeys("DigitalBlocks3");
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,500)");
			WebElement BenRel = driver.findElement(By.xpath("//div[@class='ant-select-show-arrow my-bms-drop-down ant-select ant-select-enabled']"));
			BenRel.click();
			WebElement BenCatSelect = driver.findElement(By.xpath("//li[@class='ant-select-dropdown-menu-item'][2]"));
			BenCatSelect.click();
			WebElement Calendar = driver.findElement(By.xpath("//*[@placeholder='DD/MM/YYYY']"));
			Calendar.sendKeys(Keys.ENTER);
			WebElement CalField = driver.findElement(By.xpath("//input[@class='ant-calendar-input ']"));
			CalField.sendKeys("12/10/1985");	
			*/
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,300)");
			WebElement IncomeTxt = driver.findElement(By.xpath("//input[@placeholder='Enter Income']"));
			IncomeTxt.click();
			IncomeTxt.sendKeys(Income);
			//Thread.sleep(3000);
			/*
			WebElement BenStats = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[1]/div[2]/div/div/div[14]/span[2]/div/div/div/div"));
			BenStats.click();
			WebElement BenStatsSel = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/ul/li[2]"));
			BenStatsSel.click();
			*/
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,-500)");		
			// <---- filling the Contact Information Section ---->
			WebElement Contact_information_section = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div/div/div/div/div[1]/div[2]"));
			Contact_information_section.click();	
			WebElement Emailtxt= driver.findElement(By.xpath("//input[@placeholder='Enter email']"));
			Emailtxt.sendKeys(Email);
			WebElement NumCodeDDL = driver.findElement(By.xpath("(//div[@class='ant-select-selection__rendered'])[6]"));
			NumCodeDDL.click();
			WebElement NumCodeSel = driver.findElement(By.xpath("//li[@role='option'][contains(.,'+20')]"));
			NumCodeSel.click();
			WebElement phone_number_txt= driver.findElement(By.xpath("//input[@placeholder='Enter cell phone number']"));
			phone_number_txt.sendKeys(PhoneNum);
			WebElement Mail_verify_link = driver.findElement(By.xpath("//span[@class='check'][contains(.,'Check if email address already exist before you proceed')]"));
			Mail_verify_link.click();
			WebElement Phone_verify_link = driver.findElement(By.xpath("//span[@class='check'][contains(.,'Check if mobile number already exist before you proceed')]"));
			Phone_verify_link.click();
			WebElement Address_txt = driver.findElement(By.xpath("//input[@placeholder='Enter house number, street number, street name']"));
			Address_txt.sendKeys(Address);
			JavascriptExecutor js1 = (JavascriptExecutor)driver;
			js1.executeScript("window.scrollBy(0,500)");
			WebElement Governrate_DDL = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div/div[7]/span[2]/div/div/div/div"));
			Governrate_DDL.click();
			WebElement Governrate_Sel = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/ul/li"));
			Governrate_Sel.click();
			WebElement District_DDL = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div/div[8]/span[2]/div/div/div/div"));
			District_DDL.click();
			WebElement District_Sel = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/ul/li"));
			District_Sel.click();
			WebElement City_DDL = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div/div[9]/span[2]/div/div/div/div"));
			City_DDL.click();
			WebElement City_Sel = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/ul/li"));
			City_Sel.click();
			JavascriptExecutor js2 = (JavascriptExecutor)driver;
			js2.executeScript("window.scrollBy(0,-500)");
			// <---- filling the Beneficiary Documents Section ---->
			WebElement Beneficiary_Docs_section = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div/div/div/div/div[1]/div[3]"));
			Beneficiary_Docs_section.click();
			WebElement Upload_Docs_btn = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[3]/div[3]/div[2]/div[2]/button"));
			Upload_Docs_btn.click();
			WebElement Doc_type_DDL = driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/div/div"));
			Doc_type_DDL.click();
			WebElement Doc_type_sel = driver.findElement(By.xpath("/html/body/div[7]/div/div/div/ul/li[4]"));
			Doc_type_sel.click();
			WebElement Issue_date = driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div/div[2]/div[1]/div[5]/div[1]/span/div/input"));
			Issue_date.sendKeys(Keys.ENTER);
			WebElement CalField2 = driver.findElement(By.xpath("//input[@class='ant-calendar-input ']"));
			CalField2.sendKeys("25/10/2021");
			WebElement file_upload = driver.findElement(By.id("file-input"));
			file_upload.sendKeys(ImagePath);
			WebElement file_submit= driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div/div[2]/div[1]/div[7]/button[2]"));
			file_submit.click();
			// <---- filling the Job Information Section ---->
			WebElement Job_info_secion = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div/div/div/div/div[1]/div[4]/div/div/div"));
			Job_info_secion.click();
			WebElement Job_typeDDL = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[4]/div[2]/div/div/div[1]/span[2]/div/div/div"));
			Job_typeDDL.click();
			WebElement IT_sel = driver.findElement(By.xpath("/html/body/div[9]/div/div/div/ul/li[1]"));
			IT_sel.click();
			WebElement Job_name_txt= driver.findElement(By.xpath("//input[@placeholder='Enter job name']"));
			Job_name_txt.sendKeys("Test Tester");
			WebElement Co_name_txt= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[4]/div[2]/div/div/div[3]/span[2]/input"));
			Co_name_txt.sendKeys("Test Company");
			// <---- filling the Assigned Facility Section ---->
			WebElement Assigned_facility_secion = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div/div/div/div/div[1]/div[5]"));
			Assigned_facility_secion.click();	
			WebElement GoverDDL = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[3]/div[5]/div[2]/div/div/div[1]/span[2]/div/div/div/div"));
			GoverDDL.click();
			WebElement Gov_sel = driver.findElement(By.xpath("/html/body/div[10]/div/div/div/ul/li"));
			Gov_sel.click();
			WebElement DisDDL = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[3]/div[5]/div[2]/div/div/div[2]/span[2]/div/div/div/div"));
			DisDDL.click();
			WebElement Dis_sel = driver.findElement(By.xpath("/html/body/div[11]/div/div/div/ul/li"));
			Dis_sel.click();
			WebElement City_DDL1 = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[5]/div[2]/div/div/div[3]/span[2]/div/div/div/div"));
			City_DDL1.click();
			WebElement City_sel = driver.findElement(By.xpath("/html/body/div[12]/div/div/div/ul/li"));
			City_sel.click();
			WebElement search_facility_btn = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[5]/div[2]/div/div/div[4]/button"));
			search_facility_btn.click();
			WebElement search_facility_txt = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[5]/div[2]/div/div/div[5]/span[2]/div/div/div/div[1]"));
			search_facility_txt.click();
			WebElement Facility_selected = driver.findElement(By.xpath("/html/body/div[13]/div/div/div/ul/li[4]"));
			Facility_selected.click();
			WebElement Assign_Physician_txt = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[5]/div[2]/div/div/div[6]/span[2]/div/div/div/div[1]"));
			Assign_Physician_txt.click();
			WebElement Physician_txt = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[3]/div[5]/div[2]/div/div/div[6]/span[2]/div/div/div/div[3]/div/input"));
			Physician_txt.sendKeys("Test");
			WebElement Selected_Physician = driver.findElement(By.xpath("/html/body/div[14]/div/div/div/ul/li"));
			Selected_Physician.click();
			//  <---- filling the Medical Conditions Section ---->
			WebElement Medical_Conditions_sec = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div/div/div/div/div[1]/div[6]/div/div/div"));
			Medical_Conditions_sec.click();
			WebElement Cond_DDL = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[6]/div[2]/div/div/div[1]/span[2]/div/div/div/div"));
			Cond_DDL.click();
			WebElement Cond_sel = driver.findElement(By.xpath("/html/body/div[15]/div/div/div/ul/li[5]"));
			Cond_sel.click();
			WebElement Submit = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[1]/div[1]/div[2]/button[2]"));
			Submit.click();
			WebElement successMSG = driver.findElement(By.cssSelector("div.message.bottom-margin"));
			if(successMSG.isDisplayed()) {
				System.out.println("the Family is Registered Successfully");
			}
			/*boolean ActualResult = successMSG.isDisplayed(); 
			boolean ExpectedResult = true ; 
			Assert.assertEquals(ActualResult, ExpectedResult);
			String MSG =  "the family is registered and test is passed";
			Assert.assertEquals(ActualResult, ExpectedResult, MSG);
			"'DigitalBlocks2’s Family' added successfully!"
			*/
			return new Object();
		}
		public Object change_language_to_Arabic () {
			WebElement lang_icon = driver.findElement(By.xpath("//span[@class='bms-language-text']"));
			lang_icon.click();
			WebElement Ar_Sel = driver.findElement(By.xpath("//li[contains(.,'Arabic')]"));
			Ar_Sel.click();
			WebElement Ar_title = driver.findElement(By.xpath("//span[contains(.,'نظام إدارة المستفيدين')]"));
			if (Ar_title.isDisplayed()) {
				System.out.println("the page is in Arabic now"); 
			}
			
			return new Object();
		}	
		public Object Log_out_from_BMS() {
			WebElement logout_btn = driver.findElement(By.xpath("//div[@class='bms-logout']"));
			logout_btn.click();
			return new Object();
		}
		public Object teardown() {
			
			driver.quit();
			return new Object();
		}	
		public Object approve_family(String NID) throws InterruptedException {
			WebElement ChngReqTab = driver.findElement(By.xpath("(//a[contains(.,'Change Request Management')])[1]"));
	        ChngReqTab.click();
	        WebElement SrcNID = driver.findElement(By.xpath("//input[@placeholder='Enter National ID/Passport Number']"));
	        SrcNID.clear();
	        SrcNID.sendKeys(NID);
	        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	       // WebElement SrcBtn = driver.findElement(By.xpath("//button[@class='ant-btn search-btn']"));
	        WebElement SrcBtn = driver.findElement(By.xpath("button.ant-btn.search-btn"));
	        SrcBtn.click();
	        //Thread.sleep(2000);
	        WebElement FamilyRegBTN = driver.findElement(By.xpath("//div[@class='text'][contains(.,'Family Registration')]"));
	        FamilyRegBTN.click();
	        WebElement approveBTN = driver.findElement(By.xpath("//button[@type='button'][contains(.,'Approve')]"));
	        approveBTN.click();
	        Thread.sleep(5000);
			return new Object();
		}
		 	

}
