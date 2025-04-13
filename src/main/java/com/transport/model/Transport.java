package com.transport.model;

import jakarta.persistence.*;

@Entity
@Table(name="transport")
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transportId;

    private String vehicleType;
    private int capacity;

    // Getters
    public Long getTransportId() {
        return transportId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getCapacity() {
        return capacity;
    }

    // Setters
    public void setTransportId(Long transportId) {
        this.transportId = transportId;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
    