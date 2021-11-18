package hpClasses;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class login {
	// BMS Link 
	String url = "http://10.107.159.226/" ; 
	WebDriver driver ; 
	
	@BeforeTest
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\eclipse-workspace\\libs\\chromedriver.exe");
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}
	
	@Test(enabled= false)
	public void Login_to_BMS() {
		// to Maximize the Browser 
		driver.manage().window().maximize();
		//Implicit Wait 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Finding Elements & Actions on Elements 
		WebElement usernametxt = driver.findElement(By.id("username"));
		usernametxt.sendKeys("Digital1");
		WebElement passwordtxt = driver.findElement(By.id("password"));
		passwordtxt.sendKeys("digital1@staging");
		WebElement loginbtn = driver.findElement(By.name("login"));
		loginbtn.click();
		String Expected_Result = "Beneficiary Management System";
		String Actual_Result =(driver.getTitle());
		System.out.println(Actual_Result);
		Assert.assertEquals(Actual_Result,Expected_Result);
	}
	
	@Test (enabled=false)
	public void change_Language_to_Arabic() {
		//Global Dynamic wait 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Finding Elements & Actions on Elements 
		WebElement username_txt = driver.findElement(By.name("username"));
		username_txt.sendKeys("Digital1");
		WebElement password_txt = driver.findElement(By.name("password"));
		password_txt.sendKeys("digital1@staging");
		WebElement login_btn = driver.findElement(By.name("login"));
		login_btn.click();
		WebElement langbtn = driver.findElement(By.xpath("//span[@class='bms-language-text']"));
		langbtn.click();
		//Actions action = new Actions(driver);
		//action.moveToElement(langbtn).click().build().perform();
	}
	@Test (enabled=false)
	public void logout_from_BMS() {
		
		
	}
	@Test(enabled=true)
	public void Family_Registeration_MandatoryFields_Only() throws InterruptedException{
		//Implicit Wait 
		driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS);
		// defining the Uploaded Documents and it's direction 
		String ImageName = "testimage.jpg" ; 
		String ImagePath = System.getProperty("user.dir")+"/uploads/"+ImageName;
		// Finding Elements & Actions on Elements 
		// login to BMS 
		WebElement username_txt = driver.findElement(By.name("username"));
		username_txt.sendKeys("Digital1");
		WebElement password_txt = driver.findElement(By.name("password"));
		password_txt.sendKeys("digital1@staging");
		WebElement login_btn = driver.findElement(By.name("login"));
		login_btn.click();
		// search for existing beneficiary 
		WebElement NID_btn = driver.findElement(By.xpath("//label[@class='ant-radio-button-wrapper ant-radio-button-wrapper-checked']"));
		NID_btn.click();
		WebElement NID_Search_txt = driver.findElement(By.name("searchValue"));
		NID_Search_txt.sendKeys("20000000000026");
		WebElement NID_SearchBtn = driver.findElement(By.xpath("//button[@form='searchform']"));
		NID_SearchBtn.click();
		JavascriptExecutor jsc = (JavascriptExecutor)driver;
		jsc.executeScript("window.scrollBy(0,500)");
		// Click to add A new Family 
		WebElement Add_family_btn = driver.findElement(By.xpath("//div[@class='add-family-btn']"));
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
		IncomeTxt.sendKeys("4500");
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
		Emailtxt.sendKeys("mu1@gmail.com");
		WebElement NumCodeDDL = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[3]/div[2]/div[2]/div/div/div[2]/span/div/div"));
		NumCodeDDL.click();
		WebElement NumCodeSel = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/ul/li[1]"));
		NumCodeSel.click();
		WebElement phone_number_txt= driver.findElement(By.xpath("//input[@placeholder='Enter cell phone number']"));
		phone_number_txt.sendKeys("1000000001");
		WebElement Mail_verify_link = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div/div[1]/span[3]"));
		Mail_verify_link.click();
		WebElement Phone_verify_link = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div/div[2]/span[2]"));
		Phone_verify_link.click();
		WebElement Address_txt = driver.findElement(By.xpath("//input[@placeholder='Enter house number, street number, street name']"));
		Address_txt.sendKeys("Egypt , cairo ,nasr city , bla bla");
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
		Job_name_txt.sendKeys("Test");
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
		//Physician_txt.click();
		Physician_txt.sendKeys("Test");
		WebElement Selected_Physician = driver.findElement(By.xpath("/html/body/div[14]/div/div/div/ul/li"));
		Selected_Physician.click();
		// <---- filling the Medical Conditions Section ---->
		WebElement Medical_Conditions_sec = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div/div/div/div/div[1]/div[6]/div/div/div"));
		Medical_Conditions_sec.click();
		WebElement Cond_DDL = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[6]/div[2]/div/div/div[1]/span[2]/div/div/div/div"));
		Cond_DDL.click();
		WebElement Cond_sel = driver.findElement(By.xpath("/html/body/div[15]/div/div/div/ul/li[5]"));
		Cond_sel.click();
		WebElement Submit = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[1]/div[1]/div[2]/button[2]"));
		Submit.click();
		
		//WebElement successMSG = driver.findElement(by.)
		//Assert.assertTrue(successMSG.isDisplayed());		
		//"'DigitalBlocks2’s Family' added successfully!"
		
	}
	@AfterTest(enabled=false)
	public void teardown() {
		
		driver.quit();
	}	
}
