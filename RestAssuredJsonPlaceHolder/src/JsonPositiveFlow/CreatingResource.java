package JsonPositiveFlow;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class CreatingResource {
	@Test
	public void createResource() {
		RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
		RequestSpecification request = RestAssured.given();
     Response response = request.body("{\"userId\": 1,\"id\": 3,\"title\":\"Resource\",\"body\":\"Creating and Listing Resource}").post("/posts");
      // Retrieve the body of the Response
      ResponseBody body = response.getBody();
      //Response in raw format
      System.out.println("Response Body is: " + body.asString());

    //Assert that correct status code is returned.
      int statusCode = response.getStatusCode();
      Assert.assertEquals(statusCode /* actual value*/, 201 /*expected value */, "Successful");
    //Assert Status line
      String statusLine = response.getStatusLine();
      Assert.assertEquals(statusLine /* actual value*/, "HTTP/1.1 201 Created" /*expected value */, "Correct status code returned");
      Assert.assertEquals(201,response.getStatusCode());
	  System.out.println("The status code is:" + response.getStatusCode());
    //Access header with a given name.
       String contentType = response.header("Content-Type");
       System.out.println("Content-Type value: " + contentType);
       Assert.assertEquals(contentType, contentType);
    //Access header with a given name. Header = Content-Encoding
      String server = response.header("Server");
      System.out.println("Server : " + server);
      
}
}
