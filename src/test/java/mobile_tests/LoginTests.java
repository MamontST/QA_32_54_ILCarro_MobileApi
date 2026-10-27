package mobile_tests;

import dto.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.ErrorScreen;
import screens.LoginScreen;
import screens.SearchScreen;
import screens.SplashScreen;

import static utils.PropertiesReader.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginTests extends TestBase{
    private static final Logger log = LoggerFactory.getLogger(LoginTests.class);
    SearchScreen searchScreen;
    LoginScreen loginScreen;
    User user;

    @BeforeMethod
    public void beforeMethod() {
        new SplashScreen(driver).goToSearchScreen();
        searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnLogin();
        loginScreen = new LoginScreen(driver);
        user = User.builder()
                .username(getProperty("base.properties", "email"))
                .password(getProperty("base.properties", "password"))
                .build();
    }

    @Test
    public void loginPositiveTest(){
        log.info("Login user: {}", user);
        loginScreen.typeLoginForm(user);
        loginScreen.clickBtnLogin();
        Assert.assertTrue(searchScreen.validateMessageLoginSuccess("Login success!"));
    }

    @Test
    public void loginWithWrongPasswordNegativeTest(){
        user.setPassword("Password123!");
        log.info("Login user with wrong password: {}", user);
        loginScreen.typeLoginForm(user);
        loginScreen.clickBtnLogin();
        Assert.assertTrue(new ErrorScreen(driver).validateErrorMessage("Login or Password incorrect"));
    }

    @Test
    public void loginWithEmptyEmailNegativeTest(){
        user.setUsername("");
        log.info("Login user with empty email: {}", user);
        loginScreen.typeLoginForm(user);
        loginScreen.clickBtnLogin();
        Assert.assertTrue(new ErrorScreen(driver).validateErrorMessage("All fields must be filled and agree terms"));
    }
}
