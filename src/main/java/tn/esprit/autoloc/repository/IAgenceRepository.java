package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.domain.Agence;

// JpaRepository<Agence, Long>
//   → Agence  : le type de l'entité
//   → Long    : le type de la clé primaire (idAgence)
//
// Spring génère automatiquement toutes les méthodes CRUD :
// save(), findById(), findAll(), deleteById(), count()...
// PAS BESOIN D'ÉCRIRE UNE SEULE LIGNE D'IMPLÉMENTATION !
public interface IAgenceRepository extends JpaRepository<Agence, Long> {
}
