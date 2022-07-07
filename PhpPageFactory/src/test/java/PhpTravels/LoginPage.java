package PhpTravels;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(className="form-control")
    WebElement email;
    @FindBy(xpath="//input[@name='password']")
    WebElement password;    
    @FindBy(xpath="//body/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[3]/button[1]")
    WebElement Login;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		 // Get the Title of Loginpage
		String LoginTitle=driver.getTitle();
		System.out.println("The title of the Loginpage is :"+LoginTitle);
		
	}

	public void  setEmail(String strEmail) {
		//Enter email
		email.sendKeys(strEmail);
	}
	public void setPassword(String strPassword) {
		//Enter Password
		password.sendKeys(strPassword);
	}
	public void clickLogin() {
		//Click on login
		Login.click();
	}
	public void login(String strEmail,String strPassword) {
		this.setEmail(strEmail);
		this.setPassword(strPassword);
        this.clickLogin();
	}
}