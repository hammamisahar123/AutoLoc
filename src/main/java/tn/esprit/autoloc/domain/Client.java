package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;


    @Column(nullable = false, length = 50)
    private String nom;

    @Column(nullable = false, length = 50)
    private String prenom;

    // email unique : un client = un seul email
    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(length = 20)
    private String telephone;

    // numPermis unique : un permis appartient à un seul client
    @Column(unique = true, nullable = false, length = 30)
    private String numPermis;

    @Column(nullable = false)
    private LocalDate dateInscription;
}
