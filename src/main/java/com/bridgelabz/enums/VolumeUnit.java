package com.bridgelabz.enums;

public enum VolumeUnit implements IMeasurable {

    LITRE(1.0),
    MILLILITRE(0.001),
    GALLON(3.78541);

    private final double factor;

    VolumeUnit(double factor) {
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