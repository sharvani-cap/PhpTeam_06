package PhpTravels;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchPage {

	WebDriver driver;
	
	@FindBy(xpath="//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/button[1]")
	WebElement FlightSearch;
		
	@FindBy(xpath="//select[@id='flight_type']") 
	WebElement FlightType;
	
	Select dropdown;

	
	
	@FindBy(id="autocomplete")
	WebElement FlyingFrom;
	
	@FindBy(id="autocomplete2")
	WebElement FlyingTo;
		
	@FindBy(id="departure")
	WebElement DepartureDate;
	
	@FindBy(xpath="//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[3]/div[1]/div[1]/div[1]/a[1]")
	WebElement passenger;
	
	@FindBy(xpath="//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/i[1]")
	WebElement Add;
	
	@FindBy(xpath="//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[3]/div[1]/div[1]/div[1]/a[1]")
	WebElement passenger1;
		
	@FindBy(id="flights-search")
	WebElement Search;
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		//Get the Title of SearchPage
		String SearchPageTitle=driver.getTitle();
	      System.out.println("The title of the Searchpage is :"+SearchPageTitle);
	}
		
		public void clickFlightSearch() {
			FlightSearch.click();
	
}
		public void clickFlightType() {
			dropdown = new Select(FlightType); 
			//FlightType.click();
			dropdown.selectByValue("economy_premium");
			
}
		public void  setFlyingFrom(String strFlyingFrom) {
			//Enter the details
			FlyingFrom.sendKeys(strFlyingFrom);
}
		public void  setFlyingTo(String strFlyingTo) {
			//Enter the details
			FlyingTo.sendKeys(strFlyingTo);
	
		}
		
		public void  setDepartureDate(String strDepartureDate)
		{
			//Select departure date
			DepartureDate.clear();
	
			DepartureDate.sendKeys(strDepartureDate);
			
        }
		public void clickpassenger() {
			//select how many passengers are Travelling
			passenger.click();
	
           }
		public void clickAdd() throws InterruptedException {
			
			 WebDriverWait wait3 = new WebDriverWait(driver,Duration.ofSeconds(10));
		        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/i[1]"))); 
		     //click to add passenger   
			Add.click();
	
        }
		public void clickpassenger1() {
			passenger1.click();
	
         }
		public void clickSearch() {
			//Click on search
			Search.click();
	
        }

			
		}
