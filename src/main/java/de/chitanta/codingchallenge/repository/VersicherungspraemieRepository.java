package de.chitanta.codingchallenge.repository;

import de.chitanta.codingchallenge.entity.Versicherungspraemie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersicherungspraemieRepository extends JpaRepository<Versicherungspraemie, Long> {
}
