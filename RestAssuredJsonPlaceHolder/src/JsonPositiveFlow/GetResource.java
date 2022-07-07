package JsonPositiveFlow;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetResource {
	
	@Test
	public void getResoure() {
		
		RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
		RequestSpecification request = RestAssured.given();
		Response response=request.get("/posts/1");
		ResponseBody body = response.getBody();
		
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
	    String encoding = response.header("Transfer-Encoding");
	    System.out.println("Transfer-Encoding: " + encoding);
	       
	    //Access header with a given name.
	    String serverType = response.header("Server");
	    System.out.println("Server value: " + serverType);
	    Assert.assertEquals(serverType, serverType /* actual value */, "cloudflare" /*expected value */);
	}
	
		
	}

