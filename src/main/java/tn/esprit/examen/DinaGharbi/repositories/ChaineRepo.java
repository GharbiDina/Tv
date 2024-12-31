package tn.esprit.examen.DinaGharbi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.examen.DinaGharbi.entities.Chaine;

import java.util.List;

@Repository
public interface ChaineRepo extends JpaRepository<Chaine,Long> {

    @Query("SELECT c, COUNT(p) FROM Chaine c " +
            "JOIN Programme p ON p.chaine = c " +
            "JOIN p.utilisateurs u " +
            "GROUP BY c " +
            "ORDER BY COUNT(p) DESC")
    List<Object[]> findChainesByProgrammesFavoris();


}
