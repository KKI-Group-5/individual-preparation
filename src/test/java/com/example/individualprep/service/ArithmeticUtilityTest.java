package com.example.individualprep.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticUtilityTest {

    private final ArithmeticUtility arithmeticUtility = new ArithmeticUtility();

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
}