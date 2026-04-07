package com.bridgelabz.Controller;
import com.bridgelabz.Entity.QuantityMeasurementEntity;
import com.bridgelabz.Service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementController {

    private final QuantityMeasurementServiceImpl service;

    public QuantityMeasurementController(QuantityMeasurementServiceImpl service) {
        this.service = service;
    }

    public void performOperation(QuantityMeasurementEntity entity) {
        service.save(entity);
    }
}