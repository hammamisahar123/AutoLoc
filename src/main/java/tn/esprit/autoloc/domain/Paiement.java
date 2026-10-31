package tn.esprit.autoloc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "paiement")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaiement;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal montant;

    @Column(nullable = false)
    private LocalDate datePaiement;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ModePaiement modePaiement;

    // =============================================
    // ASSOCIATION : Paiement → Contrat (côté propriétaire)
    // =============================================
    // N paiements appartiennent à 1 contrat
    // → @ManyToOne : Paiement est le côté PROPRIÉTAIRE
    //   (Paiement porte la colonne contrat_id en base)
    // → fetch LAZY : forcer LAZY car le défaut de @ManyToOne est EAGER
    // → nullable = false : un paiement DOIT appartenir à un contrat
    // → @JsonBackReference : côté "enfant" pour éviter la boucle infinie JSON
    //   doit avoir le MÊME nom que @JsonManagedReference dans Contrat.java
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    @JsonBackReference("contrat-paiements")
    private Contrat contrat;
}
