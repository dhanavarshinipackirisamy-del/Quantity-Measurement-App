package com.bridgelabz;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    private static final double EPSILON = 0.0001;

    public Quantity(double value, U unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid numeric value");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    private double toBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    private double round(double val) {
        return Math.round(val * 100.0) / 100.0;
    }

    // =========================
    // Equality
    // =========================
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Quantity<?> other = (Quantity<?>) obj;

        double diff =
                Math.abs(this.toBaseUnit() - other.toBaseUnit());

        return diff < EPSILON;
    }

    // =========================
    // Conversion
    // =========================
    public Quantity<U> convertTo(U targetUnit) {

        double baseValue = unit.convertToBaseUnit(value);

        double converted =
                targetUnit.convertFromBaseUnit(baseValue);

        return new Quantity<>(round(converted), targetUnit);
    }

    // =========================
    // Addition
    // =========================
    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        validate(other, targetUnit);

        double baseSum =
                this.toBaseUnit() + other.toBaseUnit();

        double result =
                targetUnit.convertFromBaseUnit(baseSum);

        return new Quantity<>(round(result), targetUnit);
    }

    // =========================
    // Subtraction (implicit unit)
    // =========================
    public Quantity<U> subtract(Quantity<U> other) {

        return subtract(other, this.unit);
    }

    // =========================
    // Subtraction (explicit unit)
    // =========================
    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {

        validate(other, targetUnit);

        double baseResult =
                this.toBaseUnit() - other.toBaseUnit();

        double result =
                targetUnit.convertFromBaseUnit(baseResult);

        return new Quantity<>(round(result), targetUnit);
    }

    // =========================
    // Division
    // =========================
    public double divide(Quantity<U> other) {

        if (other == null)
            throw new IllegalArgumentException("Quantity cannot be null");

        double base1 = this.toBaseUnit();
        double base2 = other.toBaseUnit();

        if (base2 == 0)
            throw new ArithmeticException("Division by zero");

        return base1 / base2;
    }

    // =========================
    // Validation
    // =========================
    private void validate(Quantity<U> other, U targetUnit) {

        if (other == null)
            throw new IllegalArgumentException("Quantity cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        if (!this.unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Cross-category operation not allowed");
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}