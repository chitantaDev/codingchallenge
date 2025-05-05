package de.chitanta.codingchallenge;

public enum VehicleType {
    LKW("LKW", 2.0),
    AUTO("Auto", 1.6),
    MOTORRAD("Motorrad", 1.3),
    SCOOTER("Scooter", 1.0);

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

