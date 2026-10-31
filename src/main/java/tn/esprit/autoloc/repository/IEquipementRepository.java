package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.domain.Equipement;

// JpaRepository<Equipement, Long>
//   → Equipement : le type de l'entité
//   → Long       : le type de la clé primaire (idEquipement)
public interface IEquipementRepository extends JpaRepository<Equipement, Long> {
}
