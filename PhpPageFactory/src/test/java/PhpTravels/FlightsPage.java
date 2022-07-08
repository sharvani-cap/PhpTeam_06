package PhpTravels;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

package PhpTravels;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FlightsPage {

	WebDriver driver;
  @FindBy(id="direct")
   WebElement Direct;
   
    @FindBy(xpath="//body/main[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/fieldset[1]/div[1]/ul[1]/li[2]/div[1]/label[1]")
    WebElement FlightTypeDirect;
    
    @FindBy(xpath="//body/main[1]/div[1]/div[2]/section[1]/ul[1]/li[4]/div[1]/form[1]/div[1]/div[2]/div[1]/button[1]") 
    WebElement BookNow;
    
    public FlightsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		 //Get the Title Of FlightPage
		String FlightPageTitle=driver.getTitle();
        System.out.println("The title of the Flightpage is : "+FlightPageTitle);
	}
  //Apply Filters For FlightBooking
    public void clickDirect() {
    	//Assertion For Travelling Dates(07-07-2022 to 11-07-22) are displayed in Flights Page
    	WebElement Dates = driver.findElement(By.xpath("//strong[contains(text(),'Dates')]"));
        Assert.assertEquals(true, Dates.isDisplayed());
        System.out.println("Date is displayed – Assert passed");
      //Select Direct Flight
		Direct.click();
}
	public void FlightTypeDirect() throws InterruptedException 
	{   //Select Direct Flight
		Thread.sleep(2000);
		FlightTypeDirect.click();
}

	public void clickBookNow() throws InterruptedException {
		//Click on BookNow
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		BookNow.click();
}
}
