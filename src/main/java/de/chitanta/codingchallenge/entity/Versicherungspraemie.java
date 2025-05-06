package de.chitanta.codingchallenge.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter //for some reason Lombok doesn't work on this project 🤷🏾‍♂️ so enjoy some boilerplate code
@Entity
@Table(name = "versicherungspraemie")
public class Versicherungspraemie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "antragssteller_id", referencedColumnName = "id")
    private Antragssteller antragssteller;

    @ManyToOne
    @JoinColumn(name = "nutzereingabe_id", referencedColumnName = "id")
    private Nutzereingabe nutzereingabe;

    @Column(name = "praemie")
    private Double praemie;

    public Double getPraemie() {
        return praemie;
    }

    public void setPraemie(Double praemie) {
        this.praemie = praemie;
    }

    public Nutzereingabe getNutzereingabe() {
        return nutzereingabe;
    }

    public void setNutzereingabe(Nutzereingabe nutzereingabe) {
        this.nutzereingabe = nutzereingabe;
    }

    public Antragssteller getAntragssteller() {
        return antragssteller;
    }

    public void setAntragssteller(Antragssteller antragssteller) {
        this.antragssteller = antragssteller;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
