package activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Activity1 {

	RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2/pet")
			.addHeader("Content-Type", "application/json").build();

	@Test(priority = 1)
	public void addNewPet() {

		Map<String, Object> requestBody = new HashMap<>();
		requestBody.put("id", 77232);
		requestBody.put("name", "Riley");
		requestBody.put("status", "alive");

		Response response = given()
				.spec(spec)
				.body(requestBody)
				.when().post();

		// Assertion
		response.then().statusCode(200);
		response.then().body("id", equalTo(requestBody.get("id")));
		response.then().body("name", equalTo(requestBody.get("name")));
		response.then().body("status", equalTo(requestBody.get("status")));
	}

	@Test(priority = 2)
	public void getPet() {

		Response response = given()
				.spec(spec)
				.when()
				.pathParam("petId", 77232)
				.get("/{petId}");

		// Assertion
		response.then().statusCode(200);
		response.then().body("id", equalTo(77232));
		response.then().body("name", equalTo("Riley"));
		response.then().body("status", equalTo("alive"));
	}

	@Test(priority = 3)
	public void deletePet() {
		Response response = given().spec(spec)
				.when()
				.pathParam("petId", 77232)
				.delete("/{petId}");

		// Assertion
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("77232"));
	}

}
