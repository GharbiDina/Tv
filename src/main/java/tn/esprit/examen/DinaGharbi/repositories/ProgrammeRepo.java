package tn.esprit.examen.DinaGharbi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.examen.DinaGharbi.entities.Programme;

@Repository
public interface ProgrammeRepo extends JpaRepository<Programme,Long> {
}
