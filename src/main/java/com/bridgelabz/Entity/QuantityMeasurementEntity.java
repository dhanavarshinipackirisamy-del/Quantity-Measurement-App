package com.bridgelabz.Entity;

public class QuantityMeasurementEntity {

    private String type;
    private double value1;
    private String unit1;
    private double value2;
    private String unit2;

    public QuantityMeasurementEntity(String type,
                                     double value1,
                                     String unit1,
                                     double value2,
                                     String unit2) {
        this.type = type;
        this.value1 = value1;
        this.unit1 = unit1;
        this.value2 = value2;
        this.unit2 = unit2;
    }

    public String getType() { return type; }
    public double getValue1() { return value1; }
    public String getUnit1() { return unit1; }
    public double getValue2() { return value2; }
    public String getUnit2() { return unit2; }
}