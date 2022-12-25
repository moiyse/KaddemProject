package com.example.kaddemproject.Services;

import com.example.kaddemproject.Models.Departement;
import com.example.kaddemproject.Models.Etudiant;
import com.example.kaddemproject.Repositories.DepartementRepository;
import com.example.kaddemproject.Repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DepartementService {

    @Autowired
    private DepartementRepository depRepo;

    @Autowired
    private EtudiantRepository etuRepo;



    public List<Departement> retrieveAllDepartement(){
        return depRepo.findAll();
    }


    public Departement addDepartement(Departement e){
        return depRepo.save(e);
    }


    public Departement updateDepartement(Departement e){
        Optional<Departement> etudiantCheck = depRepo.findById(e.getIdDepart());
        if(etudiantCheck != null){
            return depRepo.save(e);
        }
        else
            return null;
    }

    public Departement retrieveDepartement(Integer idDepartement){
        Optional<Departement> departement = depRepo.findById(idDepartement);
        if(departement != null)
            return departement.get();
        else
            return null;
    }

    public void removeDepartement(Integer idDepartement){
        depRepo.delete(depRepo.findById(idDepartement).get());
    }



}
