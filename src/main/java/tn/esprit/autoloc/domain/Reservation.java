package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    @Column(nullable = false)
    private LocalDate dateDebut;

    @Column(nullable = false)
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatutReservation statut;

    // =============================================
    // ASSOCIATION 1 : Reservation → Client
    // =============================================
    // N réservations appartiennent à 1 client
    // → @ManyToOne : Reservation porte la colonne client_id en base
    // → fetch LAZY : on ne charge le client que si on en a besoin
    // → nullable = false : une réservation DOIT avoir un client
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Client client;

    // =============================================
    // ASSOCIATION 2 : Reservation → Vehicule
    // =============================================
    // N réservations concernent 1 véhicule
    // → @ManyToOne : Reservation porte la colonne vehicule_id en base
    // → fetch LAZY
    // → nullable = false : une réservation DOIT concerner un véhicule
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Vehicule vehicule;

    // =============================================
    // ASSOCIATION 3 : Reservation → Agence
    // =============================================
    // N réservations sont faites dans 1 agence
    // → @ManyToOne : Reservation porte la colonne agence_id en base
    // → fetch LAZY
    @ManyToOne(fetch = FetchType.LAZY)
    private Agence agence;
}
