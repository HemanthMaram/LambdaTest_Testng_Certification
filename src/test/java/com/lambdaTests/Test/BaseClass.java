package com.lambdaTests.Test;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseClass {

    private static final ThreadLocal<RemoteWebDriver> DRIVER = new ThreadLocal<>();

    public RemoteWebDriver getDriver() {
        return DRIVER.get();
    }

    private void setDriver(RemoteWebDriver remoteWebDriver) {
        DRIVER.set(remoteWebDriver);
    }

    @BeforeTest
    @Parameters({ "browser", "version", "platform" })
    public void setup(String browser, String version, String platform) {
        final String userName = "hmaram21";
        final String accessKey = "OMjdH4yKzUrrHksRqZiNx0crd51IXnfb2YBQSJ8b2qNbu91APw";
        final String gridUrl = "@hub.lambdatest.com/wd/hub";

        if (browser.equalsIgnoreCase("chrome")) {
            try {
                setDriver(new RemoteWebDriver(new URL("http://" + userName + ":" + accessKey + gridUrl), getChromeOptions(version, platform)));

            } catch (final MalformedURLException e) {
                throw new Error("Could not start the chrome browser on LambdaTest cloud grid");
            }
        } else if (browser.equalsIgnoreCase("firefox")) {
            try {
                setDriver(new RemoteWebDriver(new URL("http://" + userName + ":" + accessKey + gridUrl), getFirefoxOptions(version, platform)));

            } catch (final MalformedURLException e) {
                throw new Error("Could not start the firefox browser on LambdaTest cloud grid");
            }
        } else if (browser.equalsIgnoreCase("edge")) {
            try {
                setDriver(new RemoteWebDriver(new URL("http://" + userName + ":" + accessKey + gridUrl), getEdgeOptions(version, platform)));

            } catch (final MalformedURLException e) {
                throw new Error("Could not start the firefox browser on LambdaTest cloud grid");
            }
        }
        else if (browser.equalsIgnoreCase("IETests")) {
            try {
                setDriver(new RemoteWebDriver(new URL("http://" + userName + ":" + accessKey + gridUrl), getInternetExplorerOptions(version, platform)));

            } catch (final MalformedURLException e) {
                throw new Error("Could not start the firefox browser on LambdaTest cloud grid");
            }
        }
         else {
            throw new Error("Browser configuration is not defined!");
        }
        getDriver().get("https://www.lambdatest.com/selenium-playground/");
        getDriver().manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(20));
    }

    private ChromeOptions getChromeOptions(String version, String platform) {
        var browserOptions = new ChromeOptions();
        browserOptions.setPlatformName(platform);
        browserOptions.setBrowserVersion(version);
        browserOptions.setCapability("LT:Options", getLtOptions());

        return browserOptions;
    }

    private FirefoxOptions getFirefoxOptions(String version, String platform) {
        var browserOptions = new FirefoxOptions();
        browserOptions.setPlatformName(platform);
        browserOptions.setBrowserVersion(version);
        browserOptions.setCapability("LT:Options", getLtOptions());

        return browserOptions;
    }

    private EdgeOptions getEdgeOptions(String version, String platform) {
        var browserOptions = new EdgeOptions();
        browserOptions.setPlatformName(platform);
        browserOptions.setBrowserVersion(version);
        browserOptions.setCapability("LT:Options", getLtOptions());

        return browserOptions;
    }

    private InternetExplorerOptions getInternetExplorerOptions(String version, String platform) {
        var browserOptions = new InternetExplorerOptions();
        browserOptions.setPlatformName(platform);
        browserOptions.setBrowserVersion(version);
        browserOptions.setCapability("LT:Options", getLtOptions());

        return browserOptions;
    }

    private HashMap<String, Object> getLtOptions() {
        final var ltOptions = new HashMap<String, Object>();
        ltOptions.put("project", "LambdaTest Testng Assessment");
        ltOptions.put("build", "Build Test Scenario's");
        ltOptions.put("name", "Testng Assessment Scenarios");
        ltOptions.put("w3c", true);
        ltOptions.put("visual", true);
        ltOptions.put("plugin", "java-testNG");
        return ltOptions;
    }

    @AfterTest
    public void tearDown() {
        getDriver().quit();
    }
}