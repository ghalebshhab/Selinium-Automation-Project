package com.todo.pages;

import com.todo.Utils.configUtils;
import com.todo.base.basePage;
import com.todo.config.EndPoints;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v141.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewTodoPage extends basePage {


   public NewTodoPage(WebDriver driver){
       super(driver);
   }




    @FindBy(css="[data-testid='new-todo']")
    private WebElement NewInput;
    @FindBy(css="[data-testid='submit-newTask']")
    private WebElement submitButton;
    @Step
    public NewTodoPage todoCreation(String todoName){
        NewInput.sendKeys(todoName);
        submitButton.click();
        return this;
    }
    @Step
    public NewTodoPage submitCreation(){
        submitButton.click();
        return this;
    }
    @Step
    public NewTodoPage load(){
        driver.get(configUtils.getInstance().getUrl()+ EndPoints.NEW_TODO_PAGE_ENDPOINT);
        return this;
    }

}
