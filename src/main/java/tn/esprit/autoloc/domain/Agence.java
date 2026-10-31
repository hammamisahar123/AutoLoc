package tn.esprit.autoloc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agence")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;

    // ✅ CORRECTION : String au lieu de long
    @Column(nullable = false, length = 100)
    private String nom;

    // ✅ CORRECTION : 'prenom' n'a pas de sens pour une agence → remplacé par 'ville'
    @Column(nullable = false, length = 50)
    private String ville;

    @Column(nullable = false, length = 200)
    private String adresse;

    @Column(nullable = false, length = 20)
    private String telephone;

    // =============================================
    // ASSOCIATION 1 : Agence → Vehicules
    // =============================================
    // Une agence possède plusieurs véhicules (1 → N)
    // → @OneToMany car 1 agence a N véhicules
    // → mappedBy = "agence" : c'est VEHICULE qui porte la clé étrangère (agence_id)
    //   donc AGENCE est le côté INVERSE → elle reçoit mappedBy
    // → fetch LAZY : on ne charge les véhicules que si on en a besoin
    // → cascade PERSIST, MERGE : sauvegarder/modifier l'agence peut affecter ses véhicules
    //   mais PAS cascade REMOVE : supprimer une agence ne supprime PAS ses véhicules
    // → @JsonIgnore : évite la boucle infinie JSON (Agence→Vehicule→Agence→...)
    @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY,
               cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private List<Vehicule> vehicules = new ArrayList<>();

    // =============================================
    // ASSOCIATION 2 : Agence → Employes
    // =============================================
    // Une agence emploie plusieurs employés (1 → N)
    // → même logique que Agence → Vehicules
    // → mappedBy = "agence" : EMPLOYE porte la clé étrangère
    // → cascade PERSIST, MERGE : pas de suppression en cascade
    @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY,
               cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private List<Employe> employes = new ArrayList<>();
}
