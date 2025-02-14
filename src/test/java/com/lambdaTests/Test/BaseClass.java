package com.lambdaTests.Test;

////import org.openqa.selenium.*;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.*;
//import java.net.MalformedURLException;
//import java.net.URL;
import java.time.Duration;
//import java.util.HashMap;
//
//public class BaseClass {
//    protected WebDriver driver;
//    protected WebDriverWait wait;
//    String UserName = "hmaram21";
//    String AccessToken ="OMjdH4yKzUrrHksRqZiNx0crd51IXnfb2YBQSJ8b2qNbu91APw";
//    @BeforeMethod
//    @Parameters({"browser", "browserVersion", "platform"})
//    public void setUp(String browser, String browserVersion, String platform) throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("browserName", browser);
//        capabilities.setCapability("browserVersion", browserVersion);
//        capabilities.setCapability("platform", platform);
//        capabilities.setCapability("LT:Options", new HashMap<String, Object>() {{
//            put("username", UserName);
//            put("accessKey", AccessToken);
//            put("resolution", "1920x1080");
//            put("build", "TestBuild");
//            put("name", "testng");
//            put("network", true);
//            put("video", true);
//            put("console", true);
//        }});
//
//        driver = new RemoteWebDriver(new URL("https://"+UserName+":"+AccessToken+"@hub.lambdatest.com/wd/hub"), capabilities);
//        driver.get("https://www.lambdatest.com/selenium-playground/");
//        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;


public class BaseClass{
    WebDriver driver = null;

    public static String status = "passed";
    String username = "hmaram21";
    String access_key = "OMjdH4yKzUrrHksRqZiNx0crd51IXnfb2YBQSJ8b2qNbu91APw";



    @BeforeTest
    @Parameters(value={"browser","version","platform"})
    public void testSetUp(String browser, String version, String platform) throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("build", "[LambdaTest] Demonstration of Selenium Automation Testing");
        capabilities.setCapability("name", "[LambdaTest] Demonstration of Selenium Automation Testing");
        capabilities.setCapability("platform", platform);
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("version",version);
        capabilities.setCapability("tunnel",false);
        capabilities.setCapability("network",true);
        capabilities.setCapability("console",true);
        capabilities.setCapability("visual",true);

        try
        {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + access_key + "@hub.lambdatest.com/wd/hub"), capabilities);
                }
        catch (MalformedURLException e)
        {
            System.out.println("Invalid grid URL");
        }
        System.out.println("Started session");
    }


@AfterTest
public void tearDown()
{
    if (driver != null)
    {
        ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
        driver.quit();
    }
}
}