package com.lambdaTests.Test;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;
public class TestScenario3 extends BaseClass {

    @Test
    public void validateAlertMessage() {
        driver.findElement(By.linkText("Javascript Alerts")).click();
        driver.findElement(By.xpath("//*[text()=\"JavaScript Alerts\"]//self::button"))
                .click();

        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "I am an alert box!", alertMessage);
        driver.switchTo().alert().accept();
    }
}
