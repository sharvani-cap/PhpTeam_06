package FlightBooking;


import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PhpStepDef {
	WebDriver driver = null;
	@Given("^User have the base URL$")
	public void user_navigates_to_AP_loginpage(){
		
		System.setProperty("webdriver.chrome.driver","");
		driver=new ChromeDriver();
        driver.get("https://phptravels.net/login");
	}
	
	@When("^User enters credentails on Loginpage$")
	public void user_enters_valid_credentials(DataTable login) {
		List<List<String>> data = login.cells();
		 driver.navigate().to("https://phptravels.net/login"); 
        //Enter credentials
        driver.findElement(By.name("email")).sendKeys(data.get(0).get(0));
        driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
        driver.findElement(By.className("ladda-label")).click();
		}

	@Then("^User should be redirected to PhpTravels Home Page$")
	public void user_Homepage_Successful() throws InterruptedException 
	{
		//Get the title of HomePage
		  String HomePageTitle=driver.getTitle();
	      System.out.println("The title of the Homepage is :"+HomePageTitle);
	      
	    //Validating the Welcome Message of HomePage
	      if(driver.findElement(By.xpath("//span[contains(text(),'Demo')]")).isEnabled()) {
	          System.out.println("Hi ,Demo Welcome Back");
	      }
	}
	@When("^User click on Flights button$")
	public void user_click_on_Flights() throws InterruptedException {
       		
        driver.findElement(By.xpath("//a[contains(text(),'flights')]")).click(); 
		}
	@Then("^User should be redirected to Search Page$")
	public void user_Searchpage_Successful() throws InterruptedException 
	{
		//Get the Title of SearchPage
	      String SearchPageTitle=driver.getTitle();
	      System.out.println("The title of the Searchpage is :"+SearchPageTitle);
	}
	@When("^User click on Currency button$")
	public void user_click_on_currency() throws InterruptedException {	
		Thread.sleep(2000);
		 
		driver.findElement(By.id("currency")).click();
	}
	@And ("^User Select INR Currency$")
	public void user_select_inr() throws InterruptedException
	{ 
		//Change the Currency to Indian Currency
		driver.findElement(By.xpath("//a[contains(text(),'INR')]")).click();
		Thread.sleep(2000);
     }
	@Then("^The Currency is  Changed Successfully $")
	public void changed_Successful() throws InterruptedException 
	{
	}	
	@When("^User click on flights tab$")
	public void User_click_on_flights(DataTable searchflight) throws InterruptedException {
       	driver.findElement(By.xpath("//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/button[1]")).click();
       	
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@And ("^User enters FlyingFrom,FlyingTo$")
	public void user_enter_details(DataTable searchflight) throws InterruptedException
	{
		Select type= new Select(driver.findElement(By.xpath(("//select[@id='flight_type']"))));
	     type.selectByValue("economy_premium");
	     
	     List<List<String>> search = searchflight.cells();
	     //Enter Data
       driver.findElement(By.id("autocomplete")).sendKeys(search.get(0).get(0));
       driver.findElement(By.id("autocomplete2")).sendKeys(search.get(0).get(1));
       driver.findElement(By.id(("departure"))).click();
       driver.findElement(By.xpath(("//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[3]/div[1]/div[1]/div[1]/a[1]"))).click();
       Thread.sleep(5000);
       driver.findElement(By.xpath(("//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/i[1]"))).click();
       driver.findElement(By.xpath(("//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[3]/div[1]/div[1]/div[1]/a[1]"))).click();
     }
	
	@And("^User click on Search$")
	public void User_click_on_Search() throws InterruptedException 
	{
		//Click on search button
		 driver.findElement(By.id(("flights-search"))).click();
	}
  @Then("^User should be redirected to FlightsPage$")
     public void User_redirected_to_FlightPage() {      
	  //Get the Title Of FlightPage
      String FlightPageTitle=driver.getTitle();
      System.out.println("The title of the Flightpage is : "+FlightPageTitle);
      
    //Add Assertion for the dates you are travelling(07-07-2022 to 11-07-2022)
      WebElement Dates = driver.findElement(By.xpath("//strong[contains(text(),'Dates')]"));
      Assert.assertEquals(true, Dates.isDisplayed());
      System.out.println("Date is displayed – Assert passed");
	 }
  
  @When("^User select Direct Flight and Indigo Flights$")
		 public void User_clicks(){
	     //Apply Filters For FlightBooking
		 driver.findElement(By.id("direct")).click();
		   //Select the Type of IndigoFlight
		 driver.findElement(By.xpath("//body/main[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/fieldset[1]/div[1]/ul[1]/li[1]/div[1]/label[1]")).click();
		
		 }
  @Then("^The filtered flights are displayed$")
          public void flights_displayed()
         {
	     } 
  
  @When("^User click on Booknow$")
		 public void User_click_on_Booknow() {
	            
			 driver.findElement(By.xpath(("//body/main[1]/div[1]/div[2]/section[1]/ul[1]/li[2]/div[1]/form[1]/div[1]/div[2]/div[1]/button[1]"))).click();
		 }

    @Then("^ User should be redirected to FlightBookingPage$")
			public void FlightBookingPage() {
    	//Get the Title of FlightBookingPage
        String FlightBookingPage=driver.getTitle();
        System.out.println("The title of the FlightBookingpage is :"+FlightBookingPage);
    }
			
	@When("^user enters the details$")
			public void Travellers_information() {
		//Traveller Details
		 Select title= new Select(driver.findElement(By.name(("title_1"))));
	     title.selectByValue("Miss");
         driver.findElement(By.name(("firstname_1"))).sendKeys("Jack");
         driver.findElement(By.name(("lastname_1"))).sendKeys("Son");
         Select nation = new Select(driver.findElement(By.name((("Nation1")))));
         nation.selectByValue("IN");
         Select month = new Select(driver.findElement(By.name((("Month1")))));
         month.selectByValue("03");
         Select day = new Select(driver.findElement(By.name((("Day1")))));
         day.selectByValue("04");
         Select year = new Select(driver.findElement(By.name(("Year1"))));
         year.selectByValue("2002");

	}
	
	@And("^User selects the payment method$")
			public void payment_method() {
		       //Select the Payment Method
				WebElement Payment=driver.findElement(By.name(("payment_gateway")));
		        Payment.sendKeys(Keys.SPACE);
			}
	@And("^User clicks on ConfirmBooking$")
			public void confirm_booking() {
		//Click on Confirm Booking 
				JavascriptExecutor js1 = (JavascriptExecutor)driver;  
		        js1.executeScript("document.getElementById(\"booking\").click();");
			}
	@Then("^ User should be redirected to FlightInvoicePage and click on proceed$")
	   public void invoice_page() 
	    {
		//Get the Title of FlightInvoicePage
	      String FlightInvoice=driver.getTitle();
        System.out.println("The title of the FlightInvoicepage is :"+FlightInvoice);
        
		//Add Assertion for Total Price
        WebElement TotalPrice = driver.findElement(By.xpath("//body/div[2]/form[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/strong[1]/div[1]/ul[2]/li[3]/strong[1]"));
        Assert.assertEquals(true, TotalPrice.isEnabled());
        System.out.println("Assert Passed and The total price is:"+TotalPrice.getText());
					
			}
	@When("^User click on proceed$")
	         public void click_on_proceed() 
	 {    //Click on proceed
		 driver.findElement(By.xpath("//input[@id='form']")).click();
     }
	@Then("^Booking is successful$")
	         public void booking_successful() 
	 {
		//Assertion for BookingSuccessfull
		if(driver.findElement(By.xpath("//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/i[1]")).isDisplayed()) {
	          System.out.println("Thank you for Booking");
	       	      }
		//Add Assertion Reservation Number
        Assert.assertTrue(true, driver.findElement(By.xpath("//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/h3[1]/span[1]")).getText());
	       System.out.println("Assert Passed : " + driver.findElement(By.xpath("//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/h3[1]/span[1]")).getText());
     }
	}