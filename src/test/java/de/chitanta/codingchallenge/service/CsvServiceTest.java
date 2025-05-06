package de.chitanta.codingchallenge.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CsvServiceTest {
    @TempDir
    Path tempDir;

    @Test
    void testGetRegion1ByPostleitzahlFromCsvFile() throws IOException {
        File csvFile = tempDir.resolve("test-plz-data.csv").toFile();
        CsvService csvService = new CsvService();

        try (FileWriter fileWriter = new FileWriter(csvFile)) {
            fileWriter.write("ISO_3166_1_ALPHA_2,ISO_3166_1_ALPHA_2_REGION_CODE,REGION1,REGION2,REGION3,REGION4,POSTLEITZAHL,ORT,AREA1,AREA2,LATITUDE,LONGITUDE,ZEITZONE,UTC,SOMMERZEIT,ACTIVE\n");
            fileWriter.write("\"DE\",\"DE-BW\",\"Baden-Württemberg\",\"Freiburg\",\"Breisgau-Hochschwarzwald\",\"Bad Krozingen\",\"79189\",\"Bad Krozingen\",,,,47.91582,7.69985,\"Europe/Berlin\",\"UTC+1\",true,\"A\"");
        }

        String testPlz = "79189";

        String result = csvService.getRegion1ByPostleitzahlFromCsvFile(csvFile.getAbsolutePath(), testPlz);

        String expectedResult = "Baden-Württemberg";

        assertEquals(expectedResult, result);
    }
}