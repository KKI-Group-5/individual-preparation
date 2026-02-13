package com.example.individualprep.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class VectorUtilityTest {

    private final VectorUtility vectorUtility = new VectorUtility();

    @Test
    void testMultiplyStandard() {
        // Scenario 1: Standard multiplication
        double[] vector = {2.0, 4.0, 6.0};
        int scalar = 3;
        double[] expected = {6.0, 12.0, 18.0};

        double[] result = vectorUtility.multiply(vector, scalar);

        // assertArrayEquals checks if two arrays are identical
        // The last parameter (0.0001) is the tolerance for floating-point errors
        assertArrayEquals(expected, result, 0.0001, "Standard vector multiplication failed");
    }

    @Test
    void testMultiplyByZero() {
        // Scenario 2: Multiply by zero
        double[] vector = {5.5, -2.1, 100.0};
        int scalar = 0;
        double[] expected = {0.0, 0.0, 0.0};

        double[] result = vectorUtility.multiply(vector, scalar);

        assertArrayEquals(expected, result, 0.0001, "Multiplication by zero failed");
    }

    @Test
    void testMultiplyNegatives() {
        // Scenario 3: Negative numbers
        double[] vector = {-1.0, -2.0, 5.0};
        int scalar = -2;
        double[] expected = {2.0, 4.0, -10.0};

        double[] result = vectorUtility.multiply(vector, scalar);

        assertArrayEquals(expected, result, 0.0001, "Negative multiplication failed");
    }
}