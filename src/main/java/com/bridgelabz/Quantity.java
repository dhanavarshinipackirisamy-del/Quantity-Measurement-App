package com.bridgelabz;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    private double toBase() {
        return unit.convertToBaseUnit(value);
    }

    public double convertTo(U target) {
        double base = toBase();
        return target.convertFromBaseUnit(base);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        double sum = this.toBase() + other.toBase();
        return new Quantity<>(targetUnit.convertFromBaseUnit(sum), targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Quantity<?> other)) return false;
        return Math.abs(this.toBase() - other.toBase()) < 0.01;
    }

    @Override
    public String toString() {
        return value + " " + unit.getUnitName();
    }
}