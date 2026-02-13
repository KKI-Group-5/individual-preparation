package com.example.individualprep.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VectorUtilityTest {

    // Instantiate the service class
    private final VectorUtility vectorUtility = new VectorUtility();

    @Test
    void testAdd_NormalVectors() {
        // 1. Setup
        double[] v1 = {1.0, 2.0, 3.0};
        double[] v2 = {4.0, 5.0, 6.0};
        double[] expected = {5.0, 7.0, 9.0};

        // 2. Execute
        double[] result = vectorUtility.add(v1, v2);

        // 3. Assert (Use assertArrayEquals for double arrays, with a small delta for precision)
        assertArrayEquals(expected, result, 0.0001, "The vectors should be added element by element");
    }

    @Test
    void testAdd_DifferentLengthsThrowsException() {
        // 1. Setup vectors of different sizes
        double[] v1 = {1.0, 2.0};
        double[] v2 = {4.0, 5.0, 6.0};

        // 2 & 3. Execute and Assert that it throws the correct exception
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtility.add(v1, v2);
        });

        // Verify the exact error message you wrote
        assertEquals("Vectors must have the same size.", exception.getMessage());
    }

    @Test
    void testAdd_NullVectorThrowsException() {
        // 1. Set up a normal vector and a null vector
        double[] v1 = {1.0, 2.0, 3.0};
        double[] v2 = null;

        // 2 & 3. Execute and Assert that it throws the correct exception
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtility.add(v1, v2);
        });

        // Verify the exact error message you wrote
        assertEquals("Vectors must not be null.", exception.getMessage());
    }
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