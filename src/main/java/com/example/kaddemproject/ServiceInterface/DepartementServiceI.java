package com.example.kaddemproject.ServiceInterface;

import com.example.kaddemproject.Models.Departement;
import com.example.kaddemproject.Models.Etudiant;

import java.util.List;

public interface DepartementServiceI {

    List<Departement> retrieveAllDepartement();

    Departement addDepartement(Departement d);

    Departement updateDepartement(Departement d);

    Departement retrieveDepartement(Integer idDepartement);

    void removeDepartement(Integer idDepartement);


}
