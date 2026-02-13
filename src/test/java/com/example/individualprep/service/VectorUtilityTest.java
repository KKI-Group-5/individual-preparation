package com.example.individualprep.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorUtilityTest {

    private final VectorUtility vectorUtility = new VectorUtility();

    @Test
    void norm_shouldReturnEuclideanNorm() {
        double[] v = {3.0, 4.0};
        assertEquals(5.0, vectorUtility.norm(v), 1e-9);
    }

    @Test
    void norm_shouldWorkForZeros() {
        double[] v = {0.0, 0.0, 0.0};
        assertEquals(0.0, vectorUtility.norm(v), 1e-9);
    }

    @Test
    void norm_shouldWorkForNegativeValues() {
        double[] v = {-3.0, -4.0};
        assertEquals(5.0, vectorUtility.norm(v), 1e-9);
    }

}