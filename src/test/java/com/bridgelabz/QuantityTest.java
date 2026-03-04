package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityTest {

    private static final double EPSILON = 0.01;

    // =============================
    // SUBTRACTION TESTS
    // =============================

    @Test
    void testSubtraction_SameUnit_FeetMinusFeet() {

        Quantity<LengthUnit> a =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(5.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = a.subtract(b);

        assertEquals(5.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testSubtraction_CrossUnit_FeetMinusInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(6.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = feet.subtract(inches);

        assertEquals(9.5, result.getValue(), EPSILON);
    }

    @Test
    void testSubtraction_ExplicitTargetUnit_Inches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(6.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                feet.subtract(inches, LengthUnit.INCHES);

        assertEquals(114.0, result.getValue(), EPSILON);
    }

    @Test
    void testSubtraction_ResultingInNegative() {

        Quantity<LengthUnit> a =
                new Quantity<>(5.0, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = a.subtract(b);

        assertEquals(-5.0, result.getValue(), EPSILON);
    }

    @Test
    void testSubtraction_ResultingInZero() {

        Quantity<LengthUnit> feet =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(120.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = feet.subtract(inches);

        assertEquals(0.0, result.getValue(), EPSILON);
    }

    // =============================
    // DIVISION TESTS
    // =============================

    @Test
    void testDivision_SameUnit_FeetDividedByFeet() {

        Quantity<LengthUnit> a =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(2.0, LengthUnit.FEET);

        double result = a.divide(b);

        assertEquals(5.0, result, EPSILON);
    }

    @Test
    void testDivision_CrossUnit_InchesDividedByFeet() {

        Quantity<LengthUnit> inches =
                new Quantity<>(24.0, LengthUnit.INCHES);

        Quantity<LengthUnit> feet =
                new Quantity<>(2.0, LengthUnit.FEET);

        double result = inches.divide(feet);

        assertEquals(1.0, result, EPSILON);
    }

    @Test
    void testDivision_RatioGreaterThanOne() {

        Quantity<WeightUnit> a =
                new Quantity<>(10.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> b =
                new Quantity<>(5.0, WeightUnit.KILOGRAM);

        double result = a.divide(b);

        assertEquals(2.0, result, EPSILON);
    }

    @Test
    void testDivision_RatioLessThanOne() {

        Quantity<VolumeUnit> a =
                new Quantity<>(5.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> b =
                new Quantity<>(10.0, VolumeUnit.LITRE);

        double result = a.divide(b);

        assertEquals(0.5, result, EPSILON);
    }

    @Test
    void testDivision_RatioEqualToOne() {

        Quantity<VolumeUnit> a =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> b =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        double result = a.divide(b);

        assertEquals(1.0, result, EPSILON);
    }

    @Test
    void testDivision_ByZero() {

        Quantity<LengthUnit> a =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(0.0, LengthUnit.FEET);

        assertThrows(ArithmeticException.class, () -> {
            a.divide(b);
        });
    }

}