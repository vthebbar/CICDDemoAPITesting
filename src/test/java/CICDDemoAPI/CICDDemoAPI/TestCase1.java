package CICDDemoAPI.CICDDemoAPI;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;


public class TestCase1 {

	public static RequestSpecification httpRequest;
	public static Response response;
	
	@BeforeMethod
	public void setup() {

		//RestAssured.baseURI="https://reqres.in";
		httpRequest=RestAssured.given();
		response = httpRequest.request(Method.GET, "https://reqres.in/api/users?page=2");
		System.out.println(response);
	}
	
	
	@Test
	public void test1() {
		Assert.assertEquals(true, response.statusCode()==200);
	}
 	
	@Test
	public void test2() {
			
		Assert.assertEquals(true, response.body().asString().contains("michael"));
		}
	
	@Test
	public void test3() {
	
		System.out.println(response.header("Content-Type"));
	}

	@Test
	public void test4() {
		System.out.println(response.body().asPrettyString());
	}
}
