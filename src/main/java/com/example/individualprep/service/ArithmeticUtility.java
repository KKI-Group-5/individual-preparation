package com.example.individualprep.service;

import org.springframework.stereotype.Service;

@Service
public class ArithmeticUtility {

    public double add(double o1, double o2) {
        // TODO: Implement me properly!
        return 0.0;
    }

    public double subtract(double o1, double o2) {
        // TODO: Implement me properly!
        return 0.0;
    }

    public double multiply(double o1, double o2) {
        // TODO: Implement me properly!
        return 0.0;
    }

    public double divide(double o1, double o2) {
        // TODO: Implement me properly!
        return 0.0;
    }

    public double exponent(double o1, int n) {

        if ((o1 == 0.0) && (n < 0)) {
            throw new IllegalArgumentException("Cannot raise zero to a negative power due to division by zero.");
        }

        return Math.pow(o1, n);
    }
}
