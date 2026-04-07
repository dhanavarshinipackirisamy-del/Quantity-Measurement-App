package com.bridgelabz;

import com.bridgelabz.Controller.QuantityMeasurementController;
import com.bridgelabz.Entity.QuantityMeasurementEntity;
import com.bridgelabz.Repository.IQuantityMeasurementRepository;
import com.bridgelabz.Repository.QuantityMeasurementDatabaseRepository;
import com.bridgelabz.Service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // ✅ Choose repository (DB version for UC16)
        IQuantityMeasurementRepository repository =
                new QuantityMeasurementDatabaseRepository();

        // ✅ Service layer
        QuantityMeasurementServiceImpl service =
                new QuantityMeasurementServiceImpl(repository);

        // ✅ Controller layer
        QuantityMeasurementController controller =
                new QuantityMeasurementController(service);

        // ✅ Sample Data
        QuantityMeasurementEntity entity1 =
                new QuantityMeasurementEntity("LENGTH", 1.0, "FEET", 12.0, "INCHES");

        QuantityMeasurementEntity entity2 =
                new QuantityMeasurementEntity("WEIGHT", 1.0, "KILOGRAM", 1000.0, "GRAM");

        // ✅ Perform operations
        controller.performOperation(entity1);
        controller.performOperation(entity2);

        System.out.println("✅ Data saved successfully (DB or Cache)");
    }
}