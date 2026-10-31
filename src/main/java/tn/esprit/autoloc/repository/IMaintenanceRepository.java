package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.domain.Maintenance;

// JpaRepository<Maintenance, Long>
//   → Maintenance : le type de l'entité
//   → Long        : le type de la clé primaire (idMaintenance)
public interface IMaintenanceRepository extends JpaRepository<Maintenance, Long> {
}
