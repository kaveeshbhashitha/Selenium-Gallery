import base.BaseTest;
import org.example.pages.CartPage;
import org.example.pages.CheckoutInfoPage;
import org.example.pages.CheckoutOverviewPage;
import org.example.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutOverviewTest extends BaseTest {

    private CheckoutOverviewPage navigateToOverview() {

        login();

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.addProductToCart("Sauce Labs Backpack");

        productsPage.addProductToCart("Sauce Labs Bike Light");

        productsPage.openCart();

        CartPage cartPage = new CartPage(driver);

        cartPage.checkout();

        CheckoutInfoPage checkoutInfoPage =
                new CheckoutInfoPage(driver);

        checkoutInfoPage.enterCheckoutDetails(
                "Bhashitha",
                "Kaveesh",
                "80000"
        );

        checkoutInfoPage.continueCheckout();

        return new CheckoutOverviewPage(driver);
    }

    @Test
    public void verifyOrderPriceCalculation() {

        CheckoutOverviewPage overviewPage =
                navigateToOverview();

        Assert.assertEquals(
                overviewPage.getSubtotal(),
                "Item total: $39.98"
        );

        Assert.assertEquals(
                overviewPage.getTax(),
                "Tax: $3.20"
        );

        Assert.assertEquals(
                overviewPage.getTotal(),
                "Total: $43.18"
        );
    }

    @Test
    public void verifySuccessfulOrderPlacement() {

        CheckoutOverviewPage overviewPage =
                navigateToOverview();

        overviewPage.finishOrder();

        Assert.assertEquals(
                overviewPage.getOrderConfirmation(),
                "Thank you for your order!"
        );
    }
}
