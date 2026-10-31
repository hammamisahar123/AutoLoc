package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.domain.Employe;

// JpaRepository<Employe, Long>
//   → Employe : le type de l'entité
//   → Long    : le type de la clé primaire (idEmploye)
public interface IEmployeRepository extends JpaRepository<Employe, Long> {
}
