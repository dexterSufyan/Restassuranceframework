package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GetAndPostExamples {

    @Test
    public void testGet() {
        baseURI = "https://reqres.in/api";

        given().
                get("/users?page=2").
                then().
                statusCode(200).
                body("data[1].first_name",equalTo("Lindsay")).
                body("data.first_name",hasItems("George","Rachel"));
    }

    @Test
    public void testPost() {
        Map<String, Object> map = new HashMap<String,Object>();

//        map.put("name", "Sadiq");
//        map.put("job", "SQAE");

//        System.out.println(map);

        JSONObject request = new JSONObject();
        request.put("name", "Sadiq");
        request.put("job", "SQAE");
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api";

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                post("/users").
        then().
                statusCode(201).
                log().all();

    }
}
