package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.json.JSONObject;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;
import testdata.addapitestdata;
import utils.resource;
import utils.utils;

public class AddplaceAPI {

	RequestSpecification req;
	static RequestSpecification reqs;
	static ResponseSpecification resp;
	static Response apiresponse;
	public static String place_id;
	// AddplaceAPI apa=new AddplaceAPI();

	@Given("Add Place Payload {string} and {string} and  {string}")
	public void add_place_payload_and_and(String name, String address, String language) throws FileNotFoundException {
		// Write code here that turns the phrase above into concrete actions
		reqs = given().log().all().spec(utils.requestspec())
				.body(addapitestdata.addapipost(name, address, language));

		resp = new ResponseSpecBuilder().expectStatusCode(200).build();
	}

	@Given("Add Place Payload")
	public void add_place_payload() throws FileNotFoundException {
		// Write code here that turns the phrase above into concrete actions

		reqs = given().log().all().spec(utils.requestspec())
				.body(addapitestdata.addapipost("First house", "50, side layout, cohen 09", "French-IN"));

		resp = new ResponseSpecBuilder().expectStatusCode(200).build();

	}

	// @Test (priority=0)
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String apiname, String method) throws IOException {
		// Write code here that turns the phrase above into concrete actions

		if (method.equalsIgnoreCase("POST"))

		{

			resource res = resource.valueOf(apiname);
			apiresponse = reqs.when().post(utils.apiprop("baseurl") + res.getresource()).then().spec(resp).extract()
					.response();
		} else if (method.equalsIgnoreCase("GET"))

		{
			resource res = resource.valueOf(apiname);
			apiresponse = reqs.when().get(utils.apiprop("baseurl") + res.getresource()).then().spec(resp).extract()
					.response();

		}
		System.out.println(apiresponse.asString());
		// throw new io.cucumber.java.PendingException();
	}

	// @Test (priority=1)
	@Then("the API call got success message with status code {int}")
	public void the_api_call_got_success_message_with_status_code(int statuscode) {
		// Write code here that turns the phrase above into concrete actions

		// System.out.println(addapiresponse.getStatusCode());

		assertEquals(apiresponse.getStatusCode(), statuscode);

		// throw new io.cucumber.java.PendingException();
	}

	// @Test (priority=2)
	@Then("{string} in the response body is {string}")
	public void in_the_response_body_is(String keyvalue, String value) {
		// Write code here that turns the phrase above into concrete actions

		assertEquals(utils.getjsonvalue(apiresponse,keyvalue),value );
	
	}

	@Then("{string} is added in the {string} with {string} http request")
	public void is_added_in_the_with_http_request(String name, String apiname, String method) throws IOException {
	
		
		place_id=utils.getjsonvalue(apiresponse,"place_id");
		reqs = given().spec(utils.requestspec()).queryParam("key", "qaclick123").queryParam("place_id", place_id);
		user_calls_with_http_request(apiname,method);
		assertEquals(utils.getjsonvalue(apiresponse,"name"),name );
		
	}
	
	@Given("Delete Place Payload")
	public void delete_place_payload() throws FileNotFoundException {
	    // Write code here that turns the phrase above into concrete actions
	   JSONObject jo =new JSONObject();
	   jo.put("place_id",place_id);
	   
	   reqs=given().log().all().spec(utils.requestspec()).queryParam("key", "qaclick123").body(jo.toString());
	}
	
	
	@Before("@DeletePlace")
	public void adddeleteapi() throws IOException
	
	{
		AddplaceAPI sd =new AddplaceAPI();
		
		if (AddplaceAPI.place_id==null)
			
		{
		
			sd.add_place_payload_and_and("vina", "1213 Bond Street", "ENGLISH");
			sd.user_calls_with_http_request("AddPlaceAPI", "POST");
			sd.is_added_in_the_with_http_request("vina","GetPlaceAPI","GET");
					
			
		}
		
	}

		

}
