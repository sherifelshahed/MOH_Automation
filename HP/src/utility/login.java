package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
	public WebDriver driver ;
	public login() {
		
	}
	// initiate the Browser 
			public Object invoke_browser()  
			{
				System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\eclipse-workspace\\libs\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				String url = "http://10.107.159.226/" ; 
				driver.navigate().to(url);
				return new Object();
			}
			

	//login to BMS function 
			public Object Login_to_BMS(String username, String password) {
				//Implicit Wait 
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// Finding Elements & Actions on Elements 
				WebElement usernametxt = driver.findElement(By.id("username"));
				usernametxt.sendKeys(username);
				WebElement passwordtxt = driver.findElement(By.id("password"));
				passwordtxt.sendKeys(password);
				WebElement loginbtn = driver.findElement(By.name("login"));
				loginbtn.click();
				if(driver.getTitle()=="Beneficiary Management System") {
					System.out.println("the user is logged in successfully");
				}
				//System.out.println(Actual_Result);
				//Assert.assertEquals(Actual_Result,Expected_Result);
				return new Object();
			}

			public Object Notification_Setup(String Notification_type, String Title, boolean Active_status)	{
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 WebElement MenuBtn = driver.findElement(By.cssSelector("div.ant-menu-submenu-title"));
				 MenuBtn.click();
			     WebElement notification_icon = driver.findElement(By.xpath("//a[@href='/notification'][contains(.,'Notifications')]"));
			     notification_icon.click();				     
			     WebElement create_template_btn = driver.findElement(By.xpath("//button[contains(.,'Create New Template')]"));
			     create_template_btn.click();		
			     WebElement Notification_Title_txt = driver.findElement(By.xpath("//input[@placeholder='Enter title']"));
			     Notification_Title_txt.sendKeys(Title);
			     if(Notification_type=="sms") {
			     WebElement SMS_Selc = driver.findElement(By.xpath("//input[@value='SMS']"));
			     SMS_Selc.click();
			     }
			     else {
			     WebElement Email_Selc = driver.findElement(By.xpath("//input[@value='Email']"));
			     Email_Selc.click();
			     }
			     WebElement Cat_selc = driver.findElement(By.xpath("(//div[contains(@class,'ant-select-selection__rendered')])[3]"));
			     Cat_selc.click();
			     WebElement Cat_choice = driver.findElement(By.xpath("//li[@role='option'][contains(.,'cat2')]"));
			     Cat_choice.click();
			     WebElement Event_selc = driver.findElement(By.xpath("//div[@unselectable='on'][contains(.,'Select Event Type')]"));
			     Event_selc.click();
			     WebElement Event_choice = driver.findElement(By.xpath("//li[@role='option'][contains(.,'Premium Due')]"));
			     Event_choice.click();
			     WebElement header_txt = driver.findElement(By.xpath("(//textarea[contains(@placeholder,'Please write message here')])[1]"));
			     header_txt.sendKeys("bla header");
			     WebElement body_txt = driver.findElement(By.xpath("(//textarea[contains(@placeholder,'Please write message here')])[2]"));
			     body_txt.sendKeys("bla body");
			     WebElement footer_txt = driver.findElement(By.xpath("(//textarea[contains(@placeholder,'Please write message here')])[3]"));
			     footer_txt.sendKeys("bla body");
			     WebElement From_date_Cal = driver.findElement(By.xpath("//input[contains(@placeholder,'Enter No. of Days (eg: 5, -5 etc)')]"));
			     From_date_Cal.sendKeys("1");
			     JavascriptExecutor js2 = (JavascriptExecutor)driver;
				 js2.executeScript("window.scrollBy(0,-500)");
			     WebElement Active_From_date_Cal = driver.findElement(By.xpath("//*[@id=\"bms\"]/body/div[3]/div/div[2]/div/div[2]/div[1]/div[2]/div[1]/div[9]/div[1]/span[2]/span/div/input"));
			     Active_From_date_Cal.click();
				 WebElement CalField1 = driver.findElement(By.xpath("//*[@id=\"bms\"]/body/div[6]/div/div/div/div/div[1]/div/input"));
				 CalField1.sendKeys("25/10/2021");
			     WebElement Active_To_date_Cal = driver.findElement(By.xpath("//*[@id=\"bms\"]/body/div[3]/div/div[2]/div/div[2]/div[1]/div[2]/div[1]/div[9]/div[2]/span[2]/span/div/input"));
			     Active_To_date_Cal.click();
			     WebElement CalField2 = driver.findElement(By.xpath("//*[@id=\"bms\"]/body/div[7]/div/div/div/div/div[1]/div/input"));
				 CalField2.sendKeys("25/10/2022");
			     if(Active_status = true) {
			     WebElement Active_btn = driver.findElement(By.xpath("(//span[contains(.,'Active')])[4]"));
			     Active_btn.click();
			     }
			     else {
			     WebElement Not_Active_btn = driver.findElement(By.xpath("//span[contains(.,'Not Active')]"));
			     Not_Active_btn.click();	 
			     }
			     WebElement Create_btn = driver.findElement(By.xpath("//*[@id=\"bms\"]/body/div[3]/div/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[2]/button[2]"));
			     Create_btn.click();
				 return new Object();
			 }		

}
