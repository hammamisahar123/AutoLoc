package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.domain.Client;

// JpaRepository<Client, Long>
//   → Client : le type de l'entité
//   → Long   : le type de la clé primaire (idClient)
public interface IClientRepository extends JpaRepository<Client, Long> {
}
