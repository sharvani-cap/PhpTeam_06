package PHPFlightBooking;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FlightBooking
{
public static void main(String[] args) throws IOException, InterruptedException{
    	
	  WebDriver driver;
      File src= new File("C:\\Users\\vsharvan\\sprint2\\PHPTravles_06\\TestResources\\Phptravels.property");
      FileInputStream fis = new FileInputStream(src);

      Properties prop = new Properties();
      prop.load(fis);

      System.setProperty("webdriver.chrome.driver",prop.getProperty("ChromeDriver"));
      driver= new ChromeDriver();
    //Reading values from excel
      FileInputStream fis1 = new FileInputStream("C:\\Users\\vsharvan\\Desktop\\selenium\\DataSource\\login.xlsx");   
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      XSSFWorkbook workbook = new XSSFWorkbook(fis1);
      XSSFSheet ws = workbook.getSheetAt(0);	
        XSSFCell Email= ws.getRow(1).getCell(0);
        XSSFCell Password= ws.getRow(1).getCell(1);
      driver.get(prop.getProperty("url"));
   // Get the Title of Loginpage
      String LoginTitle=driver.getTitle();
      System.out.println("The title of the Loginpage is :"+LoginTitle);
    //Printing the email and password
      System.out.println("Email  is :" + Email);
      System.out.println("password is :" +Password);
      
      driver.findElement(By.name(prop.getProperty("Email"))).sendKeys(Email.toString());
      driver.findElement(By.name(prop.getProperty("Password"))).sendKeys(Password.toString());
      driver.findElement(By.className(prop.getProperty("Login"))).click();
      //Get the Title of HomePage
      String HomePageTitle=driver.getTitle();
      System.out.println("The title of the Homepage is :"+HomePageTitle);
      
   //Validating the Welcome Message of HomePage
      if(driver.findElement(By.xpath("//span[contains(text(),'Demo')]")).isEnabled()) {
          System.out.println("Hi ,Demo Welcome Back");
      }
          
      driver.findElement(By.xpath(prop.getProperty("Flight"))).click();
   //Get the Title of SearchPage
      String SearchPageTitle=driver.getTitle();
      System.out.println("The title of the Searchpage is :"+SearchPageTitle);
   //Change the Currency to Indian Currency
        driver.findElement(By.id(prop.getProperty("Currency"))).click();
        driver.findElement(By.xpath(prop.getProperty("INR"))).click();
        driver.findElement(By.xpath(prop.getProperty("FlightSearch"))).click();
        
        Select type= new Select(driver.findElement(By.xpath(prop.getProperty("flights"))));
        type.selectByValue("economy_premium");
		XSSFCell From=ws.getRow(3).getCell(0);
		XSSFCell To=ws.getRow(3).getCell(1);
		XSSFCell date=ws.getRow(3).getCell(2);
		
            driver.findElement(By.id(prop.getProperty("From"))).sendKeys(From.toString());
            driver.findElement(By.id(prop.getProperty("To"))).sendKeys(To.toString());
            
            WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(6));
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocomplete")));
            
            WebElement element=driver.findElement(By.id(prop.getProperty("Date")));
            element.clear();
            element.click();
            driver.findElement(By.id(prop.getProperty("Date"))).sendKeys(date.toString());
         
            driver.findElement(By.xpath(prop.getProperty("passenger"))).click();
        
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        
            WebElement element1=driver.findElement(By.xpath(prop.getProperty("Add")));
            element1.click();
            driver.findElement(By.xpath(prop.getProperty("passengers"))).click();
            driver.findElement(By.id(prop.getProperty("Search"))).click();
           //Add Assertion for the dates you are travelling(07-07-2022 to 11-07-2022)
            WebElement Dates = driver.findElement(By.xpath("//strong[contains(text(),'Dates')]"));
            Assert.assertEquals(true, Dates.isDisplayed());
            System.out.println("Date is displayed – Assert passed");
    
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
        
            driver.navigate().refresh();
            
          //Get the Title Of FlightPage
        String FlightPageTitle=driver.getTitle();
        System.out.println("The title of the Flightpage is : "+FlightPageTitle);
        
        //Apply Filters For FlightBooking
        WebElement direct=driver.findElement(By.id(prop.getProperty("Direct")));
        direct.click();
        //Select the Type of IndigoFlight
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        WebElement FlightType=driver.findElement(By.xpath(prop.getProperty("FlightType")));
        FlightType.click();
        driver.findElement(By.xpath(prop.getProperty("BookNow"))).click();
        
        WebDriverWait wait3 = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.name("title_1"))); 
        
         //Get the Title of FlightBookingPage
        String FlightBookingPage=driver.getTitle();
        System.out.println("The title of the FlightBookingpage is :"+FlightBookingPage);
        
        //Enter the details of first Traveler Information 
        Select title= new Select(driver.findElement(By.name(prop.getProperty("Title"))));
        title.selectByValue("Miss");
        XSSFCell firstname=ws.getRow(5).getCell(0);
        XSSFCell lastname=ws.getRow(5).getCell(1);     
        driver.findElement(By.name(prop.getProperty("First_Name1"))).sendKeys(firstname.toString());
        driver.findElement(By.name(prop.getProperty("Last_Name1"))).sendKeys(lastname.toString());
        
        Select nation = new Select(driver.findElement(By.name(prop.getProperty(("Nation1")))));
        nation.selectByValue("IN");
        
        Select month = new Select(driver.findElement(By.name(prop.getProperty(("Month1")))));
        month.selectByValue("03");
        
        Select day = new Select(driver.findElement(By.name(prop.getProperty(("Day1")))));
        day.selectByValue("04");
        
        Select year = new Select(driver.findElement(By.name(prop.getProperty("Year1"))));
        year.selectByValue("2002");
        
        XSSFCell passport=ws.getRow(5).getCell(2); 
        driver.findElement(By.name(prop.getProperty("Passport1"))).sendKeys(passport.toString());
        
        Select passmon = new Select(driver.findElement(By.name(prop.getProperty("PassportMonth1"))));
        passmon.selectByValue("03");
        
        Select passday = new Select(driver.findElement(By.name(prop.getProperty("PassportDay1"))));
        passday.selectByValue("04");
        
        Select passyear = new Select(driver.findElement(By.name(prop.getProperty("PassportYear1"))));
        passyear.selectByValue("2010");
        
        Select expmon = new Select(driver.findElement(By.name(prop.getProperty("ExpMonth1"))));
        expmon.selectByValue("03");
        
        Select expday = new Select(driver.findElement(By.name(prop.getProperty("ExpDay1"))));
        expday.selectByValue("04");
        
        Select expyear = new Select(driver.findElement(By.name(prop.getProperty("ExpYear1"))));
        expyear.selectByValue("2025");
        
      //Enter the details of Second Traveler Information 
        XSSFCell firstname2=ws.getRow(7).getCell(0);
        XSSFCell lastname2=ws.getRow(7).getCell(1); 
        driver.findElement(By.name(prop.getProperty("First_Name2"))).sendKeys(firstname2.toString());
        driver.findElement(By.name(prop.getProperty("Last_Name2"))).sendKeys(lastname2.toString());
        
        Select nation1 = new Select(driver.findElement(By.name(prop.getProperty("Nation2"))));
        nation1.selectByValue("IN");
        
        Select month1 = new Select(driver.findElement(By.name(prop.getProperty("Month2"))));
        month1.selectByValue("03");
        
        Select day1 = new Select(driver.findElement(By.name(prop.getProperty("Day2"))));
        day.selectByValue("04");
        
        Select year1 = new Select(driver.findElement(By.name(prop.getProperty("Year2"))));
        year1.selectByValue("2002");
        
        XSSFCell passport2=ws.getRow(7).getCell(2);
        driver.findElement(By.name(prop.getProperty("Passport2"))).sendKeys(passport2.toString());
        
        Select passmon1 = new Select(driver.findElement(By.name(prop.getProperty("PassportMonth2"))));
        passmon1.selectByValue("05");
        
        Select passday1 = new Select(driver.findElement(By.name(prop.getProperty("PassportDay2"))));
        passday1.selectByValue("06");
        
        Select passyear1 = new Select(driver.findElement(By.name(prop.getProperty("PassportYear2"))));
        passyear1.selectByValue("2011");
        
        Select expmon1 = new Select(driver.findElement(By.name(prop.getProperty("ExpMonth2"))));
        expmon1.selectByValue("03");
        
        Select expday1 = new Select(driver.findElement(By.name(prop.getProperty("ExpDay2"))));
        expday1.selectByValue("05");
        
        Select expyear1 = new Select(driver.findElement(By.name(prop.getProperty("ExpYear2"))));
        expyear1.selectByValue("2030");
        
        WebDriverWait wait4 = new WebDriverWait(driver,Duration.ofSeconds(50));
        wait4.until(ExpectedConditions.visibilityOfElementLocated(By.className("form-box")));
        
        //Select the Payment Method
        WebElement Payment=driver.findElement(By.name(prop.getProperty("Payment")));
        Payment.sendKeys(Keys.SPACE);
        
        //Add Assertion for Total Price
        WebElement TotalPrice = driver.findElement(By.xpath("//body/div[2]/form[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/strong[1]/div[1]/ul[2]/li[3]/strong[1]"));
        Assert.assertEquals(true, TotalPrice.isEnabled());
        System.out.println("Assert Passed and The total price is:"+TotalPrice.getText());
        
        //click on confirm  by  continuing 
        JavascriptExecutor js = (JavascriptExecutor)driver;    
        js.executeScript("document.getElementById(\"agreechb\").click();");
        
          //Click on Confirm Booking       
        JavascriptExecutor js1 = (JavascriptExecutor)driver;   
        js1.executeScript("document.getElementById(\"booking\").click();");
        
      //Get the Title of FlightInvoicePage
	      String FlightInvoice=driver.getTitle();
        System.out.println("The title of the FlightInvoicepage is :"+FlightInvoice);
        
      //Assertion for BookingSuccessfull
        if(driver.findElement(By.xpath("//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/i[1]")).isDisplayed()) {
	          System.out.println("Thank you for Booking");
	       	}
        
        //Add Assertion Reservation Number
        Assert.assertTrue(true, driver.findElement(By.xpath("//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/h3[1]/span[1]")).getText());
	       System.out.println("Assert Passed : " + driver.findElement(By.xpath("//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/h3[1]/span[1]")).getText());
	       
	    //Add assertion for UserName 
        Assert.assertTrue(driver.findElement(By.xpath("//small[contains(text(),'DemoUlyssesUlyssesUlyssesUlysses User')]")).getText().matches("Demo[a-z|A-Z]+"));
        System.out.println("User Name is " + driver.findElement(By.xpath("//small[contains(text(),'DemoUlyssesUlyssesUlyssesUlysses User')]")).getText());
         
      
		}
   }