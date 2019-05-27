package RestAssignment.RestAssignment;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;

import org.json.JSONObject;

public class RestMethods {
		
			public Response response ;
			
			String ResponseValue;
			
			String Output;
			
			int Code=0;
			
			
			
			// This Method to be used for REST API TESTING on Get Method when Authentication / Authorization is needed
		
		public Response RestAssured_GetMethod(String BaseURL,String Authorization,String Password,String GetDetailsURL)
		
		{
			RestAssured.baseURI=BaseURL;
			
			if (Authorization.equalsIgnoreCase("Authorization"))
		{
			response = 
					
					given()
					 
					 		.header("Content-Type","application/json")
					 
					 		.header(Authorization,Password)
					 		
					. when()
					 
					 		.get(GetDetailsURL)
					 		
					 .then()
					 
					 		.extract()
					 		
					 		.response();
			
			System.out.println("  STATUS CODE IS ====> " + response.getStatusCode());
			
			ResponseValue = response.getBody().asString();
			
			System.out.println("********************");
			 		
			System.out.println(ResponseValue);
			 
		}
		
		else
		{
		
				response = 
						
						given()
						 
						 		.header("Content-Type","application/json")
						 
						 		.auth().basic(Authorization, Password)
						 		
						. when()
						 
						 		.get(GetDetailsURL)
						 		
						 .then()
						 
						 		.extract()
						 		
						 		.response();
				
				System.out.println("  STATUS CODE IS ====> " + response.getStatusCode());
				
				ResponseValue = response.getBody().asString();
				
				System.out.println("********************");
					 		
					System.out.println(ResponseValue);
					 
			}
		
			return response;
			
		}
		
		// This Method to be used for REST API TESTING on Get Method only with URI and no Authorization Details Needed
		
		public Response RestAssured_GetMethod(String BaseURL,String GetDetailsURL)
			
			{
				RestAssured.baseURI=BaseURL;
				
					
				response = 
						
						given()
						 
						 		.header("Content-Type","application/json")				 
					 		
					 		
					. when()
					 
					 		.get(GetDetailsURL)
					 		
					 .then()
					 
					 		.extract()
					 		
					 		.response();
			
			System.out.println("\n");
			
			System.out.println(" *************** STATUS CODE IS ====> " + response.getStatusCode());
			
			ResponseValue = response.getBody().asString();
			
			System.out.println("\n");
			
			System.out.println("\n");
			
			System.out.println("********************");
			 		
			System.out.println(ResponseValue);
			
			return response;
		
		}
		
		// This Method to be used for REST API TESTING on POST Method only with URI and Payload as String
		
		public Response RestAssured_PostMethod(String BaseURL,String PostDetailsURL,String body)
		
		{
			RestAssured.baseURI=BaseURL;
			
			
			response = 
					
					given()
					 
					 		.header("Content-Type","application/json")
					 		.body(body)
					 		
					 		
					. when()
					 
					 		.post(PostDetailsURL)
					 		
					 .then()
					 
					 		.extract()
					 		
					 		.response();
			
			
			System.out.println("\n");
			
			System.out.println(" *************** STATUS CODE IS ====> " + response.getStatusCode());
			
			ResponseValue = response.getBody().asString();
			
			System.out.println("\n");
			
			System.out.println("\n");
			
			System.out.println("********************");
			 		
			System.out.println(ResponseValue);
			
			return response;
			
		}
		
		// This Method to be used for REST API TESTING on POST Method only with URI and Payload as File
		
		
		public Response RestAssured_PostMethod(String BaseURL,String PostDetailsURL, File file)
		
		{
			RestAssured.baseURI=BaseURL;
		
			response = 
					
					given()
					 
					 		.header("Content-Type","application/json")
					 		.body(file)
					 		
					 		
					. when()
					 
					 		.post(PostDetailsURL)
					 		
					 .then()
					 
					 		.extract()
					 		
					 		.response();
			
			
			System.out.println("\n");
			
			System.out.println(" *************** STATUS CODE IS ====> " + response.getStatusCode());
			
			ResponseValue = response.getBody().asString();
			
			System.out.println("\n");
			
			System.out.println("\n");
			
			System.out.println("********************");
			 		
			System.out.println(ResponseValue);
			
			return response;
			
		}
		
		
		// This Method to be used for REST API TESTING on POST Method only with URI and Payload as String With Authentication/Authorization
		
			public Response RestAssured_PostMethod(String BaseURL,String PostDetailsURL,String body,String Authorization,String Password)
			
			{
				
				if (Authorization.equalsIgnoreCase("Authorization"))
				{
					RestAssured.baseURI=BaseURL;
					
					
					response = 
							
							given()
							 
							 		.header("Content-Type","application/json")
							 		.header(Authorization,Password)
							 		.body(body)
							 		
							 		
							. when()
							 
							 		.post(PostDetailsURL)
							 		
							 .then()
							 
							 		.extract()
							 		
							 		.response();
					
					
					System.out.println("\n");
					
					System.out.println(" *************** STATUS CODE IS ====> " + response.getStatusCode());
					
					ResponseValue = response.getBody().asString();
					
					System.out.println("\n");
					
					System.out.println("\n");
					
					System.out.println("********************");
					 		
					System.out.println(ResponseValue);
				}
				
				else
				{
					RestAssured.baseURI=BaseURL;
					
					
					response = 
							
							given()
							 
							 		.header("Content-Type","application/json")
							 		.auth().basic(Authorization, Password)
							 		.body(body)
							 		
							 		
							. when()
							 
							 		.post(PostDetailsURL)
							 		
							 .then()
							 
							 		.extract()
							 		
							 		.response();
					
					
					System.out.println("\n");
					
					System.out.println(" *************** STATUS CODE IS ====> " + response.getStatusCode());
					
					ResponseValue = response.getBody().asString();
					
					System.out.println("\n");
					
					System.out.println("\n");
					
					System.out.println("********************");
					 		
					System.out.println(ResponseValue);
					
				}
				
				return response;
			}
		
		// This Method to be used for REST API TESTING on POST Method only with URI and Payload as File With Authentication/Authorization
			
		
			public Response RestAssured_PostMethod(String BaseURL,String PostDetailsURL, File file,String Authorization,String Password)
			
			{
				
				if(Authorization.equalsIgnoreCase("Authorization"))
				{
					RestAssured.baseURI=BaseURL;
					
					response = 
							
							given()
							 
							 		.header("Content-Type","application/json")
							 		.header(Authorization,Password)
							 		.body(file)
							 		
							 		
							. when()
							 
							 		.post(PostDetailsURL)
							 		
							 .then()
							 
							 		.extract()
							 		
							 		.response();
					
					
					System.out.println("\n");
					
					System.out.println(" *************** STATUS CODE IS ====> " + response.getStatusCode());
					
					ResponseValue = response.getBody().asString();
					
					System.out.println("\n");
					
					System.out.println("\n");
					
					System.out.println("********************");
					 		
					System.out.println(ResponseValue);
				}
				
				else
				{
					RestAssured.baseURI=BaseURL;
					
					response = 
							
							given()
							 
							 		.header("Content-Type","application/json")
							 		.auth().basic(Authorization, Password)
							 		.body(file)
							 		
							 		
							. when()
							 
							 		.post(PostDetailsURL)
							 		
							 .then()
							 
							 		.extract()
							 		
							 		.response();
					
					
					System.out.println("\n");
					
					System.out.println(" *************** STATUS CODE IS ====> " + response.getStatusCode());
					
					ResponseValue = response.getBody().asString();
					
					System.out.println("\n");
					
					System.out.println("\n");
					
					System.out.println("********************");
					 		
					System.out.println(ResponseValue);
				}
				
				return response;
				
				
			}
		
			
			// This Method to be used for REST API TESTING on PUT Method only with URI and Payload as String
			
			public Response RestAssured_PutMethod(String BaseURL,String PostDetailsURL,String body)
			
			{
				RestAssured.baseURI=BaseURL;
				
				
				response = 
						
						given()
						 
						 		.header("Content-Type","application/json")
						 		.body(body)
						 		
						 		
						. when()
						 
						 		.put(PostDetailsURL)
						 		
						 .then()
						 
						 		.extract()
						 		
						 		.response();
				
				
				System.out.println("\n");
				
				System.out.println(" *************** STATUS CODE IS ====> " + response.getStatusCode());
				
				ResponseValue = response.getBody().asString();
				
				System.out.println("\n");
				
				System.out.println("\n");
				
				System.out.println("********************");
				 		
				System.out.println(ResponseValue);
				
				return response;
				
			}
		
		// This Method to be used for REST API TESTING on PUT Method only with URI and Payload as File
			
		
			public Response RestAssured_PutMethod(String BaseURL,String PostDetailsURL, File file)
			
			{
				RestAssured.baseURI=BaseURL;
		
				response = 
						
						given()
						 
						 		.header("Content-Type","application/json")
						 		.body(file)
						 		
						 		
						. when()
						 
						 		.put(PostDetailsURL)
						 		
						 .then()
						 
						 		.extract()
						 		
						 		.response();
				
				
				System.out.println("\n");
				
				System.out.println(" *************** STATUS CODE IS ====> " + response.getStatusCode());
				
				ResponseValue = response.getBody().asString();
				
				System.out.println("\n");
				
				System.out.println("\n");
				
				System.out.println("********************");
				 		
				System.out.println(ResponseValue);
				
				return response;
				
			}
			
			
			// This Method to be used for REST API TESTING on PUT Method only with URI and Payload as String With Authorization/Authentication
			
			public Response RestAssured_PutMethod(String BaseURL,String PostDetailsURL,String body,String Authorization,String Password)
						
			{
				if(Authorization.equalsIgnoreCase("Authorization"))
				{
					RestAssured.baseURI=BaseURL;
					
					
					response = 
							
							given()
							 
							 		.header("Content-Type","application/json")
							 		.header(Authorization,Password)
							 		.body(body)
							 		
							 		
							. when()
							 
							 		.put(PostDetailsURL)
							 		
							 .then()
							 
							 		.extract()
							 		
							 		.response();
					
					
					System.out.println("\n");
					
					System.out.println(" *************** STATUS CODE IS ====> " + response.getStatusCode());
					
					ResponseValue = response.getBody().asString();
					
					System.out.println("\n");
					
					System.out.println("\n");
					
					System.out.println("********************");
					 		
					System.out.println(ResponseValue);
				}
				
				else
				{
					RestAssured.baseURI=BaseURL;
					
					
					response = 
							
							given()
							 
							 		.header("Content-Type","application/json")
							 		.auth().basic(Authorization, Password)
							 		.body(body)
							 		
							 		
							. when()
							 
							 		.put(PostDetailsURL)
							 		
							 .then()
							 
							 		.extract()
							 		
							 		.response();
					
					
					System.out.println("\n");
					
					System.out.println(" *************** STATUS CODE IS ====> " + response.getStatusCode());
					
					ResponseValue = response.getBody().asString();
					
					System.out.println("\n");
					
					System.out.println("\n");
					
					System.out.println("********************");
						 		
						System.out.println(ResponseValue);
						
					}
					
					return response;
					
				}
		
				
		  // This Method to be used for REST API TESTING on PUT Method only with URI and Payload as String With Authorization/Authentication
			
		public Response RestAssured_PutMethod(String BaseURL,String PostDetailsURL,File file,String Authorization,String Password)
							
		{
			if(Authorization.equalsIgnoreCase("Authorization"))
			{
				RestAssured.baseURI=BaseURL;
				
				
				response = 
						
						given()
						 
						 		.header("Content-Type","application/json")
						 		.header(Authorization,Password)
						 		.body(file)
						 		
						 		
						. when()
						 
						 		.put(PostDetailsURL)
						 		
						 .then()
						 
						 		.extract()
						 		
						 		.response();
				
				
				System.out.println("\n");
				
				System.out.println(" *************** STATUS CODE IS ====> " + response.getStatusCode());
				
				ResponseValue = response.getBody().asString();
				
				System.out.println("\n");
				
				System.out.println("\n");
				
				System.out.println("********************");
				 		
				System.out.println(ResponseValue);
			}
			
			else
			{
				RestAssured.baseURI=BaseURL;
				
				
				response = 
						
						given()
						 
						 		.header("Content-Type","application/json")
						 		.auth().basic(Authorization, Password)
						 		.body(file)
						 		
						 		
						. when()
						 
						 		.put(PostDetailsURL)
						 		
						 .then()
						 
						 		.extract()
						 		
						 		.response();
				
				
				System.out.println("\n");
				
				System.out.println(" *************** STATUS CODE IS ====> " + response.getStatusCode());
				
				ResponseValue = response.getBody().asString();
				
				System.out.println("\n");
				
				System.out.println("\n");
				
				System.out.println("********************");
						 		
						System.out.println(ResponseValue);
						
					}
					
					return response;
					
				}
		

		// This Method to be used for REST API TESTING on Delete Method when Authentication / Authorization is needed
	
	public Response RestAssured_DeleteMethod(String BaseURL,String Authorization,String Password,String GetDetailsURL)
	
	{
		RestAssured.baseURI=BaseURL;
		
		if (Authorization.equalsIgnoreCase("Authorization"))
	{
		response = 
				
				given()
				 
				 		.header("Content-Type","application/json")
				 
				 		.header(Authorization,Password)
				 		
				. when()
				 
				 		.delete(GetDetailsURL)
				 		
				 .then()
				 
				 		.extract()
				 		
				 		.response();
		
		System.out.println("  STATUS CODE IS ====> " + response.getStatusCode());
		
		ResponseValue = response.getBody().asString();
		
		System.out.println("********************");
		 		
		System.out.println(ResponseValue);
		 
	}
	
	else
	{
	
			response = 
					
					given()
					 
					 		.header("Content-Type","application/json")
					 
					 		.auth().basic(Authorization, Password)
					 		
					. when()
					 
							.delete(GetDetailsURL)
					 		
					 .then()
					 
					 		.extract()
					 		
					 		.response();
			
			System.out.println("  STATUS CODE IS ====> " + response.getStatusCode());
			
			ResponseValue = response.getBody().asString();
			
			System.out.println("********************");
				 		
				System.out.println(ResponseValue);
				 
		}
	
		return response;
		
	}
			
	
	// This Method to be used for REST API TESTING on Delete Method only with URI and no Authorization Details Needed
	
			public Response RestAssured_DeleteMethod(String BaseURL,String GetDetailsURL)
				
				{
					RestAssured.baseURI=BaseURL;
					
						
					response = 
							
							given()
							 
							 		.header("Content-Type","application/json")				 
						 		
						 		
						. when()
						 
						 		.delete(GetDetailsURL)
						 		
						 .then()
						 
						 		.extract()
						 		
						 		.response();
				
				System.out.println("\n");
				
				System.out.println(" *************** STATUS CODE IS ====> " + response.getStatusCode());
				
				ResponseValue = response.getBody().asString();
				
				System.out.println("\n");
				
				System.out.println("\n");
				
				System.out.println("********************");
				 		
				System.out.println(ResponseValue);
				
				return response;
			
			}
			
			
			public String extractresponse(Response response,String Path)
			{
				ResponseValue = response.getBody().asString();
				
				
				JsonPath jsonPathEvaluator = new JsonPath(ResponseValue);
				
				Output = jsonPathEvaluator.getString(Path);
				
				System.out.println("Extracted Value is ====>" + Output);
				
				System.out.println("\n");
				
				System.out.println("**********************");
				
				return Output;
				
			}
			
			
		
	}
