package mobile_tests;

import dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.RegistrationScreen;
import screens.SearchScreen;
import screens.SplashScreen;
import static utils.UserFactory.positiveUser;

public class RegistrationTests extends TestBase{
    private static final Logger log = LoggerFactory.getLogger(RegistrationTests.class);

    @Test
    public void registrationPositiveTest(){
        User user = positiveUser();
        log.info("Registering user: {}", user);

        new SplashScreen(driver).goToSearchScreen();
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnRegistration();

        new RegistrationScreen(driver).typeRegistrationForm(user);
        new RegistrationScreen(driver).clickBtnRegistration();

        searchScreen.clickBtnDots();
        Assert.assertTrue(searchScreen.validateBtnLogout("Logout"));
    }
}