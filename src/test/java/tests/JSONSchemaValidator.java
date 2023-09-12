package tests;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import io.restassured.module.jsv.JsonSchemaValidator;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JSONSchemaValidator {

    @Test
    public void testGet() {
        baseURI = "https://reqres.in/api";

        given()
                .get("/users?page=2")
        .then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"))
                .statusCode(200);
    }
}
