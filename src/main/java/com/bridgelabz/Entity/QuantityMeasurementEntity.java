package com.bridgelabz.Entity;

public class QuantityMeasurementEntity {

    private String operation;
    private String result;

    public QuantityMeasurementEntity(String operation, String result) {
        this.operation = operation;
        this.result = result;
    }

    public String toString() {
        return operation + " -> " + result;
    }
}