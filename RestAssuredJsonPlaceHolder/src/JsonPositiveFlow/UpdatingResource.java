package JsonPositiveFlow;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class UpdatingResource {
	@Test
    public void UpdateUser() throws IOException {
      FileInputStream fis = new FileInputStream("C:\\Users\\vsharvan\\Desktop\\selenium\\DataSource\\JSON.xlsx");
      //Read Date From Excel
        	XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet ws = workbook.getSheetAt(0);
            int rownum  = ws.getLastRowNum();
            int colnum = ws.getRow(1).getPhysicalNumberOfCells();
            System.out.println(colnum);
            System.out.println(rownum);
            XSSFCell uid;
            XSSFCell utitle;
            XSSFCell ubody;
            XSSFCell userid;
            for(int i = 1; i <= rownum ; i++) {   
                uid=ws.getRow(i).getCell(0);
                utitle=ws.getRow(i).getCell(1);
                ubody=ws.getRow(i).getCell(2);
                userid=ws.getRow(i).getCell(3);
                //Base Url
                RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
                //Print the uid,utitle,ubody,userId
                System.out.println(uid.toString());
                System.out.println(utitle.toString());
                System.out.println(ubody.toString());
                System.out.println(userid.toString());
                
                RequestSpecification request = RestAssured.given();
                Response response = request.body("{\"id\":\"" + uid +"\",\"title\":\"" +utitle +"\",\"body\":\"" +ubody +"\",\"userId\":\"" +userid +"\"}" ).put("/posts/"+uid);
                ResponseBody body = response.getBody();
                //Response in raw format
                System.out.println(body.asString());
                
                System.out.println("Response Body is: " + body.asString());
                //Add Assertion for Header of ServerTYpe
        	    String serverType = response.header("Server");
        	    System.out.println("Server value: " + serverType);
        	    Assert.assertEquals(serverType, serverType /* actual value */, "cloudflare" /*expected value */);
        	    
        	   
         }
     }
	
}