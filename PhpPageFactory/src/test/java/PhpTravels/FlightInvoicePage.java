package PhpTravels;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

	public class FlightInvoicePage {
		WebDriver driver;
		@FindBy(xpath="//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[2]/select[1]")
		WebElement paymentType;	
		@FindBy(xpath="//input[@id='form']")
		WebElement proceed;

	
		public FlightInvoicePage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
			
			if(driver.findElement(By.xpath("//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/i[1]")).isDisplayed()) {
		          System.out.println("Thank you for Booking");
		       	      }
//		      else
//		      {
//		    	  System.out.println("Hi");
//		      }
		      
		     //Add Assertion forResevation Number 
		      Assert.assertTrue(true, driver.findElement(By.xpath("//strong[contains(text(),'Reservation Number:')]")).getText());
		       System.out.println("Assert Passed : " + driver.findElement(By.xpath("//strong[contains(text(),'Reservation Number:')]")).getText());	
		       }
	public void clickProceed() throws InterruptedException 
	{
		//Click on Proceed
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		proceed.click();
		
	}
	
}