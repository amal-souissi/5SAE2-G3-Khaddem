package tn.esprit.spring.khaddem.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEtudiant;
    private String prenomE;
    private String nomE;
    private int age;
    @Enumerated(EnumType.STRING)
    private  Option op;

    @ManyToOne
    @JsonIgnore
    private Departement departement;
    @ManyToMany
    @JsonIgnore
    private List<Equipe> equipes;
    @OneToMany(mappedBy = "etudiant")
    @JsonIgnore
    private List<Contrat> contrats;



}
