package PhpTravels;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FlightBookingPage 
{
	WebDriver driver;
	@FindBy(name="title_1") 
	WebElement Title;
	Select dropdowns; 
	
	@FindBy(name="firstname_1") WebElement firstname;
	
	@FindBy(name="lastname_1") WebElement lastname;
	
	@FindBy(name="nationality_1") 
	WebElement nation;
	Select dropdown1;
	
	@FindBy(name="dob_month_1") WebElement month1;
	Select dropdown2;
	
	@FindBy(name="dob_day_1") WebElement day1;
	Select dropdown3; 
	
	@FindBy(name="dob_year_1") WebElement year1;
	Select dropdown4;
	
	@FindBy(name="passport_1") WebElement passport1;
	
	@FindBy(name="passport_issuance_month_1") WebElement passmonth1;
	Select dropdown5;
	
	@FindBy(name="passport_issuance_day_1") WebElement passday1;
	Select dropdown6;
	
	@FindBy(name="passport_issuance_year_1") WebElement passyear1;
	Select dropdown7;
	
	@FindBy(name="passport_month_1") WebElement expmon1;
	Select dropdown8;
	
	@FindBy(name="passport_day_1") WebElement expday1;
	Select dropdown9;
	
	@FindBy(name="passport_year_1") WebElement expyear1;
	Select dropdown10;
	
	
	@FindBy(name="firstname_2") 
	WebElement firstname2;
	@FindBy(xpath="//input[@name='lastname_2']") 
	WebElement lastname2;
	@FindBy(name="nationality_2") 
	WebElement nation2;
	Select dropdown11;
	
	@FindBy(name="dob_month_2") WebElement month2;
	Select dropdown12;
	
	@FindBy(name="dob_day_2") WebElement day2;
	Select dropdown13;
	
	@FindBy(name="dob_year_2") WebElement year2;
	Select dropdown14;
	
	@FindBy(name="passport_2") WebElement passport2;
	
	@FindBy(name="passport_issuance_month_2") WebElement passmonth2;
	Select dropdown15;
	
	@FindBy(name="passport_issuance_day_2") WebElement passday2;
	Select dropdown16;
	
	@FindBy(name="passport_issuance_year_2") WebElement passyear2;
	Select dropdown17;
	
	@FindBy(name="passport_month_2") WebElement expmon2;
	Select dropdown18;
	
	@FindBy(name="passport_day_2") WebElement expday2;
	Select dropdown19;
	
	@FindBy(name="passport_year_2") WebElement expyear2;
	Select dropdown20;
	
	@FindBy(xpath="//input[@id='gateway_stripe']") WebElement payment;
	
	@FindBy(id="agreechb") 
	WebElement confirm;
	
	@FindBy(id="booking") 
	WebElement booking;
	
	public FlightBookingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		   //Get the Title of FlightBookingPage
		String FlightBookingPage=driver.getTitle();
        System.out.println("The title of the FlightBookingpage is :"+FlightBookingPage);
		
	}
	  //Get the  first Traveler Information 
	public void clickTitle() {
		dropdowns = new Select(Title);
		dropdowns.selectByValue("Miss");
}
	public void  setfirstname1(String strfirstname1)
	{
		//Enter firstName
		firstname.sendKeys(strfirstname1);
	}
	public void  setlastname1(String strlastname1) 
	{
		//Enter Lastname
		lastname.sendKeys(strlastname1);
	}
	public void selectCountry1() 
	{
		//Select Nationality
		dropdown1 = new Select(nation);
		dropdown1.selectByValue("IN");
    }
	public void selectMonth1() 
	{
		//Select DOB Month
		dropdown2 = new Select(month1);
		dropdown2.selectByValue("03");
    }
	public void selectDay1() 
	{
		//Select DOB Day
		dropdown3 = new Select(day1);
		dropdown3.selectByValue("04");
    }
	public void selectYear1()
	{
		//Select DOB Year
		dropdown4 = new Select(year1);
		dropdown4.selectByValue("2002");
    }
	public void  setpassport1(String strpassport) 
	{
		//Enter Passport Number
		passport1.sendKeys(strpassport);
	}
	public void selectPassmonth1() 
	{
		//Select Passport Insurance Month
		dropdown5 = new Select(passmonth1);
		dropdown5.selectByValue("03");
    }
	public void selectPassday1() 
	{
		//Select Passport Insurance Day
		dropdown6 = new Select(passday1);
		dropdown6.selectByValue("04");
    }
	public void selectPassyear1() 
	{
		//Select Passport Insurance Year
		dropdown7 = new Select(passyear1);
		dropdown7.selectByValue("2010");
    }
	public void selectExpMon1() 
	{
		//Select Passport Expire Month
		dropdown8 = new Select(expmon1);
		dropdown8.selectByValue("03");
    }
	public void selectExpday1() {
		//Select Passport Expire Day
		dropdown9 = new Select(expday1);
		dropdown9.selectByValue("04");
    }
	public void selectExpyear1() {
		//Select Passport Expire Year
		dropdown10 = new Select(expyear1);
		dropdown10.selectByValue("2025");
    }
	
	//Get the  second Traveler Information 
	
	public void  setfirstname(String strfirstname2) {
		firstname2.sendKeys(strfirstname2,Keys.TAB);
	}
	public void  setlastname(String strlastname2) {
		lastname2.sendKeys(strlastname2);
	}
	public void selectCountry2() {
		dropdown11 = new Select(nation2);
		dropdown11.selectByValue("IN");
    }
	public void selectMonth2(){
		dropdown12 = new Select(month2);
		dropdown12.selectByValue("03");
    }
	public void selectDay2(){
		dropdown13 = new Select(day2);
		dropdown13.selectByValue("04");
    }
	public void selectYear2(){
		dropdown14 = new Select(year2);
		dropdown14.selectByValue("2002");
    }
	public void  setpassport2(String strpassport2) {
		passport2.sendKeys(strpassport2);
	}
	public void selectPassmonth2() {
		dropdown15 = new Select(passmonth2);
		dropdown15.selectByValue("05");
    }
	public void selectPassday2() {
		dropdown16 = new Select(passday2);
		dropdown16.selectByValue("06");
    }
	public void selectPassyear2() {
		dropdown17 = new Select(passyear2);
		dropdown17.selectByValue("2011");
    }
	public void selectExpMon2() {
		dropdown18 = new Select(expmon2);
		dropdown18.selectByValue("03");
    }
	public void selectExpday2() {
		dropdown19 = new Select(expday2);
		dropdown19.selectByValue("05");
    }
	public void selectExpyear2() {
		dropdown20 = new Select(expyear2);
		dropdown20.selectByValue("2030");
    }
	public void clickPayment() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		payment.sendKeys(Keys.SPACE);
	}
	public void clickConfirm() throws InterruptedException {
		//Add Assertion for Total Price
		 WebElement TotalPrice = driver.findElement(By.xpath("//body/div[2]/form[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/strong[1]/div[1]/ul[2]/li[3]/strong[1]"));
	        Assert.assertEquals(true, TotalPrice.isEnabled());
	        System.out.println("Assert Passed and The total price is:"+TotalPrice.getText());
        //Click on Checkbox by continuing and reading
		JavascriptExecutor js = (JavascriptExecutor)driver;    
        js.executeScript("document.getElementById(\"agreechb\").click();");
		
	}
	public void clickBooking() throws InterruptedException {
		//Click on Confirm Booking
		JavascriptExecutor js1 = (JavascriptExecutor)driver;   
        js1.executeScript("document.getElementById(\"booking\").click();");
		
	}

	

}