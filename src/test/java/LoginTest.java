import base.BaseTest;
import org.example.pages.LoginPage;
import org.example.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifySuccessfulLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory.html"),
                "User should navigate to Products page"
        );
    }

    @Test
    public void verifyInvalidLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("invalid_user", "wrong_password");

        Assert.assertTrue(loginPage.isErrorDisplayed());

        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains("Username and password do not match")
        );
    }

    @Test
    public void verifyEmptyCredentials() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("", "");

        Assert.assertTrue(loginPage.isErrorDisplayed());

        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains("Username is required")
        );
    }
}