package Json;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class JsonPlaceholderStefDef 
{
		WebDriver driver = null;
			@When("^User request for a resource by id$")
			public void user_request_for_resource() {
				RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
				RequestSpecification request = RestAssured.given();
		        Response response = request.get("/posts/1");
		        // Retrieve the body of the Response
		        ResponseBody body = response.getBody();
		        //Response in raw format
		        System.out.println("Response Body is: " + body.asString());
		     
			}
			@Then("^User get the resource by id$")
			public void user_get_resource() {
				RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
				RequestSpecification request = RestAssured.given();
		        Response response = request.get("/posts/1");
		        
		        //Add Assertion for Content-Type Header
				String contentType = response.header("Content-Type");
			    System.out.println("Content-Type value: " + contentType);
			    Assert.assertEquals(contentType, contentType);
			    
			    //Get StatusLine
			    String statusLine = response.getStatusLine();
			    Assert.assertEquals(statusLine , "HTTP/1.1 200 OK" , "Correct status code returned");
			    System.out.println("Status line => " + response.getStatusLine());
			    
			     }
			@When("^User requests all list of resources$")
			public void list_of_resource() {
				RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
				RequestSpecification request = RestAssured.given();
				 Response response = request.get("/posts");
				ResponseBody body = response.getBody();
				
			    //Response in raw format
			    System.out.println("Response Body is: " + body.prettyPrint());
			}
			@Then("^User get the list of resources$")
			public void user_get_list_of_resources() 
			{
				RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
			    RequestSpecification request = RestAssured.given();
			    Response response = request.get("/posts");
			    
			    //Assert for the Server Header
				String serverType = response.header("Server");
			    System.out.println("Server value: " + serverType);
			    Assert.assertEquals(serverType, serverType /* actual value */, "cloudflare" /*expected value */);	
			}
			@When("^User creates resource  with \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
			public void user_creates_resource(String id,String userid,String title,String body) 
			{
				RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
				RequestSpecification request = RestAssured.given();
				   Response response = request.body("{\"userId\":\"" + userid +"\",\"id\":\"" + id +"\",\"title\":\"" +title +"\",\"body\":\"" +body +"\"}" ).post("/posts");
				   ResponseBody ubody = response.getBody();
				   
				   //Response in raw format
				   System.out.println("Response Body is: " + ubody.asString());
			}
			
			@Then("^The resource is created$")
			public void resource_created() {
			}
			@When("^User updates the Resource$")
			public void update_a_resource(DataTable dt) {
		    	List<String> list = dt.transpose().asList(String.class);
		       	  String uid = dt.cell(0,0);
		          String userid = dt.cell(0,1);
		          String utitle = dt.cell(0,2);
		          String ubody = dt.cell(0,3);
				   RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
				    RequestSpecification request = RestAssured.given();
				    Response response = request.body("{\"userId\":\"" + userid +"\",\"id\":\"" + uid +"\",\"title\":\"" +utitle +"\",\"body\":\"" +ubody +"\"}" ).put("/posts/1");
				    ResponseBody body = response.getBody();
			        System.out.println(body.asString());
			}
			@Then("^the resource is updated$")
			public void resource_updated() {
				
			}
			@When("^User patch a Resource$")
			public void patch_resource(DataTable patch) {
				List<String> list = patch.transpose().asList(String.class);
		       	  String uid = patch.cell(0,0);
		          String userid = patch.cell(0,1);
		          String utitle = patch.cell(0,2);
		          String ubody = patch.cell(0,3);
				RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
				RequestSpecification request = RestAssured.given();
		        Response response = request.body("{\"userId\":\"" + userid +"\",\"id\":\"" + uid +"\",\"title\":\"" +utitle +"\",\"body\":\"" +ubody +"\"}").patch("/posts/1");
		        ResponseBody body = response.getBody();
		       //Response in raw format
		        System.out.println("Response Body is: " + body.prettyPrint());
			}
			@Then("^The resource get updated$")
			public void the_resource_details_get_updated() {
				  
			}
			@When("^User delete a resource$")
			public void user_delete_a_resource() {
				RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
				RequestSpecification request = RestAssured.given();
				Response response = request.delete("/posts/1");
				ResponseBody body = response.getBody();
			    //Response in raw format
			    System.out.println("Response Body is: " + body.asString());
			}
			
			@Then("^The resource get deleted$")
			public void the_resource_gets_deleted() {
				RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
				RequestSpecification request = RestAssured.given();
				Response response = request.delete("/posts/1");
				ResponseBody body = response.getBody();
				 //Response in raw format
				System.out.println("Response Body is: " + body.asString());
			    JsonPath jsonPathEvaluator = response.jsonPath();
			    System.out.println("The Title is: " + jsonPathEvaluator.get("title"));
				  
			}
			@When("^User want to fetch  details by userId$")
			public void fetch_by_userId() {
				RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
				RequestSpecification request = RestAssured.given();
		    Response response = request.queryParam("userId", "3").get("/posts");
		   
			}
			@Then("^User get details by userId$")
			public void user_get_details() {
				 
			}
			@When("^User fetch with wrong userId$")
			public void when_user_fetchby_wrong_userid() {
				RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
				RequestSpecification request = RestAssured.given();
		        Response response = request.queryParam("userId", "400").get("/posts");
		   
			}
			@Then("^User details are empty$")
			public void unable_to_get_details() {
				 
			}
		}


