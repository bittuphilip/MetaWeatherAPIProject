package resources;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class Utils {
	
	public RequestSpecification req;
	private RequestSpecification postReqSpec;
	private static Response response;
	
	/*
	 * Method to Get the Request Specification to By Passing the Base URL and Query Parameter
	 */
	public RequestSpecification placeRequestSpecification(String PlaceName) throws FileNotFoundException
	{
		
		if(req == null)
		{
//		PrintStream log = new PrintStream(new FileOutputStream("APITestlogs.text"));
		req =new RequestSpecBuilder().setBaseUri(getGlobalVar("baseURL")).addQueryParam("query", PlaceName)
//				.addFilter(RequestLoggingFilter.logRequestTo(log))
//				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		
		return req;
		}
		return req;
		
		
	}
	
	
	/*
	 *Method to add the body data in request specification
	 */
	public RequestSpecification addData(String addBody,RequestSpecification reqSpecification) throws FileNotFoundException
	{
		 postReqSpec = given().spec(reqSpecification).body(addBody);
		 return postReqSpec;
	}

	
	
	/*Method to Get the response and POST the data
	 * Need to Pass the Resource URL , API Method(GET/POST) 
	 * and Request Specification value(For POST Resource URL need to pass "addData method" and 
	 * To Get Response need to pass "placeRequestSpecification method" )
	 */
	public Response getTheResponseAsPerAPIMethod(String ResourceURL,String APIMethod,RequestSpecification reqSpecification) throws FileNotFoundException
	{
				
		if (APIMethod.equalsIgnoreCase("POST")) {
			response = reqSpecification.when().post(ResourceURL);

			
		} else if (APIMethod.equalsIgnoreCase("GET")) {
			
			response = given(reqSpecification).when().get(ResourceURL);
//					
		}
		return response;
	}
	
	
	/*
	 * Method to read the Global Property file by passing the Key
	 */
	public static String getGlobalVar(String key) throws FileNotFoundException
	{
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./src/main/java/resources/global.properties");
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop.getProperty(key);
	}

	
	
	/*
	 * Method to Get the Json Node Value by Passing the Key and Response
	 */
	public String getJsonPath(Response response,String key)
	{
		JsonPath js = new JsonPath(response.asString());
		
		String keyVal= js.get(key).toString();
		
		return keyVal;
	}
	
	/*
	 * Method to return the List of Json data
	 */	
	public static List<String> getListJsonPath(Response response,String key)
	{
		JsonPath js = new JsonPath(response.asString());
		List<String> stringArray = js.getList(key);
		 
		return stringArray;
		 
	}
	
}
