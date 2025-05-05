package de.chitanta.codingchallenge.regionalData;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegionalData {
    private String ISO_ALPHA;
    private String ISO_REGION_CODE;
    private String REGION1;
    private String REGION2;
    private String REGION3;
    private String REGION4;
    private String POSTLEITZAHL;
    private String ORT;
    private String AREA1;
    private String AREA2;
    private double LATITUDE;
    private double LONGITUDE;
    private String ZEITZONE;
    private String UTC;
    private boolean SOMMERZEIT;
    private char ACTIVE;

    public String getISO_ALPHA() {
        return ISO_ALPHA;
    }

    public void setISO_ALPHA(String ISO_ALPHA) {
        this.ISO_ALPHA = ISO_ALPHA;
    }

    public String getISO_REGION_CODE() {
        return ISO_REGION_CODE;
    }

    public void setISO_REGION_CODE(String ISO_REGION_CODE) {
        this.ISO_REGION_CODE = ISO_REGION_CODE;
    }

    public String getREGION1() {
        return REGION1;
    }

    public void setREGION1(String REGION1) {
        this.REGION1 = REGION1;
    }

    public String getREGION2() {
        return REGION2;
    }

    public void setREGION2(String REGION2) {
        this.REGION2 = REGION2;
    }

    public String getREGION3() {
        return REGION3;
    }

    public void setREGION3(String REGION3) {
        this.REGION3 = REGION3;
    }

    public String getREGION4() {
        return REGION4;
    }

    public void setREGION4(String REGION4) {
        this.REGION4 = REGION4;
    }

    public String getPOSTLEITZAHL() {
        return POSTLEITZAHL;
    }

    public void setPOSTLEITZAHL(String POSTLEITZAHL) {
        this.POSTLEITZAHL = POSTLEITZAHL;
    }

    public String getORT() {
        return ORT;
    }

    public void setORT(String ORT) {
        this.ORT = ORT;
    }

    public String getAREA1() {
        return AREA1;
    }

    public void setAREA1(String AREA1) {
        this.AREA1 = AREA1;
    }

    public String getAREA2() {
        return AREA2;
    }

    public void setAREA2(String AREA2) {
        this.AREA2 = AREA2;
    }

    public double getLATITUDE() {
        return LATITUDE;
    }

    public void setLATITUDE(double LATITUDE) {
        this.LATITUDE = LATITUDE;
    }

    public double getLONGITUDE() {
        return LONGITUDE;
    }

    public void setLONGITUDE(double LONGITUDE) {
        this.LONGITUDE = LONGITUDE;
    }

    public String getZEITZONE() {
        return ZEITZONE;
    }

    public void setZEITZONE(String ZEITZONE) {
        this.ZEITZONE = ZEITZONE;
    }

    public String getUTC() {
        return UTC;
    }

    public void setUTC(String UTC) {
        this.UTC = UTC;
    }

    public boolean isSOMMERZEIT() {
        return SOMMERZEIT;
    }

    public void setSOMMERZEIT(boolean SOMMERZEIT) {
        this.SOMMERZEIT = SOMMERZEIT;
    }

    public char getACTIVE() {
        return ACTIVE;
    }

    public void setACTIVE(char ACTIVE) {
        this.ACTIVE = ACTIVE;
    }
}
