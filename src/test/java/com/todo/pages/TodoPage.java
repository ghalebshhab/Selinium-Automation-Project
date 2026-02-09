package com.todo.pages;

import com.todo.Utils.configUtils;
import com.todo.base.basePage;
import com.todo.config.EndPoints;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.sql.DriverManager.getDriver;

public class TodoPage extends basePage {


   public TodoPage(WebDriver driver){
     super(driver);
   }

    @FindBy(css="[data-testid='add']")
    private WebElement addButton;
    @FindBy(css="[data-testid='delete']")
    private WebElement deleteButton;
    @FindBy(css="[data-testid='welcome']")
    private WebElement welcomeMessage;
    @Step
    public NewTodoPage addTodo(){
        addButton.click();
        return new NewTodoPage(driver);
    }
    @Step
    public TodoPage load(){
        driver.get(configUtils.getInstance().getUrl()+ EndPoints.TODO_PAGE_ENDPOINT);
        return this;
    }
    @Step
    public void deleteTodo(){
        deleteButton.click();
    }
    @Step
    public boolean isWelcomeMessageDisplayed(){
        return welcomeMessage.isDisplayed();
    }



}
