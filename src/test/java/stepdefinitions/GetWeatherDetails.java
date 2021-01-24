package stepdefinitions;

import java.io.FileNotFoundException;
import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.Utils;

public class GetWeatherDetails extends Utils {
//	
	RequestSpecification reqSpec;
	Response response;
	String placeName;
	String placeId;
	List<String> weatherStatus;
	List<String> countPlaceId;

	@Given("User has the {string} place name")
	public void user_has_the_place_name(String place) {

		placeName = place;
		System.out.println("Searching weather status for :" + placeName);

	}

	@When("User calls {string} resource url with {string} http request")
	public void user_calls_resource_url_with_http_request(String resource, String APIMethod)
			throws FileNotFoundException {

		APIResources respAPI = APIResources.valueOf(resource);
		String placeResURL = respAPI.getResource() + "search/";

		response = getTheResponseAsPerAPIMethod(placeResURL, APIMethod, placeRequestSpecification(placeName));

	}

	@Then("API call is success with status code {string}")
	public void api_call_is_success_with_status_code(String statusCode) {

		String ActualStatusCode = Integer.toString(response.getStatusCode());
		Assert.assertEquals(ActualStatusCode, statusCode);
	}

	@Then("User get the Place ID {string}")
	public void user_calls_to_get_the_place_id(String placeIdJsonKey) {

		placeId = getJsonPath(response, placeIdJsonKey);
		placeId = placeId.replace("[", "").replace("]", "").trim();
		System.out.println("Place ID for "+placeName +" is :"+placeId);
	}

	@Then("User get the weather details of {string} for {string}")
	public void user_get_the_weather_details_of_for(String Place, String givenDate) throws FileNotFoundException {

		APIResources respAPI = APIResources.valueOf("GetPlaceAPI");
		String placeResURL = respAPI.getResource() + "location/" + placeId + "/" + givenDate;

		response = getTheResponseAsPerAPIMethod(placeResURL, "GET", placeRequestSpecification(placeName));

		weatherStatus = getListJsonPath(response, "weather_state_name");

		System.out.println(weatherStatus.get(0)+" is expected in "+placeName+ " for this given date "+ givenDate);

	}
	
	
	@Then("Verify {string} count is Equal to {int} for the given place")
	public void verify_count_is_equal_to_for_the_given_place(String placeIDKey, int givenCount) {
	    
		countPlaceId = getListJsonPath(response, placeIDKey);
		
		int placeidSize = countPlaceId.size();
		
		if(placeidSize>givenCount)
		{
			System.out.println(placeName + " WEOID count is "+ placeidSize+" which greater than 1");
			System.out.println("There are multiple places with same Place Name as :"+placeName);
			Assert.assertTrue(false);
		}
		else if(placeidSize==givenCount)
		{
			System.out.println(placeName+ " WEOID count is equal to 1");
			System.out.println(placeName + " is a Beautiful Place...");
			Assert.assertTrue(true);
		}
		
	}

}
