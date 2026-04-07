package com.app.quantitymeasurement.unit;

public enum WeightUnit implements com.app.quantitymeasurement.unit.IMeasurable {

    KILOGRAM(1.0),
    GRAM(0.001);

    private final double factor;

    WeightUnit(double factor) {
        this.factor = factor;
    }

    public double toBaseUnit(double value) {
        return value * factor;
    }

    public double fromBaseUnit(double base) {
        return base / factor;
    }

    public String getUnitName() {
        return name();
    }
}