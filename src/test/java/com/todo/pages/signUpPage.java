package com.todo.pages;

import com.todo.base.basePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class signUpPage extends basePage {

    public signUpPage(WebDriver driver){
       super(driver);
    }


    @FindBy(css = "[data-testid='first-name']")
    private WebElement firstNameInput;
    @FindBy(css = "[data-testid='last-name']")
    private WebElement lastNameInput;
    @FindBy(css = "[data-testid='email']")
    private WebElement emailInput;
    @FindBy(css = "[data-testid='password']")
    private WebElement passwordInput;
    @FindBy(css = "[data-testid='confirm-password']")
    private WebElement confirmPasswordInput;
    @FindBy(css = "[data-testid='submit']")
    private WebElement submit;
    @Step
    public TodoPage signup(String firstName,String lastName,String email,String pass){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(pass);
        confirmPasswordInput.sendKeys(pass);
        submit.click();
        return new TodoPage(driver);
    }
    @Step
    public signUpPage load(){
        driver.get("https://todo.qacart.com/signup");
        return this;
    }
}
