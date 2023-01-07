package com.example.kaddemproject.Services;


import com.example.kaddemproject.Models.Departement;
import com.example.kaddemproject.Repositories.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementService {


    @Autowired
    public DepartementRepository depRep;

    List<Departement> retrieveAllDepartements(){
        return depRep.findAll();
    }

    Departement addDepartement(Departement d){
        return depRep.save(d);
    }

    Departement updateDepartement(Departement d){
        Optional<Departement> DepartementCheck = depRep.findById(d.getIdDepart());
        if(DepartementCheck != null){
            return depRep.save(d);
        }
        else
            return null;
    }

    Departement retrieveDepartement(Integer idDepartment){
        Optional<Departement> Departement = depRep.findById(idDepartment);
        if(Departement != null)
            return Departement.get();
        else
            return null;
    }

    void removeDepartement(Integer idDepartment){
        depRep.delete(depRep.findById(idDepartment).get());
    }

}
