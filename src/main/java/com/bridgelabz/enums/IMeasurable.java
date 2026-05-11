package com.bridgelabz.enums;

public interface IMeasurable {
    double toBaseUnit(double value);
    double fromBaseUnit(double baseValue);
    String getUnitName();
}