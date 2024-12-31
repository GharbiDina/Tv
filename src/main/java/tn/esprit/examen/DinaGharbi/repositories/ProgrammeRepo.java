package tn.esprit.examen.DinaGharbi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.examen.DinaGharbi.entities.Programme;

@Repository
public interface ProgrammeRepo extends JpaRepository<Programme,Long> {
    @Query("SELECT c FROM Programme c WHERE c.prgName= ?1")
    Programme findProgrammesByPrgName(String prgName);

}
