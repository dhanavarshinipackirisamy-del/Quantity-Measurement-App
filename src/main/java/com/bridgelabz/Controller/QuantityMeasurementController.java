package com.bridgelabz.Controller;

import com.bridgelabz.DTO.*;
import com.bridgelabz.Service.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quantities")
public class QuantityMeasurementController {

    @Autowired
    private IQuantityMeasurementService service;

    @PostMapping("/compare")
    public QuantityMeasurementDTO compare(@RequestBody QuantityInputDTO input) {
        return service.compare(input);
    }

    @PostMapping("/add")
    public QuantityMeasurementDTO add(@RequestBody QuantityInputDTO input) {
        return service.add(input);
    }

    @GetMapping("/history/{operation}")
    public List<QuantityMeasurementDTO> history(@PathVariable String operation) {
        return service.getHistory(operation);
    }
}