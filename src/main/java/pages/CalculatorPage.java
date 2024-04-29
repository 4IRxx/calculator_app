package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.Getter;

@Getter
public class CalculatorPage {
    AppiumDriver driver;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='divide']")
    WebElement divideButton;
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='multiply']")
    WebElement multiplyButton;
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='minus']")
    WebElement minusButton;
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='plus']")
    WebElement plusButton;
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='equals']")
    WebElement equalsButton;
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='percent']")
    WebElement percentButton;
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='square root']")
    WebElement squareRootButton;
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='power']")
    WebElement powerButton;
    @FindBy(id = "com.google.android.calculator:id/result_final")
    WebElement result;
    @FindBy(id = "com.google.android.calculator:id/result_preview")
    WebElement resultPreview;
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='clear']")
    WebElement clearButton;

    public CalculatorPage(AppiumDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public int getOperationResult(int numberOne, int NumberTwo, WebElement operationButton) {
        WebElement firstNumber = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='"+ numberOne +"']"));
        firstNumber.click();
        operationButton.click();
        WebElement secondNumber = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='"+ NumberTwo +"']"));
        secondNumber.click();
        equalsButton.click();
        return Integer.parseInt(result.getText());
    }

    public String divisionByZero(int number) {
        WebElement firstNumber = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='"+ number +"']"));
        firstNumber.click();
        divideButton.click();
        WebElement secondNumber = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='0']"));
        secondNumber.click();
        equalsButton.click();
        return resultPreview.getText();
    }

    public double percentage(int numberOne, int NumberTwo) {
        WebElement firstNumber = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='"+ numberOne +"']"));
        firstNumber.click();
        percentButton.click();
        WebElement secondNumber = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='"+ NumberTwo +"']"));
        secondNumber.click();
        equalsButton.click();
        return Double.parseDouble(result.getText());
    }

    public int squareRoot(int numberOne) {
        squareRootButton.click();
        WebElement firstNumber = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='"+ numberOne +"']"));
        firstNumber.click();
        equalsButton.click();
        return Integer.parseInt(result.getText());
    }

    public void clickClearButton() {
        clearButton.click();
    }
}