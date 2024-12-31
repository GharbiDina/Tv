package tn.esprit.examen.DinaGharbi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.DinaGharbi.entities.Client;
import tn.esprit.examen.DinaGharbi.entities.Programme;
import tn.esprit.examen.DinaGharbi.entities.Utilisateur;
import tn.esprit.examen.DinaGharbi.services.IServices;

@RequiredArgsConstructor
@RequestMapping("examen")
@RestController
public class ClientRestController {
    private final IServices services;

    @PostMapping("/add")
    public Client add(@RequestBody Client client){
        return  services.add(client);
    }
    @PostMapping("/add-Utilisateur")
    public Utilisateur addUtilisateur(@RequestBody Utilisateur c) {
        Utilisateur chambre = services.ajouterUtilisateur(c);
        return chambre;
    }

    @PostMapping("/ajouter-projet-et-projet-detail")
    public Programme ajouterProgrammeEtChaine(@RequestBody Programme p) {
        Programme programme = services.ajouterProgrammeEtChaine(p);
        return programme;
    }
    @PostMapping("/creer-et-affecter")
    public ResponseEntity<?> creerEtAffecterUtilisateur(
            @RequestBody Programme prg,
            @RequestParam Long chId) {
        try {
            // Appeler le service pour créer et affecter l'utilisateur
            Programme nouvPrg = services.ceeretAffecterProg(prg, chId);
            return ResponseEntity.ok(nouvPrg);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
