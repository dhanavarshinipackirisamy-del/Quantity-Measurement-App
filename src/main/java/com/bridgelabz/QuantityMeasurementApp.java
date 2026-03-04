package com.bridgelabz;

public class QuantityMeasurementApp {

    public static <U extends IMeasurable> void demonstrateSubtraction(
            Quantity<U> q1, Quantity<U> q2, U targetUnit) {

        System.out.println("Subtraction: " +
                q1.subtract(q2, targetUnit));
    }

    public static <U extends IMeasurable> void demonstrateDivision(
            Quantity<U> q1, Quantity<U> q2) {

        System.out.println("Division Ratio: " +
                q1.divide(q2));
    }

    public static void main(String[] args) {

        System.out.println("=== LENGTH ===");

        Quantity<LengthUnit> l1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> l2 =
                new Quantity<>(6.0, LengthUnit.INCHES);

        demonstrateSubtraction(l1, l2, LengthUnit.FEET);

        demonstrateDivision(
                new Quantity<>(24.0, LengthUnit.INCHES),
                new Quantity<>(2.0, LengthUnit.FEET));


        System.out.println("\n=== WEIGHT ===");

        Quantity<WeightUnit> w1 =
                new Quantity<>(10.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 =
                new Quantity<>(5000.0, WeightUnit.GRAM);

        demonstrateSubtraction(w1, w2, WeightUnit.KILOGRAM);

        demonstrateDivision(
                new Quantity<>(10.0, WeightUnit.KILOGRAM),
                new Quantity<>(5.0, WeightUnit.KILOGRAM));


        System.out.println("\n=== VOLUME ===");

        Quantity<VolumeUnit> v1 =
                new Quantity<>(5.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(500.0, VolumeUnit.MILLILITRE);

        demonstrateSubtraction(v1, v2, VolumeUnit.LITRE);

        demonstrateDivision(
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE),
                new Quantity<>(1.0, VolumeUnit.LITRE));
    }
}