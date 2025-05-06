package de.chitanta.codingchallenge.service;

import de.chitanta.codingchallenge.RegionFactor;
import de.chitanta.codingchallenge.VehicleType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PremiumEvaluatorServiceTest {
    PremiumEvaluatorService pes = new PremiumEvaluatorService(new CsvService());

    @Test
    void testGetRegionFactorByRegion() {
        String testRegion = "Berlin";
        String falseRegion = "Brisbane";

        double expectedResult = RegionFactor.BERLIN.getFactor();
        double result = pes.getRegionFactorByRegion(testRegion);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> pes.getRegionFactorByRegion(falseRegion)
        );

        assertEquals(expectedResult, result);
        assertEquals("Bundesland existiert nicht", exception.getMessage());
    }

    @Test
    void testGetVehicleFactorByVehicleType() {
        String testVehicleType = "Scooter";
        String falseVehicleType = "Boat";

        double expectedResult = VehicleType.SCOOTER.getFactor();
        double result = pes.getVehicleFactorByVehicleType(testVehicleType);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> pes.getVehicleFactorByVehicleType(falseVehicleType)
        );

        assertEquals(expectedResult, result);
        assertEquals("Fahrzeugtyp existiert nicht", exception.getMessage());
    }

    @Test
    void testCalculatePremium() {
        String testPlz = "44145";
        String testVehicleType = "Auto";
        double testKm = 10000;

        double expectedResult = 300;
        double result = pes.calculatePremium(testPlz, testVehicleType, testKm);

        assertEquals(expectedResult, result);
    }
}