package com.example.individualprep.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorUtilityTest {

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
}