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

    public String getRegion1ByPostleitzahl(String path, String plz) {
        try (CSVReader csvReader = new CSVReader(new FileReader(path))) {
            String[] values;
            csvReader.readNext(); // skip header

            while ((values = csvReader.readNext()) != null) {
                String postleitzahl = values[6];

                if (postleitzahl.equals(plz)) {
                    return values[2];
                }
            }

            return null;

        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("RuntimeException thrown: " + e.getMessage());
        }
    }

    // Benchmarktests: reading directly from csv faster by 300ms. Leaving this method for future use
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
