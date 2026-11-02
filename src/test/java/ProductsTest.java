import base.BaseTest;
import org.example.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductsTest extends BaseTest {

    @Test
    public void verifyProductListing() {

        login();

        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertEquals(
                productsPage.getPageTitle(),
                "Products"
        );

        Assert.assertEquals(
                productsPage.getProductCount(),
                6,
                "Expected six products"
        );
    }

    @Test
    public void verifyProductSortingAZ() {

        login();

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.sortProducts("az");

        List<String> products = productsPage.getProductNames();

        List<String> sortedProducts = products.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .toList();

        Assert.assertEquals(products, sortedProducts);
    }

    @Test
    public void verifyAddProductsToCart() {

        login();

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.addProductToCart("Sauce Labs Backpack");

        productsPage.addProductToCart("Sauce Labs Bike Light");

        Assert.assertEquals(
                productsPage.getCartBadgeCount(),
                "2"
        );
    }
}
