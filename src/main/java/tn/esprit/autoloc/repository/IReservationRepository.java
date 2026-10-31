package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.domain.Reservation;

// JpaRepository<Reservation, Long>
//   → Reservation : le type de l'entité
//   → Long        : le type de la clé primaire (idReservation)
public interface IReservationRepository extends JpaRepository<Reservation, Long> {
}
