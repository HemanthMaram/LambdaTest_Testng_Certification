package com.lambdaTests.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestScenario1 extends BaseClass {


    @Test
    public void validatePageTitle() {
        WebDriverWait wait =new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(driver -> driver.findElement(By.tagName("body")));
        SoftAssert softAssert = new SoftAssert();
        String title =   getDriver().getTitle();
        softAssert.assertEquals(title, "LambdaTest", title);
        softAssert.assertAll();
    }
}


