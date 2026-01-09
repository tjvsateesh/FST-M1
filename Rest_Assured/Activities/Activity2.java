package activities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity2 {
	
	RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2/user")
			.addHeader("Content-Type", "application/json").build();
	
	@Test(priority=1)
	public void addNewUserFromFile() throws IOException {

		FileInputStream request = new FileInputStream("src/test/resources/userInfo.json");
 
		Response response = given()
			.spec(spec)
			.body(request)
			.when().post();
 
		request.close();
 
		// Assertion
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("159248"));
	}
	
	@Test(priority=2)
	public void getUserInfo() {
		// Import JSON file to write to
		File outputJSON = new File("src/test/java/resources/userGETResponse.json");
 
		Response response = given()
			.spec(spec)
			.pathParam("username", "johncena")
			.when().get("/{username}");
		
		String resBody = response.getBody().asPrettyString();
 
		try {
			outputJSON.createNewFile();
			FileWriter writer = new FileWriter(outputJSON.getPath());
			writer.write(resBody);
			writer.close();
		} catch (IOException excp) {
			excp.printStackTrace();
		}
		
		// Assertion
		response.then().body("id", equalTo(159248));
		response.then().body("username", equalTo("johncena"));
		response.then().body("firstName", equalTo("John"));
		response.then().body("lastName", equalTo("Cena"));
		response.then().body("email", equalTo("johncena@mail.com"));
		response.then().body("password", equalTo("password123"));
		response.then().body("phone", equalTo("9812763450"));
	}
	
	@Test(priority=3)
	public void deleteUser() throws IOException {
		Response response = given()
			.spec(spec)
			.pathParam("username", "johncena")
			.when().delete("/{username}");
 
		// Assertion
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("johncena"));
	}
}
