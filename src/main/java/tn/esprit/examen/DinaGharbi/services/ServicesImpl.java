package tn.esprit.examen.DinaGharbi.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examen.DinaGharbi.entities.*;
import tn.esprit.examen.DinaGharbi.repositories.IClientRepository;
import tn.esprit.examen.DinaGharbi.repositories.ProgrammeRepo;
import tn.esprit.examen.DinaGharbi.repositories.UtilisateurRepo;

@Slf4j
@RequiredArgsConstructor
@Service
public class ServicesImpl implements IServices {

    private final IClientRepository clientRepository;
    @Autowired
    UtilisateurRepo utilisateurRepo;
    @Autowired
    ProgrammeRepo programmeRepo;
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
}
