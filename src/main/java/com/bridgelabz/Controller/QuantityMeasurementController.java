package com.bridgelabz.Controller;

import com.bridgelabz.DTO.QuantityDTO;
import com.bridgelabz.Service.IQuantityMeasurementService;

public class QuantityMeasurementController {

    private IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service) {
        this.service = service;
    }

    public void compare(QuantityDTO q1, QuantityDTO q2) {
        System.out.println(service.compare(q1, q2));
    }

    public void convert(QuantityDTO q, String target) {
        System.out.println(service.convert(q, target));
    }

    public void add(QuantityDTO q1, QuantityDTO q2) {
        System.out.println(service.add(q1, q2));
    }
}