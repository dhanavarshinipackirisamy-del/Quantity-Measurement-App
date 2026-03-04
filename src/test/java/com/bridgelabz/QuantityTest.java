package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityTest {

    private static final double EPSILON = 0.01;

    @Test
    void testAddition() {

        Quantity<LengthUnit> a =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = a.add(b);

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    void testSubtraction() {

        Quantity<LengthUnit> a =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(6.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = a.subtract(b);

        assertEquals(9.5, result.getValue(), EPSILON);
    }

    @Test
    void testDivision() {

        Quantity<LengthUnit> a =
                new Quantity<>(24.0, LengthUnit.INCHES);

        Quantity<LengthUnit> b =
                new Quantity<>(2.0, LengthUnit.FEET);

        double result = a.divide(b);

        assertEquals(1.0, result, EPSILON);
    }

    @Test
    void testVolumeAddition() {

        Quantity<VolumeUnit> a =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> b =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = a.add(b);

        assertEquals(2.0, result.getValue(), EPSILON);
    }

}