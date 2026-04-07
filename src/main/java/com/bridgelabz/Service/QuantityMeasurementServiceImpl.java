package com.bridgelabz.Service;

import com.bridgelabz.Entity.QuantityMeasurementEntity;
import com.bridgelabz.Repository.IQuantityMeasurementRepository;

public class QuantityMeasurementServiceImpl {

    private final IQuantityMeasurementRepository repo;

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repo) {
        this.repo = repo;
    }

    public void save(QuantityMeasurementEntity entity) {
        repo.save(entity);
    }
}