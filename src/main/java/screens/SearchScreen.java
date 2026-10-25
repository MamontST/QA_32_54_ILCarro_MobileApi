package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SearchScreen extends BaseScreen {
    public SearchScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    WebElement btnDots;
    @AndroidFindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/title' and @text='Login']")
    WebElement btnLogin;
    @AndroidFindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/title' and @text='Registration']")
    WebElement btnRegistration;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.telran.ilcarro:id/title' and @text='Logout']")
    WebElement btnLogout;
    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Registration success!']")
    WebElement messageRegistrationSuccess;
    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Login success!']")
    WebElement messageLoginSuccess;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.telran.ilcarro:id/title' and @text='My Cars']")
    WebElement btnMyCars;

    public void clickBtnDots() {
        clickWait(btnDots);
    }

    public void clickBtnLogin() {
        clickWait(btnLogin);
    }

    public void clickBtnRegistration() {
        clickWait(btnRegistration);
    }

    public void clickBtnMyCars() {
        clickWait(btnMyCars);
    }

    public void clickLogout() {
        clickWait(btnLogout);
    }

    public boolean validateMessageRegistrationSuccess(String text) {
        return isTextInElementPresent(messageRegistrationSuccess, text);
    }

    public boolean validateMessageLoginSuccess(String text) {
        return isTextInElementPresent(messageLoginSuccess, text);
    }

//    public boolean validateBtnLogout(String text) {
//        return isTextInElementPresent(btnLogout, text);
//    }

}