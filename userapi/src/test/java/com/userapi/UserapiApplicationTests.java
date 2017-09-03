package com.userapi;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestContext.class, WebApplicationContext.class })
@SpringBootTest
@WebAppConfiguration
public class UserapiApplicationTests {

	private final String url = "http://localhost:9000/api/user";

	@Test
	public void getAllUser() throws Exception {
		given().when().get(url).then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
	}

	@Test
	public void getOneUser() throws Exception {
		given().contentType(ContentType.JSON).pathParam("id", 3).when().get(url + "/{id}").then().statusCode(200)
				.body("data.fname", equalTo("Nischal")).body("data.lname", equalTo("Dallu"));

	}

}
