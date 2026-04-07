package com.bridgelabz;

public enum LengthUnit implements com.app.quantitymeasurement.unit.IMeasurable {

    FEET(1.0),
    INCHES(1.0 / 12.0);

    private final double factor;

    LengthUnit(double factor) {
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