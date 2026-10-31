package tn.esprit.autoloc.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contrat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    @Column(nullable = false)
    private LocalDate dateSignature;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal montantTotal;

    private boolean valide;

    // =============================================
    // ASSOCIATION 1 : Contrat → Reservation (OneToOne)
    // =============================================
    // 1 contrat est lié à 1 seule réservation
    // → @OneToOne : relation un à un
    // → cascade ALL : si on crée/supprime le contrat, la réservation suit
    // → fetch LAZY : on ne charge la réservation que si on en a besoin
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id", nullable = false)
    private Reservation reservation;

    // =============================================
    // ASSOCIATION 2 : Contrat → Paiements (composition forte)
    // =============================================
    // 1 contrat a plusieurs paiements (acompte, solde, pénalités...)
    // → @OneToMany : 1 contrat → N paiements
    // → mappedBy = "contrat" : PAIEMENT porte la clé étrangère (contrat_id)
    //   donc CONTRAT est le côté INVERSE → il reçoit mappedBy
    // → cascade ALL : un paiement ne peut pas exister sans son contrat
    //   → si on crée un contrat avec des paiements, les paiements sont créés
    //   → si on supprime un contrat, TOUS ses paiements sont supprimés
    // → orphanRemoval = true : si on retire un paiement de la liste,
    //   il est automatiquement supprimé en base (plus d'orphelin)
    // → fetch LAZY : on ne charge les paiements que si on en a besoin
    // → @JsonManagedReference : côté "parent" pour éviter la boucle infinie JSON
    //   Contrat → Paiement → Contrat → Paiement → ...
    @OneToMany(mappedBy = "contrat",
               cascade = CascadeType.ALL,
               orphanRemoval = true,
               fetch = FetchType.LAZY)
    @JsonManagedReference("contrat-paiements")
    private List<Paiement> paiements = new ArrayList<>();
}
