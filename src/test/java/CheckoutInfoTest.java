import base.BaseTest;
import org.example.pages.CartPage;
import org.example.pages.CheckoutInfoPage;
import org.example.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutInfoTest extends BaseTest {

    private CheckoutInfoPage navigateToCheckout() {

        login();

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.addProductToCart("Sauce Labs Backpack");

        productsPage.openCart();

        CartPage cartPage = new CartPage(driver);

        cartPage.checkout();

        return new CheckoutInfoPage(driver);
    }

    @Test
    public void verifySuccessfulCheckoutInformation() {

        CheckoutInfoPage checkoutPage = navigateToCheckout();

        checkoutPage.enterCheckoutDetails(
                "Bhashitha",
                "Kaveesh",
                "80000"
        );

        checkoutPage.continueCheckout();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("checkout-step-two")
        );
    }

    @Test
    public void verifyCheckoutWithEmptyFirstName() {

        CheckoutInfoPage checkoutPage = navigateToCheckout();

        checkoutPage.enterCheckoutDetails(
                "",
                "Kaveesh",
                "80000"
        );

        checkoutPage.continueCheckout();

        Assert.assertTrue(
                checkoutPage.getErrorMessage()
                        .contains("First Name is required")
        );
    }
}
