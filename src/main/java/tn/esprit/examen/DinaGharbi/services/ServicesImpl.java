package tn.esprit.examen.DinaGharbi.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examen.DinaGharbi.entities.*;
import tn.esprit.examen.DinaGharbi.repositories.ChaineRepo;
import tn.esprit.examen.DinaGharbi.repositories.IClientRepository;
import tn.esprit.examen.DinaGharbi.repositories.ProgrammeRepo;
import tn.esprit.examen.DinaGharbi.repositories.UtilisateurRepo;

import java.util.Date;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ServicesImpl implements IServices {

    private final IClientRepository clientRepository;
    @Autowired
    UtilisateurRepo utilisateurRepo;
    @Autowired
    ProgrammeRepo programmeRepo;
    @Autowired
    ChaineRepo chaineRepo;
    @Override
    public Client add(Client client) {
        return clientRepository.save(client);
    }

   @Scheduled(cron = "*/15 * * * * *")
    @Override
    public void test() {
        log.info("testing");
    }

    public  Utilisateur ajouterUtilisateur (Utilisateur u)
    {
        return utilisateurRepo.save(u);
    }
    public Programme ajouterProgrammeEtChaine (Programme p)
    {
        return programmeRepo.save(p);
    }
    public Programme ceeretAffecterProg(Programme prg, Long chId) {
        // Vérifier si la classe existe
        Chaine chaine = chaineRepo.findById(chId).orElse(null);
        if (chaine == null) {
            throw new RuntimeException("La classe avec le code " + chId + " n'existe pas dans la base de données.");
        }

        // Affecter la classe à l'utilisateur
        prg.setChaine(chaine);

        // Sauvegarder l'utilisateur
        return programmeRepo.save(prg);
    }
    public void affecterProgrammeAUtilisateur (String prNom, String usrNom)
    {
        Programme  prg = programmeRepo.findProgrammesByPrgName(prNom);
        Utilisateur utilisateur = utilisateurRepo.findUtilisateurByUsrNom(usrNom);
// on set le fils dans le parent :
        utilisateur.getProgrammes().add(prg);
        utilisateurRepo.save(utilisateur);

    }
  /*  public List<Utilisateur> recupererUtilisateurs(Profession p, Date d, Thematique t)
    {

    }*/
  public void desaffecterProgrammeDeUtilisateur(String prNom, String usrNom) {
      // Rechercher le programme par son nom
      Programme programme = programmeRepo.findProgrammesByPrgName(prNom);
      if (programme == null) {
          throw new RuntimeException("Programme avec le nom " + prNom + " n'existe pas.");
      }

      // Rechercher l'utilisateur par son nom
      Utilisateur utilisateur = utilisateurRepo.findUtilisateurByUsrNom(usrNom);
      if (utilisateur == null) {
          throw new RuntimeException("Utilisateur avec le nom " + usrNom + " n'existe pas.");
      }

      // Supprimer le programme de la liste des programmes de l'utilisateur
      if (utilisateur.getProgrammes().remove(programme)) {
          utilisateurRepo.save(utilisateur);
      } else {
          throw new RuntimeException("Le programme " + prNom + " n'est pas dans la liste des favoris de l'utilisateur " + usrNom + ".");
      }
  }


}
