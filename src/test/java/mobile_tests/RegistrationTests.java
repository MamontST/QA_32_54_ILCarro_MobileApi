package mobile_tests;

import dto.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.RegistrationScreen;
import screens.SearchScreen;
import screens.SplashScreen;
import static utils.UserFactory.positiveUser;

public class RegistrationTests extends TestBase{

    @Test
    public void registrationPositiveTest(){
        User user = positiveUser();
        System.out.println(user.toString());

        new SplashScreen(driver).goToSearchScreen();
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnRegistration();

        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(user);
        registrationScreen.clickBtnRegistration();

        searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        Assert.assertTrue(new SearchScreen(driver)
                .validateBtnLogout("Logout"));
    }
}