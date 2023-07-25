package day2;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class DiffWaysToCreatePostRequestBody {
	
	// 1) Post request body using Hashmap
	
	
	
	@Test (priority=1)
	void testPostusingHAshMap() {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("name", "Ganesh");
		data.put("age", "20");
		data.put("gender", "male");
		
		String courseArr[] = {"C", "C++"};
		
		data.put("courses", courseArr);
		
		given()
		   .contentType("application/json")
		   .body(data)
		
		.when()
		   .post("http://localhost:3000/students")
		
		.then()
		   .statusCode(201)
		   .body("name", equalTo("Ganesh"))
		   .body("age", equalTo("20"))
		   .body("gender", equalTo("male"))
		   .body("courses[0]", equalTo("C"))
		   .body("courses[1]", equalTo("C++"))
		   .header("Content-Type", "application/json; charset=utf-8")
		   .log().all();
		
	}
	
	
	// deleting student record 
	@Test(priority=2)
	void testDelete() {
		given()
		
		.when()
		   .delete("http://localhost:3000/students/14")
		
		.then()
		   .statusCode(200);
		
	}
}
