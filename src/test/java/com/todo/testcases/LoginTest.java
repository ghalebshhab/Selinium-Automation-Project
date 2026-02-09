package com.todo.testcases;

import com.todo.Utils.configUtils;
import com.todo.base.baseTest;
import com.todo.pages.LoginPage;
import com.todo.pages.TodoPage;
import com.todo.pages.signUpPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import io.qameta.allure.*;

@Epic("Authentication")
@Feature("Auth Test")
public class LoginTest extends baseTest {

    @Step("Login using email and password")
    private TodoPage doLogin(){
        LoginPage loginobj = new LoginPage(getDriver());
        return loginobj
                .load()
                .login(
                        configUtils.getInstance().getEmail(),
                        configUtils.getInstance().getPass()
                );
    }

    @Step("Signup using new credentials")
    private TodoPage doSignup(){
        signUpPage signobj = new signUpPage(getDriver());
        return signobj
                .load()
                .signup(
                        "Ghaleb",
                        "Shhab",
                        configUtils.getInstance().getEmail(),
                        configUtils.getInstance().getPass()
                );
    }

    TodoPage todoobj;

    @Story("Login With Email And Password")
    @Description("Login by filling the email and password then clicking on the login button")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test The Login Functionality With The Email And The Password")
    public void shouldLoginWithEmailAndPassword(){

        try {
            todoobj = doLogin();
            Assert.assertTrue(todoobj.isWelcomeMessageDisplayed());
        } catch (Exception e) {
            todoobj = doSignup();
        }
    }

    @Story("SignUp With Credentials")
    @Description("Signup by filling the credentials then clicking on the signup button")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test The SignUp Functionality With The SignUp Credentials")
    public void signUp(){

        try {
            todoobj = doSignup();
            Assert.assertTrue(todoobj.isWelcomeMessageDisplayed());
        } catch (Exception e) {
            todoobj = doLogin();
        }
    }
}
