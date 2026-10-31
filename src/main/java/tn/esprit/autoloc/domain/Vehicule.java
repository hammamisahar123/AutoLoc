package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;

    @Column(nullable = false, unique = true, length = 20)
    private String immatriculation;

    @Column(nullable = false, length = 50)
    private String marque;

    @Column(nullable = false, length = 50)
    private String modele;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private CategorieVehicule categorie;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal tarifJournalier;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatutVehicule statut;

    // =============================================
    // ASSOCIATION 1 : Vehicule → Agence (côté propriétaire)
    // =============================================
    // N véhicules appartiennent à 1 agence
    // → @ManyToOne : côté PROPRIÉTAIRE (Vehicule porte la colonne agence_id en base)
    // → fetch LAZY : on ne charge l'agence que si on en a besoin
    // → PAS de mappedBy ici : mappedBy est TOUJOURS côté @OneToMany (dans Agence.java)
    @ManyToOne(fetch = FetchType.LAZY)
    private Agence agence;

    // =============================================
    // ASSOCIATION 2 : Vehicule ↔ Equipements (ManyToMany)
    // =============================================
    // Un véhicule peut avoir plusieurs équipements
    // ET un équipement peut équiper plusieurs véhicules
    // → @ManyToMany : relation N à N
    // → Vehicule est le côté PROPRIÉTAIRE (il porte la table de jointure)
    // → @JoinTable : crée la table intermédiaire "vehicule_equipement" en base
    // → fetch LAZY : on ne charge les équipements que si on en a besoin
    // → cascade PERSIST, MERGE seulement : supprimer un véhicule ne supprime PAS les équipements
    //   (un équipement GPS peut encore équiper d'autres véhicules)
    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "vehicule_equipement",
        joinColumns = @JoinColumn(name = "vehicule_id"),
        inverseJoinColumns = @JoinColumn(name = "equipement_id")
    )
    private List<Equipement> equipements = new ArrayList<>();
}
