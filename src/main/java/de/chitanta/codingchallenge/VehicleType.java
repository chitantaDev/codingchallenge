package de.chitanta.codingchallenge;

public enum VehicleType {
    LKW("LKW", 400.0),
    AUTO("Auto", 250.0),
    MOTORRAD("Motorrad", 180.0),
    SCOOTER("Scooter", 120.0);


    private final String vehicleType;
    private final double factor;

    VehicleType(String name, double factor) {
        this.vehicleType = name;
        this.factor = factor;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public double getFactor() {
        return factor;
    }
}

