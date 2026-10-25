package mobile_tests;

import dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.ErrorScreen;
import screens.RegistrationScreen;
import screens.SearchScreen;
import screens.SplashScreen;
import static utils.UserFactory.positiveUser;

public class RegistrationTests extends TestBase{
    private static final Logger log = LoggerFactory.getLogger(RegistrationTests.class);
    SearchScreen searchScreen;
    RegistrationScreen registrationScreen;
    User user;

    @BeforeMethod
    public void beforeMethod(){
        new SplashScreen(driver).goToSearchScreen();
        searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnRegistration();
        registrationScreen = new RegistrationScreen(driver);
        user = positiveUser();
    }

    @Test
    public void registrationPositiveTest(){
        log.info("Registering user: {}", user);

        registrationScreen.typeRegistrationForm(user);
        registrationScreen.clickCheckBoxAgree();
        registrationScreen.clickBtnYalla();

        Assert.assertTrue(searchScreen.validateMessageRegistrationSuccess("Registration success!"));
    }
    @Test
    public void registrationEmptyFieldNameNegativeTest(){
        user.setFirstName("");
        log.info("Registering user: {}", user);

        registrationScreen.typeRegistrationForm(user);
        registrationScreen.clickCheckBoxAgree();
        registrationScreen.clickBtnYalla();
        Assert.assertTrue(new ErrorScreen(driver).validateErrorMessage("All fields must be filled and agree terms"));
    }

}