package org.example.pages;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage extends BasePage {

    private final By firstName =
            By.id("first-name");

    private final By lastName =
            By.id("last-name");

    private final By postalCode =
            By.id("postal-code");

    private final By continueButton =
            By.id("continue");

    private final By errorMessage =
            By.cssSelector("[data-test='error']");

    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }

    public void enterCheckoutDetails(
            String first, String last, String postal) {

        type(firstName, first);
        type(lastName, last);
        type(postalCode, postal);
    }

    public void continueCheckout() {
        click(continueButton);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }
}
