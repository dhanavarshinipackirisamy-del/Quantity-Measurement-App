package com.bridgelabz.DTO;

import com.bridgelabz.model.QuantityMeasurementEntity;
import lombok.Data;

@Data
public class QuantityMeasurementDTO {

    private double resultValue;
    private String resultUnit;
    private String operation;
    private boolean error;

    public static QuantityMeasurementDTO fromEntity(QuantityMeasurementEntity entity) {
        QuantityMeasurementDTO dto = new QuantityMeasurementDTO();
        dto.setResultValue(entity.getResultValue() != null ? entity.getResultValue() : 0);
        dto.setResultUnit(entity.getResultUnit());
        dto.setOperation(entity.getOperation());
        dto.setError(entity.isError());
        return dto;
    }
}