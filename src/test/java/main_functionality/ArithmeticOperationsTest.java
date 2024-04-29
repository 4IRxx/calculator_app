package main_functionality;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArithmeticOperationsTest extends BaseTest {
    @ParameterizedTest(name = "Addition: {0} + {1} = {2}")
    @DisplayName("Check addition operation")
    @CsvSource({
            "0, 4, 4",
            "1, 7, 8",
            "3, 6, 9",
            "8, 9, 17"
    })
    public void testAddition(int numberOne, int numberTwo, int expectedResult) {
        int additionResult = calculator.getOperationResult(numberOne, numberTwo, calculator.getPlusButton());
        assertEquals(additionResult, expectedResult, "Addition operation is not correct");
    }

    @ParameterizedTest(name = "Deduction: {0} - {1} = {2}")
    @DisplayName("Check deduction operation")
    @CsvSource({
            "6, 3, 3",
            "8, 1, 7",
            "9, 5, 4",
            "2, 0, 2"
    })
    public void testDeduction(int numberOne, int numberTwo, int expectedResult) {
        int deductionResult = calculator.getOperationResult(numberOne, numberTwo, calculator.getMinusButton());
        assertEquals(deductionResult, expectedResult, "Deduction operation is not correct");
    }

    @ParameterizedTest(name = "Multiplication: {0} * {1} = {2}")
    @DisplayName("Check multiplication operation")
    @CsvSource({
            "2, 7, 14",
            "8, 1, 8",
            "9, 5, 45",
            "6, 0, 0"
    })
    public void testMultiplication(int numberOne, int numberTwo, int expectedResult) {
        int multiplicationResult = calculator.getOperationResult(numberOne, numberTwo, calculator.getMultiplyButton());
        assertEquals(multiplicationResult, expectedResult, "Multiplication operation is not correct");
    }

    @ParameterizedTest(name = "Division: {0} / {1} = {2}")
    @DisplayName("Check division operation")
    @CsvSource({
            "6, 2, 3",
            "8, 1, 8",
            "9, 3, 3",
            "4, 4, 1"
    })
    public void testDivision(int numberOne, int numberTwo, int expectedResult) {
        int divisionResult = calculator.getOperationResult(numberOne, numberTwo, calculator.getDivideButton());
        assertEquals(divisionResult, expectedResult, "Division operation is not correct");
    }

    @Test
    @DisplayName("Check division operation by 0")
    public void testDivisionByZero() {
        String errorMessage = calculator.divisionByZero(3);
        calculator.clickClearButton();
        assertEquals(errorMessage, "Can't divide by 0", "Division operation is not correct");
    }

    @Test
    @DisplayName("Check percentage operation")
    public void testPercentage() {
        double percentageResult = calculator.percentage(6, 9);
        assertEquals(percentageResult, 0.54, 0.001, "Percentage operation is not correct");
    }

    @Test
    @DisplayName("Check square root operation")
    public void testSquareRoot() {
        int squareRootResult = calculator.squareRoot(9);
        assertEquals(squareRootResult, 3, "Square root operation is not correct");
    }

    @Test
    @DisplayName("Check exponentiation operation")
    public void testExponentiation() {
        int exponentiationResult = calculator.getOperationResult(2, 3, calculator.getPowerButton());
        assertEquals(exponentiationResult, 8, "Multiplication operation is not correct");
    }
}