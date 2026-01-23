package project;

import org.testng.annotations.*;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;

public class GithubAPI {
	
	RequestSpecification reqSpec;
	ResponseSpecification responseSpec;
	private static String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIHpKJQSJ4AIc9scel3EjLumgmxtBud3gtoWOXzhYJK65 azuread\\thimmapathinisateesh@Sateesh";
	private static int sshKeyId;
	
	@BeforeClass
	public void setUp() {
		reqSpec = new RequestSpecBuilder()
				.addHeader("Content-Type", "application/json")
				.setBaseUri("https://api.github.com")
				.addHeader("Authorization", "Bearer "+"<TOKEN>")
				.build();
	}
	
	@Test
	public void addSSH() {
		String reqBody = "{\n" +
		        "  \"title\": \"TestAPIKey\",\n" +
		        "  \"key\":\"" + sshKey +"\"\n" +
		        "}";
		
		Response response = given()
				.spec(reqSpec)
				.body(reqBody)
				.when().post("/user/keys");
		//status code validation 
		response.then()
		.statusCode(201);
		//extracting ssh key id 141002235
		sshKeyId = response.getBody().jsonPath().get("id");
		
		System.out.println("=== POST SSH Response ===");
		System.out.println(response.getBody().asPrettyString());

	}
	
	@Test
	public void getSSH() {
		
		System.out.println(sshKeyId);
		
		Response response = given()
				.spec(reqSpec)
				.pathParam("keyId", sshKeyId)
				.when().get("/user/keys/{keyId}");
		
		System.out.println("=== GET SSH Response ===");
		System.out.println(response.getBody().asPrettyString());
		
		//status code validation
		response.then()
		.statusCode(200);
		
	}
	
	@Test
	public void deleteSSH() {
		
		Response response = given()
				.spec(reqSpec)
				.pathParam("keyId", 141000908)
				.when().delete("/user/keys/{keyId}");
		
		System.out.println("=== DELETE SSH Response ===");
		System.out.println(response.getBody().asPrettyString());
		
		//status code validation
		response.then()
		.statusCode(204);
		
	}

}
