package com.lambdaTests.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScenario3 extends BaseClass {

    @Test
    public void validateAlertMessage() {
        getDriver().findElement(By.cssSelector("a[href*='/javascript-alert-box-demo']")).click();
        getDriver().findElement(By.cssSelector("button[class='btn btn-dark my-30 mx-10 hover:bg-lambda-900 hover:border-lambda-900']")).click();
        String alertMessage =   getDriver().switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "I am an alert box!", alertMessage);
        getDriver().switchTo().alert().accept();
    }
}
