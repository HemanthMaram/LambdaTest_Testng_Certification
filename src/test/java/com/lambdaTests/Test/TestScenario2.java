package com.lambdaTests.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TestScenario2 extends BaseClass {

    @Test
    public void checkboxDemo() {
        getDriver().findElement(By.cssSelector("a[href*='/checkbox-demo']")).click();
        WebElement checkbox =   getDriver().findElement(By.id("isAgeSelected"));
        checkbox.click();
        Assert.assertTrue(checkbox.isSelected(), "Checkbox should be selected.");
        checkbox.click();
        Assert.assertFalse(checkbox.isSelected(), "Checkbox should be unselected.");
    }
}
