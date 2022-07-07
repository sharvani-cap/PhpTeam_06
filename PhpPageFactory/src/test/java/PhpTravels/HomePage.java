package PhpTravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

	WebDriver driver;
    
	@FindBy(xpath="//a[contains(text(),'flights')]")
	WebElement flights;
	    
	@FindBy(id="currency")
	WebElement currency;
 
    @FindBy(xpath="//a[contains(text(),'INR')]")
    WebElement INR;
 
    
    public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		//Get the Title of HomePage
		String HomePageTitle=driver.getTitle();
	      System.out.println("The title of the Homepage is :"+HomePageTitle);
	      //add Assertion for Welcome Message
	      if(driver.findElement(By.xpath("//span[contains(text(),'Demo')]")).isEnabled()) {
	          System.out.println("Hi ,Demo Welcome Back");
	      }
}

	public void clickflights() {
		//Click on  Flights
		flights.click();
		
	}
	public void clickcurrency() {
		//Click on Currency
		currency.click();
		
	}
	public void clickINR() {
		//Select INR Currency
		INR.click();
		
	}
}
