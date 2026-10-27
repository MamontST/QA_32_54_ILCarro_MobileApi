package mobile_tests;

import dto.Car;
import dto.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.*;
import utils.CarFactory;

import static utils.PropertiesReader.getProperty;

public class AddNewCarTests extends TestBase {
    AddNewCarScreen addNewCarScreen;
    Car car;

    @BeforeMethod
    public void beforeMethod() {
        new SplashScreen(driver).goToSearchScreen();
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnLogin();
        LoginScreen loginScreen = new LoginScreen(driver);
        User user = User.builder()
                .username(getProperty("base.properties", "email"))
                .password(getProperty("base.properties", "password"))
                .build();
        loginScreen.typeLoginForm(user);
        loginScreen.clickBtnLogin();
        searchScreen.clickBtnDots();
        searchScreen.clickBtnMyCars();
        new MyCarsScreen(driver).clickBtnAddNewCar();
        addNewCarScreen =  new AddNewCarScreen(driver);
        car = CarFactory.positiveCar();
    }

    @Test
    public void addNewCarPositiveTest() {
        addNewCarScreen.typeAddNewCarFrom(car);
        addNewCarScreen.clickBtnAddCar();
        Assert.assertTrue(new MyCarsScreen(driver).validateMessageAddCarSuccess("Car was added!"));
    }

}
