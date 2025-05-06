package de.chitanta.codingchallenge.controller;

import de.chitanta.codingchallenge.dto.NutzereingabeDto;
import de.chitanta.codingchallenge.entity.Antragssteller;
import de.chitanta.codingchallenge.entity.Nutzereingabe;
import de.chitanta.codingchallenge.entity.Versicherungspraemie;
import de.chitanta.codingchallenge.repository.AntragsstellerRepository;
import de.chitanta.codingchallenge.repository.NutzereingabeRepository;
import de.chitanta.codingchallenge.repository.VersicherungspraemieRepository;
import de.chitanta.codingchallenge.service.PremiumEvaluatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/premium") //TODO smarter mapping names
public class Controller {
    private final PremiumEvaluatorService premiumEvaluatorService;
    private final AntragsstellerRepository antragsstellerRepository;
    private final NutzereingabeRepository nutzereingabeRepository;
    private final VersicherungspraemieRepository versicherungspraemieRepository;

    public Controller(PremiumEvaluatorService premiumEvaluatorService, AntragsstellerRepository antragsstellerRepository,
                      NutzereingabeRepository nutzereingabeRepository, VersicherungspraemieRepository versicherungspraemieRepository) {
        this.premiumEvaluatorService = premiumEvaluatorService;
        this.antragsstellerRepository = antragsstellerRepository;
        this.nutzereingabeRepository = nutzereingabeRepository;
        this.versicherungspraemieRepository = versicherungspraemieRepository;
    }

    //TODO seperation of concerns: get the steps into a service instead of having logic in a controller

    /**
     * Receives user input from frontend inside the RequestBody.
     * Creates new user if user doesn't exist. Persists user, user input aswell as the calculations and returns the results
     * @param dto
     * @return
     */
    @PostMapping("/save/nutzereingabe")
    public ResponseEntity<Double> saveUserPremiumDetails(@RequestBody NutzereingabeDto dto) {
        // 1 - Check if Antragssteller exists -> if not, create one
        Optional<Antragssteller> optionalAntragssteller =
                antragsstellerRepository.findByFirstnameAndLastname(dto.getFirstname(), dto.getLastname());

        Antragssteller antragssteller;
        if (optionalAntragssteller.isPresent()) {
            antragssteller = optionalAntragssteller.get();
        } else {
            antragssteller = new Antragssteller();
            antragssteller.setFirstname(dto.getFirstname());
            antragssteller.setLastname(dto.getLastname());
            antragsstellerRepository.save(antragssteller);
        }

        // 2 - Create and save Nutzereingabe
        Nutzereingabe nutzereingabe = new Nutzereingabe();
        nutzereingabe.setAntragssteller(antragssteller);
        nutzereingabe.setPlz(dto.getPlz());
        nutzereingabe.setFahrzeugtyp(dto.getFahrzeugtyp());
        nutzereingabe.setKilometerleistung(dto.getKilometerleistung());
        nutzereingabeRepository.save(nutzereingabe);

        // 3 - Calculate premium
        double praemie = premiumEvaluatorService.calculatePremium(
                nutzereingabe.getPlz(),
                nutzereingabe.getFahrzeugtyp(),
                nutzereingabe.getKilometerleistung()
        );

        // 4 - Save Versicherungspraemie
        Versicherungspraemie versicherungspraemie = new Versicherungspraemie();
        versicherungspraemie.setAntragssteller(antragssteller);
        versicherungspraemie.setNutzereingabe(nutzereingabe);
        versicherungspraemie.setPraemie(praemie);
        versicherungspraemieRepository.save(versicherungspraemie);

        System.out.println("RESPONSE: " + praemie);
        // sends praemie back to the frontend inside response body as raw data
        return new ResponseEntity<>(praemie, HttpStatus.OK);
    }
}
