package PhpTravels;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestPageFactory {
	String drivePath="C:\\Users\\User\\Desktop\\seleminuJars\\chromedriver_win32\\chromedriver.exe";
	WebDriver driver;
	HomePage objHomePage;
	LoginPage objLoginPage;
	SearchPage objSearchPage;
	FlightsPage objFlightsPage;
	FlightBookingPage objFlightBookingPage;
	FlightInvoicePage objFlightInvoicePage;
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", drivePath);
		driver=new ChromeDriver();
		driver.get("https://phptravels.net/login");
		
	}
	 		
	@Test(priority=0)
	public void test_Home_Page_Appear() throws IOException, InterruptedException {
		//Reading values from excel
		FileInputStream fis = new FileInputStream("C:\\\\Users\\\\User\\\\Desktop\\\\seleminuJars\\\\datasource\\\\login.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet ws = workbook.getSheetAt(0);


				objLoginPage=new LoginPage(driver);
			 XSSFCell email= ws.getRow(1).getCell(0);
		        XSSFCell password= ws.getRow(1).getCell(1);
			    objLoginPage.login(email.toString(),password.toString());
			
	
					HomePage objHomePage = new HomePage(driver);
					objHomePage.clickflights();
					objHomePage.clickcurrency();
					objHomePage.clickINR();
			   
					SearchPage objSearchPage = new SearchPage(driver);
					objSearchPage.clickFlightSearch(); 
					objSearchPage.clickFlightType();					
					XSSFCell strFlyingFrom=ws.getRow(3).getCell(0);
					XSSFCell strFlyingTo=ws.getRow(3).getCell(1);
					String ss= strFlyingTo.toString();
					XSSFCell strDepartureDate=ws.getRow(3).getCell(2);
					objSearchPage.setFlyingFrom(strFlyingFrom.toString());
					objSearchPage.setFlyingTo(ss);
					objSearchPage.DepartureDate.clear();
					objSearchPage.setDepartureDate(strDepartureDate.toString());
					objSearchPage.clickpassenger();
					
					objSearchPage.clickAdd();
					objSearchPage.clickpassenger1();
					objSearchPage.clickSearch();
					
					FlightsPage objFlightsPage = new FlightsPage(driver);
					objFlightsPage.clickDirect();
					objFlightsPage.FlightTypeDirect();
					objFlightsPage.clickBookNow();
					
					
					FlightBookingPage objFlightBookingPage=new FlightBookingPage(driver);
					  objFlightBookingPage.clickTitle();
					  XSSFCell strfirstname1=ws.getRow(5).getCell(0);
					  objFlightBookingPage.setfirstname1(strfirstname1.toString());
					  XSSFCell strlastname1=ws.getRow(5).getCell(1);
					  objFlightBookingPage.setlastname1(strlastname1.toString());
					  objFlightBookingPage.selectCountry1();
					  objFlightBookingPage.selectMonth1();
					  objFlightBookingPage.selectDay1();
					  objFlightBookingPage.selectYear1();
					  XSSFCell strpassport=ws.getRow(5).getCell(2);
					  objFlightBookingPage.setpassport1(strpassport.toString());
					  objFlightBookingPage.selectPassmonth1();
					  objFlightBookingPage.selectPassday1();
					  objFlightBookingPage.selectPassyear1();
					  objFlightBookingPage.selectExpMon1();
					  objFlightBookingPage.selectExpday1();
					  objFlightBookingPage.selectExpyear1();
					  XSSFCell strfirstname2=ws.getRow(7).getCell(0);
					  objFlightBookingPage.setfirstname(strfirstname2.toString());
					  XSSFCell strlastname2=ws.getRow(7).getCell(1);
					  objFlightBookingPage.setlastname(strlastname2.toString());
					  objFlightBookingPage.selectCountry2();
					  objFlightBookingPage.selectMonth2();
					  objFlightBookingPage.selectDay2();
					  objFlightBookingPage.selectYear2();
					  XSSFCell strpassport2=ws.getRow(7).getCell(2);
					  objFlightBookingPage.setpassport2(strpassport2.toString());
					  objFlightBookingPage.selectPassmonth2();
					  objFlightBookingPage.selectPassday2();
					  objFlightBookingPage.selectPassyear2();
					  objFlightBookingPage.selectExpMon2();
					  objFlightBookingPage.selectExpday2();
					  objFlightBookingPage.selectExpyear2();
					  objFlightBookingPage.clickPayment();
					  objFlightBookingPage.clickConfirm();
					  
					  objFlightBookingPage.clickBooking();
					
					FlightInvoicePage objFlightInvoicePage = new FlightInvoicePage(driver);
					
					//objFlightInvoicePage.clickPaymentType();
					objFlightInvoicePage.clickProceed();
					
					
			    }
			    
}
			    
			    
			    
			    

		

