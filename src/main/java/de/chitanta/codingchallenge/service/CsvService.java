package de.chitanta.codingchallenge.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import de.chitanta.codingchallenge.regionalData.RegionalData;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class CsvService {

    public static final int CSV_PLZ_INDEX = 6;
    public static final int CSV_REGION_1_INDEX = 2;

    /**
     * Retrieves the region from the parsed csv file path, based upon the plz parameter
     * @param path
     * @param plz
     * @return
     */
    public String getRegion1ByPostleitzahlFromCsvFile(String path, String plz) {
        try (CSVReader csvReader = new CSVReader(new FileReader(path))) {
            String[] values;
            csvReader.readNext(); // skip header

            while ((values = csvReader.readNext()) != null) {
                String postleitzahl = values[CSV_PLZ_INDEX];

                if (postleitzahl.equals(plz)) {
                    return values[CSV_REGION_1_INDEX];
                }
            }

            return null;

        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("RuntimeException thrown: " + e.getMessage());
        }
    }

    // Unused methods from here on forwards
    /**
     * OpenCsv doc standard implementation
     * @param path
     * @return
     */
    public List<List<String>> parseCsvFileIntoList(String path){
        List<List<String>> records = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(path));) {
            String[] values = null;
            csvReader.readNext();

            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
            return records;
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("RuntimeException thrown: " + e.getMessage());
        }
    }

    // Benchmarktests: reading directly from csv faster by aprox. 300ms.
    // Leaving this method for future use. No usage for it at this time
    /**
     * Iterates through all CSV file entries and maps them to a hashset.
     * time complexity O(1).
     * @param path
     * @return
     */
    public HashSet<RegionalData> createHashSetFromPostcodesCSVFile(String path){
        HashSet<RegionalData> regionalDataHashSet = new HashSet<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(path));) {
            String[] values = null;
            csvReader.readNext(); //skips header

            while ((values = csvReader.readNext()) != null) {
                RegionalData regionalData = new RegionalData();

                regionalData.setISO_ALPHA(values[0]);
                regionalData.setISO_REGION_CODE(values[1]);
                regionalData.setREGION1(values[2]);
                regionalData.setREGION2(values[3]);
                regionalData.setREGION3(values[4]);
                regionalData.setREGION4(values[5]);
                regionalData.setPOSTLEITZAHL(values[6]);
                regionalData.setORT(values[7]);
                regionalData.setAREA1(values[8]);
                regionalData.setAREA2(values[9]);
                regionalData.setLATITUDE(Float.parseFloat(values[10]));
                regionalData.setLONGITUDE(Float.parseFloat(values[11]));
                regionalData.setZEITZONE(values[12]);
                regionalData.setUTC(values[13]);
                regionalData.setSOMMERZEIT(Boolean.parseBoolean(values[14]));
                regionalData.setACTIVE(values[15].charAt(0));

                regionalDataHashSet.add(regionalData);
            }

            return regionalDataHashSet;

        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("RuntimeException thrown: " + e.getMessage());
        }
    }
}
