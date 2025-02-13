package com.lambdaTests.Test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestScenario1 extends BaseClass {

    @Test
    public void validatePageTitle() {
        wait.until(driver -> driver.findElement(By.tagName("body")));
        SoftAssert softAssert = new SoftAssert();
        String title = driver.getTitle();
        softAssert.assertEquals(title, "LambdaTest", title);
        softAssert.assertAll();
    }
}


