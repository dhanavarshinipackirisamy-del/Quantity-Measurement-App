package com.bridgelabz.Repository;

import com.bridgelabz.Entity.QuantityMeasurementEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementDatabaseRepository implements IQuantityMeasurementRepository {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
    }

    @Override
    public void save(QuantityMeasurementEntity entity) {

        String sql = "INSERT INTO quantity_measurement(type,value,unit,operation) VALUES (?,?,?,?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, entity.getType());
            ps.setDouble(2, entity.getValue());
            ps.setString(3, entity.getUnit());
            ps.setString(4, entity.getOperation());

            ps.executeUpdate();

        } catch (Exception e) {
            throw new DatabaseException("Insert failed", e);
        }
    }

    @Override
    public List<QuantityMeasurementEntity> findAll() {

        List<QuantityMeasurementEntity> list = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM quantity_measurement")) {

            while (rs.next()) {
                list.add(new QuantityMeasurementEntity(
                        rs.getString("type"),
                        rs.getDouble("value"),
                        rs.getString("unit"),
                        rs.getString("operation")
                ));
            }

        } catch (Exception e) {
            throw new DatabaseException("Fetch failed", e);
        }

        return list;
    }

    @Override
    public void deleteAll() {
        try (Connection conn = getConnection();
             Statement st = conn.createStatement()) {

            st.execute("DELETE FROM quantity_measurement");

        } catch (Exception e) {
            throw new DatabaseException("Delete failed", e);
        }
    }
}