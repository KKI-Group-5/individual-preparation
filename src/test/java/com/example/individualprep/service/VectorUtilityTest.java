package com.example.individualprep.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorUtilityTest {

    // Instantiate the service class
    private final VectorUtility vectorUtility = new VectorUtility();

    @Test
    void subtract_sameLengthVectors_returnsElementWiseDifference() {
        double[] v1 = {5.0, 7.0, 9.0};
        double[] v2 = {2.0, 3.0, 4.0};

        double[] result = vectorUtility.subtract(v1, v2);

        assertArrayEquals(new double[] {3.0, 4.0, 5.0}, result, 1e-9);
    }

    @Test
    void subtract_withNegativeValues_handlesNegativesCorrectly() {
        double[] v1 = {-1.0, 0.0, 2.5};
        double[] v2 = {-3.0, 4.0, -0.5};

        double[] result = vectorUtility.subtract(v1, v2);

        assertArrayEquals(new double[] {2.0, -4.0, 3.0}, result, 1e-9);
    }

    @Test
    void subtract_doesNotMutateInputs() {
        double[] v1 = {10.0, 20.0};
        double[] v2 = {1.0, 2.0};

        double[] v1Before = v1.clone();
        double[] v2Before = v2.clone();

        vectorUtility.subtract(v1, v2);

        assertArrayEquals(v1Before, v1, 0.0);
        assertArrayEquals(v2Before, v2, 0.0);
    }

    @Test
    void subtract_returnsArraySameLengthAsFirstVector() {
        double[] v1 = {1.0, 2.0, 3.0, 4.0};
        double[] v2 = {0.5, 0.5, 0.5, 0.5};

        double[] result = vectorUtility.subtract(v1, v2);

        assertEquals(v1.length, result.length);
    }

    @Test
    void subtract_whenSecondVectorShorter_throwsArrayIndexOutOfBoundsException() {
        double[] v1 = {1.0, 2.0, 3.0};
        double[] v2 = {1.0, 2.0};

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> vectorUtility.subtract(v1, v2));
    }

    @Test
    void subtract_whenFirstVectorIsNull_throwsNullPointerException() {
        double[] v1 = null;
        double[] v2 = {1.0, 2.0, 3.0};

        assertThrows(NullPointerException.class, () -> vectorUtility.subtract(v1, v2));
    }

    @Test
    void subtract_whenSecondVectorIsNull_throwsNullPointerException() {
        double[] v1 = {1.0, 2.0, 3.0};
        double[] v2 = null;

        assertThrows(NullPointerException.class, () -> vectorUtility.subtract(v1, v2));
    }
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

    @Test
    void testDotProductNormalCase() {
        double[] v1 = {1.0, 2.0, 3.0};
        double[] v2 = {4.0, 5.0, 6.0};

        double result = vectorUtility.dotProduct(v1, v2);

        assertEquals(32.0, result);
    }

    @Test
    void testDotProductWithZeroVector() {
        double[] v1 = {0.0, 0.0, 0.0};
        double[] v2 = {1.0, 2.0, 3.0};

        double result = vectorUtility.dotProduct(v1, v2);

        assertEquals(0.0, result);
    }

    @Test
    void testDotProductWithNegativeValues() {
        double[] v1 = {-1.0, 2.0, -3.0};
        double[] v2 = {4.0, -5.0, 6.0};

        double result = vectorUtility.dotProduct(v1, v2);

        // (-1*4) + (2*-5) + (-3*6)
        // -4 -10 -18 = -32
        assertEquals(-32.0, result);
    }

    @Test
    void testDotProductDifferentLengthsThrowsException() {
        double[] v1 = {1.0, 2.0};
        double[] v2 = {1.0};

        assertThrows(IllegalArgumentException.class, () -> {
            vectorUtility.dotProduct(v1, v2);
        });
    }

    @Test
    void testDotProductNullVectorThrowsException() {
        double[] v1 = null;
        double[] v2 = {1.0, 2.0};

        assertThrows(IllegalArgumentException.class, () -> {
            vectorUtility.dotProduct(v1, v2);
        });
    }
}