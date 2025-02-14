package com.lambdaTests.Test;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;
public class TestScenario3 extends BaseClass {

    @Test
    public void validateAlertMessage() {
        getDriver().findElement(By.linkText("Javascript Alerts")).click();
        getDriver().findElement(By.xpath("//*[text()=\"JavaScript Alerts\"]//self::button"))
                .click();

        String alertMessage =   getDriver().switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "I am an alert box!", alertMessage);
        getDriver().switchTo().alert().accept();
    }
}
