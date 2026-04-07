package com.bridgelabz.Service;

import com.bridgelabz.DTO.*;
import com.bridgelabz.model.QuantityMeasurementEntity;
import com.bridgelabz.Repository.QuantityMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    @Autowired
    private QuantityMeasurementRepository repository;

    // ✅ COMPARE
    @Override
    public QuantityMeasurementDTO compare(QuantityInputDTO input) {

        double v1 = input.getThisQuantityDTO().getValue();
        double v2 = input.getThatQuantityDTO().getValue();

        boolean result = v1 == v2;

        QuantityMeasurementEntity entity = new QuantityMeasurementEntity();

        entity.setThisValue(v1);
        entity.setThatValue(v2);
        entity.setThisUnit(input.getThisQuantityDTO().getUnit());
        entity.setThatUnit(input.getThatQuantityDTO().getUnit());

        entity.setOperation("COMPARE");
        entity.setResultString(String.valueOf(result));
        entity.setError(false);

        repository.save(entity);

        return QuantityMeasurementDTO.fromEntity(entity);
    }

    // ✅ ADD
    @Override
    public QuantityMeasurementDTO add(QuantityInputDTO input) {

        double v1 = input.getThisQuantityDTO().getValue();
        double v2 = input.getThatQuantityDTO().getValue();

        double sum = v1 + v2;

        QuantityMeasurementEntity entity = new QuantityMeasurementEntity();

        entity.setThisValue(v1);
        entity.setThatValue(v2);
        entity.setThisUnit(input.getThisQuantityDTO().getUnit());
        entity.setThatUnit(input.getThatQuantityDTO().getUnit());
        entity.setOperation("ADD");
        entity.setResultValue(sum);
        entity.setResultUnit(input.getThisQuantityDTO().getUnit());
        entity.setError(false);

        repository.save(entity);

        return QuantityMeasurementDTO.fromEntity(entity);
    }

    // ✅ HISTORY
    @Override
    public List<QuantityMeasurementDTO> getHistory(String operation) {

        return repository.findByOperation(operation)
                .stream()
                .map(QuantityMeasurementDTO::fromEntity)
                .collect(Collectors.toList());
    }
}