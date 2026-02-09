package com.todo.rigesterApi;

import com.github.javafaker.Faker;
import com.todo.config.EndPoints;
import com.todo.objects.user;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class rigester {
    private String Token;
    private String userId;
    private String firstName;
    private Cookies cokiee;
    Faker faker=new Faker();
    public void registerApi(){
        user user1=new user(faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress(),"Ghaleb1#12");
        Response res=
                given().
                      baseUri("https://todo.qacart.com/").
                      header("Content-Type","application/json").
                      body(user1).
                when().
                      post(EndPoints.RIGESTER_API_ENDPOINT).
                then().
                      extract().
                      response();
        if(res.statusCode()!=201)
            throw new RuntimeException("Somthing Went Wrong");
        cokiee=res.detailedCookies();
         Token=res.getCookie("access_token");
         userId=res.getCookie("userID");
         firstName=res.getCookie("firstName");
    }

    public String getToken() {
        return this.Token;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getFirstName() {
        return this.firstName;
    }
    public List<Cookie> getCokiee(){
        return this.cokiee.asList();
    }
}
