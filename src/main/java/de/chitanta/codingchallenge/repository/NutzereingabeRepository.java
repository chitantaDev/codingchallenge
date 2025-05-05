package de.chitanta.codingchallenge.repository;

import de.chitanta.codingchallenge.entity.Nutzereingabe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutzereingabeRepository extends JpaRepository<Nutzereingabe, Long> {
}
