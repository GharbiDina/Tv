package tn.esprit.examen.DinaGharbi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.DinaGharbi.entities.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {
}