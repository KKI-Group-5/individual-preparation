package com.example.individualprep.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArithmeticUtilityTest {

    private final ArithmeticUtility arithmeticUtility = new ArithmeticUtility();

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
}