package api_rest_tests;

import controllers.AuthController;
import data_providers.UserDataProvider;
import dto.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.PropertiesReader;

import static utils.PropertiesReader.getProperty;
import static utils.UserFactory.*;

public class RegistrationLoginTests extends AuthController {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void registrationPositiveTest() {
        User user = positiveUser();
        Assert.assertEquals(registrationLogin(user, REGISTRATION_URL).getStatusCode(), 200);
    }

    @Test(dataProvider = "dataProviderForRegistrationWrongNameOrPasswordOrEmail", dataProviderClass = UserDataProvider.class)
    public void registrationWrongNameOrPasswordOrEmail(User user) {
        Assert.assertEquals(registrationLogin(user, REGISTRATION_URL).getStatusCode(), 400);
    }

    @Test
    public void loginPositiveTest() {
        User user = User.builder()
                .username(PropertiesReader.getProperty("base.properties", "email"))
                .password(PropertiesReader.getProperty("base.properties", "password"))
                .build();
        Response response = registrationLogin(user, LOGIN_URL);
//        System.out.println(response.getBody().asString());
//        TokenDto tokenDto = response.getBody().as(TokenDto.class);
//        System.out.println(tokenDto.getAccessToken());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void loginNegativeEmptyPasswordTest() {
        User user = User.builder()
                .username(getProperty("base.properties", "email"))
                .password("")
                .build();
        Response response = registrationLogin(user, LOGIN_URL);
        System.out.println(response.getBody().asString());

        softAssert.assertEquals(response.jsonPath().getString("message"), "Login or Password incorrect");
        softAssert.assertEquals(response.getStatusCode(), 401);
        softAssert.assertAll();
    }
}
