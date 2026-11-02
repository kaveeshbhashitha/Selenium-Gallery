package org.example.pages;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

    private final By pageTitle =
            By.className("title");

    private final By inventoryItems =
            By.className("inventory_item_name");

    private final By sortDropdown =
            By.className("product_sort_container");

    private final By cartBadge =
            By.className("shopping_cart_badge");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return getText(pageTitle);
    }

    public int getProductCount() {
        return findElements(inventoryItems).size();
    }

    public List<String> getProductNames() {

        return findElements(inventoryItems)
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public void sortProducts(String value) {
        selectByValue(sortDropdown, value);
    }

    public void addProductToCart(String productName) {

        By addButton = By.xpath(
                "//div[contains(@class,'inventory_item')]" +
                        "[.//div[@class='inventory_item_name' and text()='" +
                        productName + "']]//button"
        );

        click(addButton);
    }

    public String getCartBadgeCount() {

        return getText(cartBadge);
    }

    public void openCart() {

        click(By.className("shopping_cart_link"));
    }
}
