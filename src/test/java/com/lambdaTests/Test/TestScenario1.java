package com.lambdaTests.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestScenario1 extends BaseClass {
    WebDriverWait wait;
    @Test
    public void validatePageTitle() {
        wait.until(driver -> driver.findElement(By.tagName("body")));
        SoftAssert softAssert = new SoftAssert();
        String title = driver.getTitle();
        softAssert.assertEquals(title, "LambdaTest", title);
        softAssert.assertAll();
    }
}


