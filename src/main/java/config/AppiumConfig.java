package config;

import static utils.PropertiesReader.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URI;

public class AppiumConfig {
    public static AppiumDriver createAppiumDriver() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(getProperty("mobile.properties", "platformName"))
                .setAutomationName(getProperty("mobile.properties", "automationName"))
                .setDeviceName(getProperty("mobile.properties", "deviceName"))
                .setAppPackage(getProperty("mobile.properties", "appPackage"))
                .setAppActivity(getProperty("mobile.properties", "appActivity"));

        try {
            return new AppiumDriver(
                    URI.create(getProperty("mobile.properties", "appiumUrl")).toURL(),
                    options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}