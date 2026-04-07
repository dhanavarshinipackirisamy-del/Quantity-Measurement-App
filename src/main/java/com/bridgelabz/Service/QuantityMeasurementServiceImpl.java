package com.bridgelabz.Service;

import com.bridgelabz.*;
import com.bridgelabz.DTO.QuantityDTO;
import com.bridgelabz.Entity.QuantityMeasurementEntity;
import com.bridgelabz.Repository.IQuantityMeasurementRepository;

public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    private IQuantityMeasurementRepository repo;

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repo) {
        this.repo = repo;
    }

    private IMeasurable getUnit(String unit) {
        try {
            return LengthUnit.valueOf(unit);
        } catch (Exception e) {
            try {
                return WeightUnit.valueOf(unit);
            } catch (Exception e2) {
                return VolumeUnit.valueOf(unit);
            }
        }
    }

    public QuantityDTO convert(QuantityDTO input, String targetUnit) {

        Quantity<IMeasurable> q =
                new Quantity<>(input.getValue(), getUnit(input.getUnit()));

        double result = q.convertTo(getUnit(targetUnit));

        repo.save(new QuantityMeasurementEntity("CONVERT", String.valueOf(result)));

        return new QuantityDTO(result, targetUnit);
    }

    public boolean compare(QuantityDTO q1, QuantityDTO q2) {

        Quantity<IMeasurable> a =
                new Quantity<>(q1.getValue(), getUnit(q1.getUnit()));

        Quantity<IMeasurable> b =
                new Quantity<>(q2.getValue(), getUnit(q2.getUnit()));

        boolean result = a.equals(b);

        repo.save(new QuantityMeasurementEntity("COMPARE", String.valueOf(result)));

        return result;
    }

    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {

        Quantity<IMeasurable> a =
                new Quantity<>(q1.getValue(), getUnit(q1.getUnit()));

        Quantity<IMeasurable> b =
                new Quantity<>(q2.getValue(), getUnit(q2.getUnit()));

        Quantity<IMeasurable> result =
                a.add(b, getUnit(q1.getUnit()));

        repo.save(new QuantityMeasurementEntity("ADD", String.valueOf(result.getValue())));

        return new QuantityDTO(result.getValue(), q1.getUnit());
    }
}