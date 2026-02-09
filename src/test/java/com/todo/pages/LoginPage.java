package com.todo.pages;

import com.todo.Utils.configUtils;
import com.todo.base.basePage;
import io.qameta.allure.Step;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends basePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }
    @FindBy(css = "[data-testid='email']")
    private WebElement emailInput;
    @FindBy(css = "[data-testid='password']")
    private WebElement passwordInput;
    @FindBy(css = "[data-testid='submit']")
    private WebElement submit;
    @Step
    public TodoPage login(String email,String pass){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(pass);
        submit.click();
        return new TodoPage(driver);
    }
    @Step
    public LoginPage load(){
        driver.get(configUtils.getInstance().getUrl());
        return this;
    }
}
