package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "maintenance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaintenance;

    @Column(nullable = false)
    private LocalDate dateDebut;

    private LocalDate dateFin;

    @Column(length = 500)
    private String description;

    // =============================================
    // ASSOCIATION : Maintenance → Vehicule (UNIDIRECTIONNEL)
    // =============================================
    // N maintenances concernent 1 véhicule
    // → @ManyToOne : Maintenance porte la colonne vehicule_id en base
    // → fetch LAZY : on ne charge le véhicule que si on en a besoin
    // → cascade PERSIST : si on crée une maintenance avec un nouveau véhicule,
    //   le véhicule est aussi sauvegardé
    //   PAS de cascade REMOVE : supprimer une maintenance ne supprime PAS le véhicule
    // → nullable = false : une maintenance DOIT concerner un véhicule
    //
    // ⚠️ UNIDIRECTIONNEL : Vehicule ne connaît PAS ses maintenances
    //   → On part toujours de Maintenance pour trouver son Vehicule
    //   → PAS de mappedBy (unidirectionnel)
    //   → PAS de List<Maintenance> dans Vehicule.java
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false)
    private Vehicule vehicule;
}
