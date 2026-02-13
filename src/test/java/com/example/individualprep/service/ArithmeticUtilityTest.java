package com.example.individualprep.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticUtilityTest {

    // Instantiate the service class
    private final ArithmeticUtility arithmeticUtility = new ArithmeticUtility();

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
}