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
}