package mobile_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

import java.util.Map;

public class SplashTests extends TestBase{
    @Test
    public void versionPositiveTest(){
        // splash screen is shown < 3 sec, it's gone before the session is ready - restart the app
//        driver.executeScript("mobile: terminateApp", Map.of("appId", "com.telran.ilcarro"));
//        driver.executeScript("mobile: activateApp", Map.of("appId", "com.telran.ilcarro"));
        Assert.assertTrue(new SplashScreen(driver)
                .validateVersionApp("Version 1.0.0"));
    }
}