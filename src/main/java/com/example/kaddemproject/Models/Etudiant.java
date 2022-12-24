package com.example.kaddemproject.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Etudiant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int idEtudiant;

    private String prenomE;

    private String nomE;

    private Option option;

    @OneToMany(cascade = CascadeType.ALL,mappedBy="etudiant")
    private Set<Contrat> contrats;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy="etudiants")
    private Set<Equipe> equipes;

    @ManyToOne
    private Departement departement;



}
