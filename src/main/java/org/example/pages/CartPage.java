package org.example.pages;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage  extends BasePage {

    private final By cartItems =
            By.className("inventory_item_name");

    private final By checkoutButton =
            By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getCartProductNames() {

        return findElements(cartItems)
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public int getCartProductCount() {
        return findElements(cartItems).size();
    }

    public void removeProduct(String productName) {

        By removeButton = By.xpath(
                "//div[contains(@class,'cart_item')]" +
                        "[.//div[@class='inventory_item_name' and text()='" +
                        productName + "']]//button"
        );

        click(removeButton);
    }

    public void checkout() {
        click(checkoutButton);
    }
}
