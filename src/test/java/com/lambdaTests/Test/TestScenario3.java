package com.lambdaTests.Test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TestScenario3 extends BaseClass {
    WebElement alertButton =getDriver().findElement(By.xpath("//*[text()=\"JavaScript Alerts\"]//self::button"));
    @Test
    public void validateAlertMessage() {
        getDriver().findElement(By.cssSelector("a[href*='/javascript-alert-box-demo']")).click();


       alertButton.click();
        String alertMessage =   getDriver().switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "I am an alert box!", alertMessage);
        getDriver().switchTo().alert().accept();
    }
}
