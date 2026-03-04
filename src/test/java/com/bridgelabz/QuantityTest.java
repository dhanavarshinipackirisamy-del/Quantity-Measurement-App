package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityTest {

    private static final double EPSILON = 0.0001;

    // 1 L = 1 L
    @Test
    void testEquality_LitreToLitre() {
        Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> b = new Quantity<>(1.0, VolumeUnit.LITRE);

        assertTrue(a.equals(b));
    }

    // 1 L != 2 L
    @Test
    void testEquality_LitreDifferent() {
        Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> b = new Quantity<>(2.0, VolumeUnit.LITRE);

        assertFalse(a.equals(b));
    }

    // 1 L = 1000 mL
    @Test
    void testEquality_LitreToMillilitre() {
        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertTrue(litre.equals(ml));
    }

    // mL → L
    @Test
    void testConversion_MillilitreToLitre() {
        Quantity<VolumeUnit> ml = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = ml.convertTo(VolumeUnit.LITRE);

        assertEquals(1.0, result.getValue(), EPSILON);
    }

    // L → mL
    @Test
    void testConversion_LitreToMillilitre() {
        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result = litre.convertTo(VolumeUnit.MILLILITRE);

        assertEquals(1000.0, result.getValue(), EPSILON);
    }

    // Gallon → Litre
    @Test
    void testConversion_GallonToLitre() {
        Quantity<VolumeUnit> gallon = new Quantity<>(1.0, VolumeUnit.GALLON);

        Quantity<VolumeUnit> result = gallon.convertTo(VolumeUnit.LITRE);

        assertEquals(3.79, result.getValue(), EPSILON);
    }

    // L + L
    @Test
    void testAddition_LitrePlusLitre() {

        Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> b = new Quantity<>(2.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                a.add(b, VolumeUnit.LITRE);

        assertEquals(3.0, result.getValue(), EPSILON);
    }

    // L + mL
    @Test
    void testAddition_LitrePlusMillilitre() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                litre.add(ml, VolumeUnit.LITRE);

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    // Explicit target unit
    @Test
    void testAddition_TargetMillilitre() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                litre.add(ml, VolumeUnit.MILLILITRE);

        assertEquals(2000.0, result.getValue(), EPSILON);
    }

    // Gallon + Litre
    @Test
    void testAddition_GallonPlusLitre() {

        Quantity<VolumeUnit> gallon =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        Quantity<VolumeUnit> litre =
                new Quantity<>(3.78541, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                gallon.add(litre, VolumeUnit.GALLON);

        assertEquals(2.0, result.getValue(), EPSILON);
    }

}