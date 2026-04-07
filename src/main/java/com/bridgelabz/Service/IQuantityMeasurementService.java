package com.bridgelabz.Service;

import com.bridgelabz.DTO.QuantityInputDTO;
import com.bridgelabz.DTO.QuantityMeasurementDTO;

import java.util.List;

public interface IQuantityMeasurementService {

    QuantityMeasurementDTO compare(QuantityInputDTO input);

    QuantityMeasurementDTO add(QuantityInputDTO input);

    List<QuantityMeasurementDTO> getHistory(String operation);
}