package org.example.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver, Duration.ofSeconds(10));
    }

    protected void click(By locator) {

        wait.until(ExpectedConditions
                .elementToBeClickable(locator)).click();
    }

    protected void type(By locator, String value) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));

        element.clear();
        element.sendKeys(value);
    }

    protected String getText(By locator) {

        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(locator))
                .getText();
    }

    protected boolean isDisplayed(By locator) {

        try {
            return wait.until(
                            ExpectedConditions.visibilityOfElementLocated(locator))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected List<WebElement> findElements(By locator) {

        return driver.findElements(locator);
    }

    protected void selectByValue(By locator, String value) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));

        new Select(element).selectByValue(value);
    }
}
