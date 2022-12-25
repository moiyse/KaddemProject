package com.example.kaddemproject.ServiceInterface;

import com.example.kaddemproject.Models.Etudiant;

import java.util.List;

public interface EtudiantServiceI {



    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant(Etudiant e);

    Etudiant updateEtudiant(Etudiant e);

    Etudiant retrieveEtudiant(Integer idEtudiant);

    void removeEtudiant(Integer idEtudiant);

}
