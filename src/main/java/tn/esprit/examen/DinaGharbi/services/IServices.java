package tn.esprit.examen.DinaGharbi.services;

import tn.esprit.examen.DinaGharbi.entities.Client;
import tn.esprit.examen.DinaGharbi.entities.Programme;
import tn.esprit.examen.DinaGharbi.entities.Utilisateur;

public interface IServices {
    Client add(Client client);
    public Utilisateur ajouterUtilisateur (Utilisateur u);
    public Programme ajouterProgrammeEtChaine (Programme p);
    public Programme ceeretAffecterProg(Programme prg, Long chId);
    void test();
}
