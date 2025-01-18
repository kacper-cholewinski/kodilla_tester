package com.kodilla.rest.controller;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class ExternalApiRestAssuredTest {

    @Test
    void testGetPostShouldReturnStatus200AndValidateResponse() {
        given().  // [1]
                header("Content-Type", "application/json").
                when().
                get("https://jsonplaceholder.typicode.com/posts/1").  // [2]
                then().
                assertThat().
                statusCode(200).  //  [3]
                body("userId", equalTo(1)).  //  [4]
                body("id", equalTo(1)).
                body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")).
                body("body", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto")).
                log().all();  // [5]
    }

    @Test
    void testPutPostShouldReturnStatus200AndValidateResponse() {
        given().  // [1]
                header("Content-Type", "application/json").
                body(new HashMap<String, Object>(){{
                    put("userId", 5);
                    put("title", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
                    put("body", "Maecenas aliquet urna finibus risus tempor auctor. Nullam posuere leo quis sapien pretium posuere. Sed sit amet feugiat sem. Phasellus fringilla tincidunt mauris id varius. Phasellus eleifend, metus at rhoncus ornare, mauris nisi posuere sapien, et pellentesque ipsum dui id enim.");
                }}).
                when().
                put("https://jsonplaceholder.typicode.com/posts/1").
                then().
                assertThat().
                statusCode(200).
                body("userId", equalTo(5)).
                body("id", equalTo(1)).
                body("title", equalTo("Lorem ipsum dolor sit amet, consectetur adipiscing elit.")).
                body("body", equalTo("Maecenas aliquet urna finibus risus tempor auctor. Nullam posuere leo quis sapien pretium posuere. Sed sit amet feugiat sem. Phasellus fringilla tincidunt mauris id varius. Phasellus eleifend, metus at rhoncus ornare, mauris nisi posuere sapien, et pellentesque ipsum dui id enim.")).
                log().all();
    }

}