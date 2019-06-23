package br.com.api.groove.tech.tests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DesafioAutomacaoAPITest {

	@Test
	public void testGetTitle() {
		RestAssured.baseURI = "https://swapi.co/api/films";

		Response response = given().contentType(ContentType.JSON).log().all().get("");

		JsonPath extractor = response.jsonPath();
		List<HashMap<String, String>> results = extractor.get("results");

		for (HashMap<String, String> result : results) {
			String title = result.get("title");
			String director = result.get("director");
			String producer = result.get("producer");
			if (director.equals("George Lucas") && producer.equals("Rick McCallum")) {

				System.out.println(title);

			}
		}

		Assert.assertEquals(response.statusCode(), 200);
	}

}
