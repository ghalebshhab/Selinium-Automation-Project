package com.todo.Utils;

import io.restassured.http.Cookie;

import java.util.ArrayList;
import java.util.List;

public class cookieUtils {
    public List<org.openqa.selenium.Cookie> convertRestAssuredCookieToSeliniumCookie
            (List<Cookie> cookiee){
        List<org.openqa.selenium.Cookie> cookies=new ArrayList<>();
        for(Cookie cokk:cookiee){
            org.openqa.selenium.Cookie cokie=new org.openqa.selenium.Cookie
                    (cokk.getName(),cokk.getValue());
            cookies.add(cokie);
        }
        return cookies;
    }
}
