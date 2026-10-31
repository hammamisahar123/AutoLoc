package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.domain.Vehicule;

// JpaRepository<Vehicule, Long>
//   → Vehicule : le type de l'entité
//   → Long     : le type de la clé primaire (idVehicule)
public interface IVehiculeRepository extends JpaRepository<Vehicule, Long> {
}
