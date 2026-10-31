package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.domain.Paiement;

// JpaRepository<Paiement, Long>
//   → Paiement : le type de l'entité
//   → Long     : le type de la clé primaire (idPaiement)
public interface IPaiementRepository extends JpaRepository<Paiement, Long> {
}
