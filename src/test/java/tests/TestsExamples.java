package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestsExamples {
	
// kulso tesztek
	@Test
	public void test_1() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		
		int statusCode = response.getStatusCode();
		
		AssertJUnit.assertEquals(statusCode, 200);
	}

	@Test
	public void test_2() {
		
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200);
	}
	
// belso tesztek
	@Test
	public void test_3() {
		baseURI = "http://localhost:9990";
		given().
			get("/").
		then().
			statusCode(200).and().
			contentType(ContentType.HTML);
	}
	
	@Test
	public void test_4() {
		baseURI = "http://localhost:9990";
			
		given().
			get("/management").
		then().
			statusCode(403).and().
			contentType(ContentType.JSON).body("size()", greaterThan(0)) ;
	}
}
