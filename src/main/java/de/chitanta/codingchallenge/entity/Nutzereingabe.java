package de.chitanta.codingchallenge.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "nutzereingabe")
public class Nutzereingabe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "antragssteller_id", referencedColumnName = "id")
    private Antragssteller antragssteller;

    @Column(name = "kilometerleistung")
    private Double kilometerleistung;

    @Column(name = "plz")
    private String plz;

    @Column(name = "fahrzeugtyp")
    private String fahrzeugtyp;

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Antragssteller getAntragssteller() {
        return antragssteller;
    }

    public void setAntragssteller(Antragssteller antragssteller) {
        this.antragssteller = antragssteller;
    }

    public Double getKilometerleistung() {
        return kilometerleistung;
    }

    public void setKilometerleistung(Double kilometerleistung) {
        this.kilometerleistung = kilometerleistung;
    }

    public String getFahrzeugtyp() {
        return fahrzeugtyp;
    }

    public void setFahrzeugtyp(String fahrzeugtyp) {
        this.fahrzeugtyp = fahrzeugtyp;
    }
}
