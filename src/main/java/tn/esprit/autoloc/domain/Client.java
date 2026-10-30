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
    private long idClient;
@Column(nullable = false ,unique = true, length = 20)
    private long nom;
@Column(nullable = false ,unique = true , length = 20)
    private long prenom;
@Column(nullable = false,unique = true,length = 150)
  private long email;
    @Column(length = 20)
    private String telephone;

    @Column(unique = true, nullable = false, length = 30)
    private String numPermis;

    @Column(nullable = false)
    private LocalDate dateInscription;
}

