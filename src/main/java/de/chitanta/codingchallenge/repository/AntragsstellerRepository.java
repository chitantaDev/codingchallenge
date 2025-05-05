package de.chitanta.codingchallenge.repository;

import de.chitanta.codingchallenge.entity.Antragssteller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AntragsstellerRepository extends JpaRepository<Antragssteller, Long> {
    Optional<Antragssteller> findByFirstnameAndLastname(String firstname, String lastname);

}
