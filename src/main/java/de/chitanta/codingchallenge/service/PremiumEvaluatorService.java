package de.chitanta.codingchallenge.service;

import de.chitanta.codingchallenge.RegionFactor;
import de.chitanta.codingchallenge.VehicleType;
import de.chitanta.codingchallenge.regionalData.RegionalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class PremiumEvaluatorService {
    private final CsvService csvService;
    private final String CSV_FILE_PATH = "postcodes.csv";

    //unused constants for dev purposes
    private final String REGION_FACTOR_CSV_PATH = "regionfactor.csv";
    private static final String TEMP_AUTO = "Auto";
    private static final double TEMP_KMH = 10000;
    private final String TEMP_PLZ = "44147";
    private final int CSV_PLZ_INDEX = 6;
    //end of unused constants

    @Autowired
    public PremiumEvaluatorService(CsvService csvService) {
        this.csvService = csvService;
    }

    public double getRegionFactor(String plz) {

        return getRegionFactorByRegion(extractRegionOneFromCsv(plz));
    }

    /**
     * Returns name of the state from the CSV file (Region1 field) based upon the plz parameter
     * @param plz
     * @return
     */
    public String extractRegionOneFromCsv(String plz) {
        String region1ByPostleitzahl = csvService.getRegion1ByPostleitzahlFromCsvFile(CSV_FILE_PATH, plz);
        System.out.println("Region: " + region1ByPostleitzahl);

        return region1ByPostleitzahl;
    }

    /**
     * Returns the region factor from the Region Factor ENUM class based upon the regionParam (state name/Bundesland )
     *
     */
    public double getRegionFactorByRegion(String regionParam) {
        for (RegionFactor entry: RegionFactor.values()) {
            if (entry.getRegion().equalsIgnoreCase(regionParam)) {
                System.out.println("Region factor: " + entry.getFactor());
                return entry.getFactor();
            }
        }
        throw new IllegalArgumentException("Bundesland existiert nicht");
    }

    /**
     * Returns vehicle type factor based upon the parameter from VehicleType ENUM class
     * @param vehicleTypeParam
     * @return
     */
    public double getVehicleFactorByVehicleType(String vehicleTypeParam) {
        for (VehicleType entry: VehicleType.values()) {
            if (entry.getVehicleType().equalsIgnoreCase(vehicleTypeParam)) {
                System.out.println("Vehicle factor: " + entry.getFactor());
                return entry.getFactor();
            }
        }
        throw new IllegalArgumentException("Fahrzeugtyp existiert nicht");
    }

    private double getKmFactor(double km) {
        double kmFactor;

        if (km <= 5000) {
            kmFactor = 0.5;
        } else if (km > 5000 && km <= 10000) {
            kmFactor = 1.0;
        } else if (km > 10000 && km <= 20000) {
            kmFactor = 1.5;
        } else {
            kmFactor = 2.0;
        }

        System.out.println("Km factor: " + kmFactor);

        return kmFactor;
    }

    //TODO: truncate to 2 decimals
    public double calculatePremium(String plz, String vehicleType, double km) {
        return getRegionFactor(plz) * getVehicleFactorByVehicleType(vehicleType) * getKmFactor(km);
    }

    // Unused method: Less efficient + overkill. Reading directly from the CSV file overall is faster.
    public String extractPlzFromRegionSet() {
        HashSet<RegionalData> regionalDataHashSet = csvService.createHashSetFromPostcodesCSVFile(CSV_FILE_PATH);
        String region1 = "";
        for (RegionalData regionalData : regionalDataHashSet) {
            if (TEMP_PLZ.equals(regionalData.getPOSTLEITZAHL())) {
                System.out.println("Found matching POSTLEITZAHL '44147'");
                System.out.println("REGION1 (BUNDESLAND): " + regionalData.getREGION1());
                region1 = regionalData.getREGION1();
                break;
            }
        }

        return region1;
    }
}
