package Bookings;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ViewVocher 
{
	

	public static void main(String[] args) throws IOException, InterruptedException
	{
		WebDriver driver;
	      File src= new File("C:\\Users\\vsharvan\\sprint2\\PHPTravles_06\\TestResources\\Phptravels.property");
	      FileInputStream fis = new FileInputStream(src);

	      Properties prop = new Properties();
	      prop.load(fis);

	      System.setProperty("webdriver.chrome.driver",prop.getProperty("ChromeDriver"));
	      driver= new ChromeDriver();
	      FileInputStream fis1 = new FileInputStream("C:\\Users\\vsharvan\\Desktop\\selenium\\DataSource\\login.xlsx");   
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      //Read values from Excel
	      XSSFWorkbook workbook = new XSSFWorkbook(fis1);
	      XSSFSheet ws = workbook.getSheetAt(0);	
	        XSSFCell Email= ws.getRow(1).getCell(0);
	        XSSFCell Password= ws.getRow(1).getCell(1);
	        
	      driver.get(prop.getProperty("url"));
	      String LoginTitle=driver.getTitle();
	      System.out.println("The title of the Loginpage is :"+LoginTitle);
	      System.out.println("Email  is :" + Email);
	      System.out.println("password is :" +Password);
	      driver.findElement(By.name(prop.getProperty("Email"))).sendKeys(Email.toString());
	      driver.findElement(By.name(prop.getProperty("Password"))).sendKeys(Password.toString());
	      driver.findElement(By.className(prop.getProperty("Login"))).click();
	      
	      Thread.sleep(2000);
	      //click on Bookings 
	      driver.findElement(By.xpath(prop.getProperty("MyBookings"))).click();
	      String fristwindow =driver.getWindowHandle();
	      //click on viewvocher
	      driver.findElement(By.xpath(prop.getProperty("ViewVocher"))).click();
	      //Get the Title of FlightInvoicePage
	      String FlightInvoice=driver.getTitle();
          System.out.println("The title of the FlightInvoicepage is :"+FlightInvoice);
	      //Window Handle
	      Set<String>swh=driver.getWindowHandles();
	      swh.remove(fristwindow);
	      ArrayList wl=new ArrayList(swh);
	      String nw=(String) wl.get(0);
	      driver.switchTo().window(nw);
	      
	      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
	        
	        //Add Assertion for Confirmation message of Booking
		      if(driver.findElement(By.xpath("//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/i[1]")).isDisplayed()) {
		          System.out.println("Thank you for Booking");
		       	      }
		      else
		      {
		    	  System.out.println("Hi");
		      }
		      
		      //Add Assertion for Reservation Number
		      Assert.assertTrue(true, driver.findElement(By.xpath("//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/h3[1]/span[1]")).getText());
		       System.out.println("Assert Passed : " + driver.findElement(By.xpath("//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/h3[1]/span[1]")).getText());
		      //Select Paytment Method
		      Select banktype = new Select(driver.findElement(By.name(prop.getProperty(("BankType")))));
		      banktype.selectByValue("stripe");
		      
	        //Click on proceed
	      driver.findElement(By.xpath(prop.getProperty("Proceed"))).click();
	     
//	      driver.close();
	      }
	
	
}