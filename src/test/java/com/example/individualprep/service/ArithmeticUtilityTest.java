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

}