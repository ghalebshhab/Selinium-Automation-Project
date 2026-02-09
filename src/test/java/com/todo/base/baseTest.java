package com.todo.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;

public class baseTest {
    protected ThreadLocal<WebDriver> driver=new ThreadLocal<>();
    public WebDriver getDriver(){
        return driver.get();
    }
    public void setDriver(WebDriver driver){
        this.driver.set(driver);
    }
    @BeforeTest
    @BeforeMethod
    public WebDriver intialization(){
        String browser=System.getProperty("browser","Chrome");
        switch (browser){
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                this.setDriver(new ChromeDriver());
                break;
            case "Edge":
                WebDriverManager.edgedriver().setup();
                this.setDriver(new EdgeDriver());
                break;
            case "FireFox":
                WebDriverManager.firefoxdriver().setup();
                this.setDriver(new FirefoxDriver());
            default:
                throw new RuntimeException("The Browser Not Supported");
        }

        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver.get();
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String name=result.getMethod().getMethodName();
        File destFile=new File("./target"+File.separator+"screenShots"+File.separator+name+".png");
        takeScreenShot(destFile);
        driver.get().quit();
    }
    //New Change
    public void takeScreenShot(File destFile){
        File file=((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,destFile);
            InputStream is=new FileInputStream(destFile);
            Allure.addAttachment("screenShots",is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Step
    public void injectCookieToBrowser(List<Cookie> coks){
        for(Cookie cook:coks){
            driver.get().manage().addCookie(cook);
        }
    }

}
