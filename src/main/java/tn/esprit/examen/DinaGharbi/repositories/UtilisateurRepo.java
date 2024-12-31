package tn.esprit.examen.DinaGharbi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.examen.DinaGharbi.entities.Profession;
import tn.esprit.examen.DinaGharbi.entities.Programme;
import tn.esprit.examen.DinaGharbi.entities.Thematique;
import tn.esprit.examen.DinaGharbi.entities.Utilisateur;

import java.util.Date;
import java.util.List;

@Repository
public interface UtilisateurRepo extends JpaRepository<Utilisateur,Long> {

    Utilisateur findUtilisateurByUsrNom(String usrNom);

    @Query("SELECT u FROM Utilisateur u " +
            "JOIN u.programmes p " +
            "JOIN p.chaine c " +
            "WHERE u.profession = :profession " +
            "AND u.usrDateInscription > :date " +
            "AND c.chThematique = :thematique")
    List<Utilisateur> findUtilisateursByCriteria(@Param("profession") Profession profession,
                                                 @Param("date") Date date,
                                                 @Param("thematique") Thematique thematique);


}
