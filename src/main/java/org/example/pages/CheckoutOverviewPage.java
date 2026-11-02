package org.example.pages;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {

    private final By subtotal =
            By.className("summary_subtotal_label");

    private final By tax =
            By.className("summary_tax_label");

    private final By total =
            By.className("summary_total_label");

    private final By finishButton =
            By.id("finish");

    private final By completeHeader =
            By.className("complete-header");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public String getSubtotal() {
        return getText(subtotal);
    }

    public String getTax() {
        return getText(tax);
    }

    public String getTotal() {
        return getText(total);
    }

    public void finishOrder() {
        click(finishButton);
    }

    public String getOrderConfirmation() {
        return getText(completeHeader);
    }
}
