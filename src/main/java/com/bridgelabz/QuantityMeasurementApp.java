package com.bridgelabz;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity<LengthUnit> l1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> l2 =
                new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("Addition: " + l1.add(l2));
        System.out.println("Subtraction: " + l1.subtract(l2));
        System.out.println("Division: " + l1.divide(l2));

        Quantity<WeightUnit> w1 =
                new Quantity<>(10.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 =
                new Quantity<>(5000.0, WeightUnit.GRAM);

        System.out.println("Weight Addition: " + w1.add(w2));

        Quantity<VolumeUnit> v1 =
                new Quantity<>(5.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(500.0, VolumeUnit.MILLILITRE);

        System.out.println("Volume Subtraction: " + v1.subtract(v2));
    }
}