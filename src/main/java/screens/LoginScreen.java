package screens;

import dto.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreen {

    public LoginScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.telran.ilcarro:id/editLoginEmail']")
    WebElement inputEmail;
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.telran.ilcarro:id/editLoginPassword']")
    WebElement inputPassword;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.telran.ilcarro:id/loginBtn']")
    WebElement btnLogin;


    public void typeLoginForm(User user) {
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
    }

    public void clickBtnLogin() {
        btnLogin.click();
    }
}
