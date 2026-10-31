package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmploye;

    @Column(nullable = false, length = 50)
    private String nom;

    @Column(nullable = false, length = 50)
    private String prenom;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private RoleEmploye role;

    // =============================================
    // ASSOCIATION : Employe → Agence (côté propriétaire)
    // =============================================
    // N employés travaillent dans 1 agence
    // → @ManyToOne : Employe est le côté PROPRIÉTAIRE (il porte la colonne agence_id)
    // → fetch LAZY : on ne charge l'agence que si on en a besoin
    // → PAS de mappedBy ici (mappedBy est dans Agence.java)
    @ManyToOne(fetch = FetchType.LAZY)
    private Agence agence;
}
