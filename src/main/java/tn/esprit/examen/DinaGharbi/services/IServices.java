package tn.esprit.examen.DinaGharbi.services;

import tn.esprit.examen.DinaGharbi.entities.*;

import java.util.Date;
import java.util.List;

public interface IServices {
    Client add(Client client);
    public Utilisateur ajouterUtilisateur (Utilisateur u);
    public Programme ajouterProgrammeEtChaine (Programme p);
    public Programme ceeretAffecterProg(Programme prg, Long chId);
    public void affecterProgrammeAUtilisateur (String prNom, String usrNom);
    public List<Utilisateur> recupererUtilisateurs(Profession p, Date d, Thematique t);

    public void desaffecterProgrammeDeUtilisateur (String prNom, String usrNom);
    void test();
}
