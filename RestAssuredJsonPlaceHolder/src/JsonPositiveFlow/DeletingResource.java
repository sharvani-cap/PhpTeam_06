package JsonPositiveFlow;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class DeletingResource {
	@Test
	public void getUser() {
		RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
		RequestSpecification request = RestAssured.given();
    Response response = request.get("posts/1");
    // Retrieve the body of the Response
    ResponseBody body = response.getBody();
    //Response in raw format
    
  //Assert that correct status code is returned
    int statusCode = response.getStatusCode();
    Assert.assertEquals(statusCode , 200 , "Successful");
    System.out.println("Status code => " + response.getStatusCode());
    
    //Assert Status line
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
    
    //Access header with a given name.
    String serverType = response.header("Server");
    System.out.println("Server value: " + serverType);
    Assert.assertEquals(serverType, serverType /* actual value */,"cloudflare"/*expected value */);
    
    System.out.println("Response Body is: " + body.asString());
    JsonPath jsonPathEvaluator = response.jsonPath();
    System.out.println("The Title is: " + jsonPathEvaluator.get("title"));
    }
}