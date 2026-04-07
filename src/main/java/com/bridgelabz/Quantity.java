package com.app.quantitymeasurement;

import com.app.quantitymeasurement.unit.IMeasurable;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public Quantity<U> convertTo(U targetUnit) {
        double base = unit.toBaseUnit(value);
        double converted = targetUnit.fromBaseUnit(base);
        return new Quantity<>(converted, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        double base1 = unit.toBaseUnit(value);
        double base2 = other.unit.toBaseUnit(other.value);

        double result = base1 + base2;
        double converted = targetUnit.fromBaseUnit(result);

        return new Quantity<>(converted, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Quantity<?> q)) return false;

        double base1 = unit.toBaseUnit(value);
        double base2 = ((IMeasurable) q.unit).toBaseUnit(q.value);

        return Math.abs(base1 - base2) < 0.01;
    }
}