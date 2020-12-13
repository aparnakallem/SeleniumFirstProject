package com.hrms.lib;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

//import com.hrms.utility.Log;



public class General extends Global
{
//Reusable methods
	
	
	WebDriver driver;
	Actions action;
	WebElement element;
	
//************open application functionality********************
	
public void openApplication()
{ 
	//Log.info("*******started execution***********");
	
	System.setProperty("webdriver.chrome.driver","D:\\SeleniumSoftwares\\chromedriver_win32 (6)\\chromedriver.exe");
	
	driver=new ChromeDriver();
	driver.get(url);
	
	//Log.info("**********Application Opened Successfully*********");
	System.out.println(driver.getTitle()); 
	
}

//************close application functionality********************

public void closeApplication()
{
	driver.close();
	
	//Log.info("Application close successfully");
	//Log.info("*******End execution***********");  
	
	}

//************add functionality********************

public void login()
{
	driver.findElement(By.name(txt_loginusername)).sendKeys(username);
	driver.findElement(By.name(txt_loginpassword)).sendKeys(password);
	driver.findElement(By.name(btn_login)).click();
	
	System.out.println("login completed");	
	//Log.info("******login completed***********");
	
}

//************add functionality********************

public void addEmployee() throws Exception

{
	Actions action= new Actions(driver);

	WebElement element= driver.findElement(By.linkText("PIM"));
	action.moveToElement(element).perform();
	Thread.sleep(2000L);
	
	WebElement element1= driver.findElement(By.id("menu_pim_Configuration"));
	action.moveToElement(element1).perform();
	Thread.sleep(2000L);

	WebElement element2= driver.findElement(By.id("menu_pim_viewEmployeeList"));
	action.moveToElement(element2).perform();
	Thread.sleep(2000L);
	
	WebElement searchBtn1 = driver.findElement(By.id("menu_pim_addEmployee"));
	action.moveToElement(searchBtn1).click().perform();
	Thread.sleep(2000);
	
	driver.findElement(By.name("firstName")).sendKeys("madhumitha");
	driver.findElement(By.name("lastName")).sendKeys("kallem");
	
	//code for uploading the file
	WebElement uploading=driver.findElement(By.xpath("//input[@id='photofile']"));
	uploading.sendKeys("D:\\SeleniumSoftwares\\Chrysanthemum.jpg");
	
	Thread.sleep(5000);
	System.out.println("file uploded successfully");
	
	
	//code or check in box
	
	WebElement checkBOX=driver.findElement(By.xpath("//input[@id='chkLogin']"));
	checkBOX.click();
	
	//code for employee credentials
	
	driver.findElement(By.name("user_name")).sendKeys("madhumitha");
	driver.findElement(By.name("user_password")).sendKeys("madysomashekar");
	driver.findElement(By.name("re_password")).sendKeys("madysomashekar");
	
	//click on save button
	
	WebElement saveButton=driver.findElement(By.xpath("//input[@id='btnSave']"));
    saveButton.click();
    Thread.sleep(5000);
    
    System.out.println("employee added");
   // Log.info("*******employee added***********");
	
}

//***************delete functionality*******************

public void deleteEmployee() throws Exception
{
	Actions action= new Actions(driver);

	WebElement element= driver.findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']/b"));
	action.moveToElement(element).perform();
	Thread.sleep(3000L);
	
	WebElement subMenu = driver.findElement(By.xpath("//*[@id='menu_admin_UserManagement']"));
	action.moveToElement(subMenu).click().perform();
	
    Thread.sleep(1000);
    WebElement subMenu1 = driver.findElement(By.xpath("//a[@id='menu_admin_viewSystemUsers']"));
    action.moveToElement(subMenu1).click().perform();
    
    

    WebElement check1 = driver.findElement(By.id("ohrmList_chkSelectRecord_39"));
    check1.click();
    
    WebElement check2 = driver.findElement(By.id("ohrmList_chkSelectRecord_31"));
    check2.click();

    Thread.sleep(3000);
    
 WebElement e= driver.findElement(By.name("btnDelete"));
 e.click();
  
WebElement e2=driver.findElement(By.id("dialogDeleteBtn"));
e2.click();
Thread.sleep(5000);

System.out.println("employee deleted successfully");
//Log.info("*******deleted employee***********");

}

//*************logout functionality***********************

public void logout() throws Exception
{
	driver.findElement(By.id(welcome)).click();
	
	Thread.sleep(1000);
	
	driver.findElement(By.xpath(logout)).click();
	
	System.out.println("logout completed");
	//Log.info("*******logout secussfully***********");
}
}