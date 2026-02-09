package com.todo.rigesterApi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.todo.config.EndPoints;
import com.todo.objects.Task;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class tasksApi {
    private Cookies restcookie;
  public void taskApi(String token) throws JsonProcessingException {
      Task task=new Task("Lern Web Dev",false);
      Response res = given()
              .baseUri("https://todo.qacart.com/")
              .header("Content-Type","application/json")
              .body(task)
              .auth()
              .oauth2(token)
              .when()
              .post(EndPoints.NEW_TASK_API_ENDPOINT);

      System.out.println("STATUS CODE: " + res.statusCode());
      System.out.println("RESPONSE BODY:");
      res.prettyPrint();
      System.out.println(new ObjectMapper().writeValueAsString(task));


  }
  public List<Cookie> getRestCookie(){
      return this.restcookie.asList();
  }
}
