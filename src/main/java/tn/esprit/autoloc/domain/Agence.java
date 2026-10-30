package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "agence")
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAgence;
    @Column(nullable = false,unique = true,length = 20)
    private long nom;
    @Column(nullable = false,unique = true,length = 20)
    private long prenom;
    @Column(nullable = false,unique = true,length = 20)
    private long adresse;
    @Column(nullable = false,unique = true, length = 20)
    private long telephone;
}
