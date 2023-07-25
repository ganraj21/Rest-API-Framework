package day1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

/* given() -> content type , set cookies, add auth , add param, set header info etc...
 
when() -> request type -> get, post, put, delete

then() -> validate status code, extract response, extract headers cookies & response body , ...  

*/ 


public class HTTPRequests {
	
	int id;
//	@Test(priority=1)
	void getUsers() {
		
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=3")
		
		.then()
		   .statusCode(200)
		   .body("page", equalTo(3))
		   .log().all();
	}
	
	@Test (priority=1)
	void createUser() {
		
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "Ganesh");
		data.put("job", "learning");
		id = given()
		   .contentType("application/json")
		   .body(data)
		.when()
		   .post("https://reqres.in/api/users")
		   .jsonPath().getInt("id");
		
//		.then()
//		   .statusCode(201)
//		   .log().all();
	}
	
	@Test (priority = 2 , dependsOnMethods= {"createUser"})
	void updateUser() {
		HashMap data = new HashMap();
		data.put("name", "Ganesh");
		data.put("job", "understanding");
		given()
		   .contentType("application/json")
		   .body(data)
		.when()
		   .post("https://reqres.in/api/users/"+id)
		
		.then()
		   .statusCode(201)
		   .log().all();
	}
	
	
	@Test (priority = 3)
	void deleteUser() {
		when()
		   .delete("https://reqres.in/api/users/"+id)
		.then()
		   .statusCode(204)
		   .log().all(); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
