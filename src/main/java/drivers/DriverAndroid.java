package drivers;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverAndroid {
    private static DriverAndroid instance;
    private AndroidDriver driver;

    private DriverAndroid() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("app", System.getProperty("user.dir") + "/src/main/resources/calculator.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    public static DriverAndroid getInstance() throws MalformedURLException {
        if (instance == null) {
            instance = new DriverAndroid();
        }
        return instance;
    }

    public AndroidDriver getDriver() {
        return driver;
    }
}