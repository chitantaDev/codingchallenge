package de.chitanta.codingchallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder //for some reason Lombok doesn't work on this project 🤷🏾‍♂️ so enjoy some boilerplate code
public class NutzereingabeDto {
    private String firstname;
    private String lastname;
    private String plz;
    private String fahrzeugtyp;
    private Double kilometerleistung;

    public NutzereingabeDto() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getFahrzeugtyp() {
        return fahrzeugtyp;
    }

    public void setFahrzeugtyp(String fahrzeugtyp) {
        this.fahrzeugtyp = fahrzeugtyp;
    }

    public Double getKilometerleistung() {
        return kilometerleistung;
    }

    public void setKilometerleistung(Double kilometerleistung) {
        this.kilometerleistung = kilometerleistung;
    }
}
