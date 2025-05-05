package de.chitanta.codingchallenge;

public enum RegionFactor {
    BADEN_WUERTTEMBERG("Baden-Württemberg", 1.1),
    BAYERN("Bayern", 1.2),
    BERLIN("Berlin", 1.3),
    BRANDENBURG("Brandenburg", 1.0),
    BREMEN("Bremen", 1.4),
    HAMBURG("Hamburg", 1.4),
    HESSEN("Hessen", 1.1),
    MECKLENBURG_VORPOMMERN("Mecklenburg-Vorpommern", 1.8),
    NIEDERSACHSEN("Niedersachsen", 1.0),
    NORDRHEIN_WESTFALEN("Nordrhein-Westfalen", 1.2),
    RHEINLAND_PFALZ("Rheinland-Pfalz", 1.1),
    SAARLAND("Saarland", 1.0),
    SACHSEN("Sachsen", 1.0),
    SACHSEN_ANHALT("Sachsen-Anhalt", 1.9),
    SCHLESWIG_HOLSTEIN("Schleswig-Holstein", 1.0),
    THUERINGEN("Thüringen", 1.7);

    private final String region;
    private final double factor;

    RegionFactor(String region, double factor) {
        this.region = region;
        this.factor = factor;
    }

    public String getRegion() {
        return region;
    }

    public double getFactor() {
        return factor;
    }

}
