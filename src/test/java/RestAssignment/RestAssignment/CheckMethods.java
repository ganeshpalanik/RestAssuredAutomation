package RestAssignment.RestAssignment;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;

import org.json.JSONObject;
import org.junit.Test;


import io.restassured.response.Response;

public class CheckMethods {
	
	Properties properties;
	
	Response response;
	
	String Output;
		
	@Test
	
	// This Method is to Call the Get Method of the RestMethods Class ( No Authentication is required)
	
	// In Addition , it has also method to extract the json response value if needed
	
	public void A_Check_GetMethod_NoAuthentication()
	
	{
		
		RestMethods MethodCheck = new RestMethods();
		
		String URL="https://reqres.in";
		
		String GetDetailsURL="/api/unknown";
		
		
		response=MethodCheck.RestAssured_GetMethod(URL,GetDetailsURL);
		
		
		Output=MethodCheck.extractresponse(response,"data.name[0]");
		
		
	}
	
	
	@ Test
	
	// This Method is to Call the Post Method of the RestMethods Class ( No Authentication is required)
	
	public void B_Check_PostMethod_NoAuthentication()
	{
		
		// Below Method to Pass Post Values as Strings
		
		RestMethods MethodCheck = new RestMethods();
		
		String URL="https://reqres.in";	
				
		String PostDetailsURL="/api/users";		
		
		JSONObject json = new JSONObject();
		
		json.put("name", "Named");
		
		json.put("job","Trainee");
				
		response=MethodCheck.RestAssured_PostMethod(URL, PostDetailsURL, json.toString());
		
		// Below Method to Pass Post Values from File
				
		File file = new File("./resources/Check.json");
		
		response=MethodCheck.RestAssured_PostMethod(URL, PostDetailsURL, file);
		
		
	}
	
	@Test
	
	public void C_Check_Put_Method_NoAuthentication()
	{
		
	// Below Method to Pass Post Values as Strings
	
			RestMethods MethodCheck = new RestMethods();
			
			String URL="https://reqres.in";	
					
			String PostDetailsURL="/api/users/538";		
			
			JSONObject json = new JSONObject();
			
			json.put("name", "Check");
			
			json.put("job","Teacher");
					
			response=	MethodCheck.RestAssured_PutMethod(URL, PostDetailsURL, json.toString());
			
			// Below Method to Pass Post Values from File
			
			File file = new File("./resources/PUT.json");
			
			response=MethodCheck.RestAssured_PutMethod(URL, PostDetailsURL, file);
	
	}

}
