package tn.esprit.examen.DinaGharbi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.examen.DinaGharbi.entities.Programme;
import tn.esprit.examen.DinaGharbi.entities.Utilisateur;

@Repository
public interface UtilisateurRepo extends JpaRepository<Utilisateur,Long> {
    //@Query("SELECT c FROM Programme c WHERE c.prgName= ?1")
    Utilisateur findUtilisateurByUsrNom(String usrNom);
}
