package ApiRestAutomation.RestApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import  com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*; 
@Test
public class GetUserdetails {

	public void Test_01() {
		Response resp = when().get("http://localhost:8080/Assignment/user/getallusers");
	
resp.as
		System.out.println((resp.asString()));
		Assert.assertEquals(resp.getStatusCode(), 200);
	}

	
	public void Test_02() {
		Response resp = when().get("http://localhost:8080/Assignment/user/getallusers");

		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 200);
		
	}

	//@Test
	public void Test_03() {
		Response resp = given().param("q", "London").
                                param("appid","b6907d289e10d714a6e88b30761fae22").
				when().get("http://samples.openweathermap.org/data/2.5/weather").
				then().contentType(ContentType.JSON).
				extract().response().
				path("$.weather[0].description");
				

		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 200);

		if (resp.getStatusCode() == 200) {
			System.out.println("Api is working fine");
		} else {
			System.out.println("Api si not working");
		}
		
		System.out.println(resp.asString());
	}
	
	public void Test_04() {
		
		Userdetails user=new Userdetails();
		user.setUsername("Dept manager");
		user.setPassword("xxxxxxxxx");
		user.setEmail("dept@gmail.com");
		Response resp = given().when().contentType(ContentType.JSON).body(user).
				post("http://localhost:8080/Assignment/user/adduser");

		System.out.println("response:"+resp);
		Assert.assertEquals(resp.getStatusCode(), 200);
	}
	
	public void Test_05() {
		
		Userdetails user=new Userdetails();
		user.setUsername("Department manager");
		user.setPassword("xxx");
		user.setEmail("dept@gmail.com");
		Response resp = given().when().contentType(ContentType.JSON).body(user).
				put("http://localhost:8080/Assignment/user/updateuser/17");

		System.out.println("response:"+resp);
		Assert.assertEquals(resp.getStatusCode(), 200);
	}
	
	
	public void Test_06() {
		
		Userdetails user=new Userdetails();
		user.setUsername("Department manager");
		user.setPassword("xxx");
		user.setEmail("dept@gmail.com");
		Response resp = given().when().contentType(ContentType.JSON).body(user).
				delete("http://localhost:8080/Assignment/user/deleteuser/4");

		System.out.println("response:"+resp);
		Assert.assertEquals(resp.getStatusCode(), 200);
	}
}