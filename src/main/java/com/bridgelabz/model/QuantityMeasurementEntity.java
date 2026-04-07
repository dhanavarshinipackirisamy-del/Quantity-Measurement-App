package com.bridgelabz.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "quantity_measurement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuantityMeasurementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double thisValue;
    private String thisUnit;
    private String thisMeasurementType;   // ✅ ADD THIS

    private double thatValue;
    private String thatUnit;
    private String thatMeasurementType;   // ✅ ADD THIS

    private String operation;

    private Double resultValue;
    private String resultUnit;

    private String resultString;

    private boolean isError;
}