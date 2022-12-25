package com.example.kaddemproject.Models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Etudiant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int idEtudiant;

    private String prenomE;

    private String nomE;

    @Enumerated(EnumType.STRING)
    private Option option;

    @OneToMany(cascade = CascadeType.ALL,mappedBy="etudiant")
    private Set<Contrat> contrats;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy="etudiants")
    private Set<Equipe> equipes;

    @ManyToOne
    private Departement departement;



}
