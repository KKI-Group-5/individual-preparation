package com.example.individualprep.service;

import org.springframework.stereotype.Service;

@Service
public class VectorUtility {

    public double[] add(double[] v1, double[] v2) {

        if (v1 == null || v2 == null) {
            throw new IllegalArgumentException("Vectors must not be null.");
        }

        if (v1.length != v2.length) {
            throw new IllegalArgumentException("Vectors must have the same size.");
        }

        int vectorLength = v1.length;
        double[] vectorAddResult = new double[vectorLength];

        for(int i = 0; i < vectorLength; i++) {
            vectorAddResult[i] = v1[i] + v2[i];
        }

        return vectorAddResult;
    }

    public double[] subtract(double[] v1, double[] v2) {
        // TODO: Implement me properly!
        return new double[] { 0.0, 0.0, 0.0 };
    }

    public double[] multiply(double[] v1, int x) {
        // TODO: Implement me properly!
        return new double[] { 0.0, 0.0, 0.0 };
    }

    public double dotProduct(double[] v1, double[] v2) {
        // TODO: Implement me properly!
        return 0.0;
    }

    public double norm(double[] v1) {
        // TODO: Implement me properly!
        return 0.0;
    }
}