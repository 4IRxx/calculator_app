package base;

import drivers.DriverAndroid;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import pages.CalculatorPage;

import java.net.MalformedURLException;

public class BaseTest {

    protected static CalculatorPage calculator;

    @BeforeAll
    public static void setUp() throws MalformedURLException {
        calculator = new CalculatorPage(DriverAndroid.getInstance().getDriver());
    }

    @AfterAll
    public static void tearDown() throws MalformedURLException {
        DriverAndroid.getInstance().getDriver().quit();
    }
}