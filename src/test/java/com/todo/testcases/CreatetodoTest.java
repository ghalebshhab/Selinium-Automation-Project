package com.todo.testcases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.todo.Utils.configUtils;
import com.todo.Utils.cookieUtils;
import com.todo.base.baseTest;
import com.todo.pages.LoginPage;
import com.todo.pages.NewTodoPage;
import com.todo.pages.TodoPage;
import com.todo.pages.signUpPage;
import com.todo.rigesterApi.rigester;
import com.todo.rigesterApi.tasksApi;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import io.qameta.allure.*;

@Epic("Todo Management")
@Feature("Todo Test")
public class CreatetodoTest extends baseTest {

    @Story("Add Todo")
    @Description("Add new todo by filling its name")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Should be able to create a new todo successfully")
    public void shouldCreateNewTodo(){

        rigester regs = new rigester();
        regs.registerApi();

        cookieUtils coks = new cookieUtils();
        List<Cookie> cooks =
                coks.convertRestAssuredCookieToSeliniumCookie(regs.getCokiee());

        NewTodoPage todo = new NewTodoPage(getDriver());

        todo.load();
        injectCookieToBrowser(cooks);
        todo.load().todoCreation("Learn Automation");
    }

    @Story("Delete Todo")
    @Description("Delete a todo by clicking on the delete button")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Should be able to delete a todo successfully")
    public void shouldBeAbleToDeleteTodo() throws JsonProcessingException {

        rigester regs = new rigester();
        regs.registerApi();

        tasksApi task = new tasksApi();
        task.taskApi(regs.getToken());

        TodoPage todoobj = new TodoPage(getDriver());
        todoobj.load();

        cookieUtils coks = new cookieUtils();
        List<Cookie> cooks =
                coks.convertRestAssuredCookieToSeliniumCookie(regs.getCokiee());

        injectCookieToBrowser(cooks);
        todoobj.load();
        todoobj.deleteTodo();

        try {
            Assert.assertTrue(todoobj.isWelcomeMessageDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
