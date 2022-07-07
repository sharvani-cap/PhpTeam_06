package JsonPositiveFlow;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ListingAllResources {
	@Test
	public void listAll() {
		RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
		RequestSpecification request = RestAssured.given();
    Response response = request.get("/posts");
    // Retrieve the body of the Response
    ResponseBody body = response.getBody();
    //Response in raw format
    System.out.println("Response Body is: " + body.prettyPrint());
    int statusCode = response.getStatusCode();
    Assert.assertEquals(statusCode , 200 , "Successful");
    System.out.println("Status code => " + response.getStatusCode());
    String statusLine = response.getStatusLine();
    Assert.assertEquals(statusLine , "HTTP/1.1 200 OK" , "Correct status code returned");
    System.out.println("Status line => " + response.getStatusLine());
  //Access header with a given name.
    String contentType = response.header("Content-Type");
    System.out.println("Content-Type value: " + contentType);
    Assert.assertEquals(contentType, contentType);
  //Access header with a given name. Header = Content-Encoding
    String encoding = response.header("Content-Encoding");
    System.out.println("Content-Encoding: " + encoding);
    
	}
}