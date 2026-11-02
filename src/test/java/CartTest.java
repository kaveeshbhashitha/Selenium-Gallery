import base.BaseTest;
import org.example.pages.CartPage;
import org.example.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CartTest extends BaseTest {

    private CartPage prepareCart() {

        login();

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.addProductToCart("Sauce Labs Backpack");
        productsPage.addProductToCart("Sauce Labs Bike Light");

        productsPage.openCart();

        return new CartPage(driver);
    }

    @Test
    public void verifyAddedProductsInCart() {

        CartPage cartPage = prepareCart();

        List<String> products =
                cartPage.getCartProductNames();

        Assert.assertEquals(cartPage.getCartProductCount(), 2);

        Assert.assertTrue(
                products.contains("Sauce Labs Backpack")
        );

        Assert.assertTrue(
                products.contains("Sauce Labs Bike Light")
        );
    }

    @Test
    public void verifyRemoveProductFromCart() {

        CartPage cartPage = prepareCart();

        cartPage.removeProduct("Sauce Labs Backpack");

        Assert.assertEquals(
                cartPage.getCartProductCount(),
                1
        );

        Assert.assertFalse(
                cartPage.getCartProductNames()
                        .contains("Sauce Labs Backpack")
        );
    }
}
