package com.example.individualprep.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticUtilityTest {

    private final ArithmeticUtility arithmeticUtility = new ArithmeticUtility();

    @Test
    void add_shouldReturnSum() {
        assertEquals(12.0, arithmeticUtility.add(5.0, 7.0), 1e-9);
    }

    @Test
    void add_shouldHandleNegativeNumbers() {
        assertEquals(-2.0, arithmeticUtility.add(-5.0, 3.0), 1e-9);
    }

    @Test
    void add_shouldHandleDecimals() {
        assertEquals(0.3, arithmeticUtility.add(0.1, 0.2), 1e-9); // pakai tolerance
    }

    @Test
    void divide_whenDivisorIsNonZero_returnsQuotient() {
        double result = arithmeticUtility.divide(10.0, 2.0);

        assertEquals(5.0, result, 1e-9);
    }

    @Test
    void divide_withNegativeDividend_returnsNegativeQuotient() {
        double result = arithmeticUtility.divide(-10.0, 2.0);

        assertEquals(-5.0, result, 1e-9);
    }

    @Test
    void divide_withNegativeDivisor_returnsNegativeQuotient() {
        double result = arithmeticUtility.divide(10.0, -2.0);

        assertEquals(-5.0, result, 1e-9);
    }

    @Test
    void divide_withBothNegative_returnsPositiveQuotient() {
        double result = arithmeticUtility.divide(-10.0, -2.0);

        assertEquals(5.0, result, 1e-9);
    }

    @Test
    void divide_withDecimalNumbers_returnsExpectedValue() {
        double result = arithmeticUtility.divide(1.0, 3.0);

        assertEquals(0.3333333333333333, result, 1e-12);
    }

    @Test
    void divide_whenDividendIsZero_returnsZero() {
        double result = arithmeticUtility.divide(0.0, 5.0);

        assertEquals(0.0, result, 0.0);
    }

    @Test
    void divide_whenDivisorIsZero_throwsArithmeticExceptionWithMessage() {
        ArithmeticException ex = assertThrows(
                ArithmeticException.class,
                () -> arithmeticUtility.divide(10.0, 0.0)
        );

        assertEquals("Cannot divide by zero", ex.getMessage());
    }
    @Test
    void testExponent_PositivePower() {
        // Test 2^3 = 8
        double result = arithmeticUtility.exponent(2.0, 3);
        assertEquals(8.0, result, 0.0001, "2.0 to the power of 3 should be 8.0");
    }

    @Test
    void testExponent_ZeroPower() {
        // Test 5^0 = 1
        double result = arithmeticUtility.exponent(5.0, 0);
        assertEquals(1.0, result, 0.0001, "Any number to the power of 0 should be 1.0");
    }

    @Test
    void testExponent_NegativePower() {
        // Test 2^-1 = 0.5
        double result = arithmeticUtility.exponent(2.0, -1);
        assertEquals(0.5, result, 0.0001, "2.0 to the power of -1 should be 0.5");
    }

    @Test
    void testExponent_ZeroToNegativePowerThrowsException() {
        // Test the exception logic for 0^-1
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            arithmeticUtility.exponent(0.0, -1);
        });

        // Verify the exact error message
        assertEquals("Cannot raise zero to a negative power due to division by zero.", exception.getMessage());
    }
    @Test
    void testMultiplyStandard() {
        // Scenario 1: Standard multiplication
        double result = arithmeticUtility.multiply(5.0, 10.0);

        // Assert: 5 * 10 = 50
        assertEquals(50.0, result, 0.0001, "Standard multiplication failed");
    }

    @Test
    void testMultiplyByZero() {
        // Scenario 2: Multiplication by zero
        double result = arithmeticUtility.multiply(123.45, 0.0);

        // Assert: Anything * 0 = 0
        assertEquals(0.0, result, 0.0001, "Multiplication by zero failed");
    }

    @Test
    void testMultiplyNegatives() {
        // Scenario 3: Negative multiplication
        double result = arithmeticUtility.multiply(-5.0, -2.0);

        // Assert: -5 * -2 = 10 (positive)
        assertEquals(10.0, result, 0.0001, "Negative multiplication failed");
    }

    @Test
    void testSubtractPositiveNumbers() {
        double result = arithmeticUtility.subtract(10, 3);
        assertEquals(7.0, result);
    }

    @Test
    void testSubtractWithNegativeNumber() {
        double result = arithmeticUtility.subtract(10, -5);
        assertEquals(15.0, result);
    }

    @Test
    void testSubtractBothNegative() {
        double result = arithmeticUtility.subtract(-10, -5);
        assertEquals(-5.0, result);
    }

    @Test
    void testSubtractWithZero() {
        double result = arithmeticUtility.subtract(10, 0);
        assertEquals(10.0, result);
    }
}