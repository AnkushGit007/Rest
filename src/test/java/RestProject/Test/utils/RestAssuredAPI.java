package RestProject.Test.utils;

import java.io.File;
import java.util.Map;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.ConnectionConfig;
import com.jayway.restassured.config.RestAssuredConfig;
import com.jayway.restassured.response.Response;

public class RestAssuredAPI {

	/**setBaseURL method sets baseURL
	 * @param baseURL
	 */
	public static void setBaseURL(String baseURL)
	{
		try
		{
			if(!baseURL.isEmpty()||!baseURL.contains(null))
			{
				RestAssured.baseURI = baseURL;
			}}catch (NullPointerException e) {
				System.out.println("Base URL is set as null");
			}	
	}

	public static String POST(String baseURL, String body) {
		setBaseURL(baseURL);
		Response resp = RestAssured.given()
				.body(body)
				.post()
				.andReturn();
		System.out.println("running POST command");
		System.out.println("Response body \n" + resp.getBody().asString());
		System.out.println("Status Code \n" + resp.getStatusCode());
		System.out.println("Time taken to get response is \n" + resp.getTime()+" milli second");
		return resp.getBody().asString();
	}

	public static int  PUT(String baseURL, String body) {
		setBaseURL(baseURL);
		Response resp = RestAssured.given()
				.body(body)
				.put()
				.andReturn();
		System.out.println("running PUT command");
		System.out.println("Response body \n" + resp.getBody().asString());
		System.out.println("Status Code \n" + resp.getStatusCode());
		System.out.println("Time taken to get response is \n" + resp.getTime()+" milli second");
		return resp.getStatusCode();
	}
	public static Response Delete(String baseURL, String body) {
		setBaseURL(baseURL);
		Response resp = RestAssured.given()
				.body(body)
				.delete()
				.andReturn();
		System.out.println("running DELETE command");
		System.out.println("Response body \n" + resp.getBody().asString());
		System.out.println("Status Code \n" + resp.getStatusCode());
		System.out.println("Time taken to get response is \n" + resp.getTime()+" milli second");
		return resp;
	}
}
