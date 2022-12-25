package com.example.kaddemproject.Services;

import com.example.kaddemproject.Models.Departement;
import com.example.kaddemproject.Models.Universite;
import com.example.kaddemproject.Repositories.DepartementRepository;
import com.example.kaddemproject.Repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversiteService {
    @Autowired
    private UniversityRepository univRepo;



    public List<Universite> retrieveAllUniversite(){
        return univRepo.findAll();
    }


    public Universite addUniversite(Universite e){
        return univRepo.save(e);
    }


    public Universite updateUniversite(Universite e){
        Optional<Universite> etudiantCheck = univRepo.findById(e.getIdUniv());
        if(etudiantCheck != null){
            return univRepo.save(e);
        }
        else
            return null;
    }

    public Universite retrieveUniversite(Integer idUniversite){
        Optional<Universite> departement = univRepo.findById(idUniversite);
        if(departement != null)
            return departement.get();
        else
            return null;
    }


    public void removeUniversite(Integer idDepartement){
        univRepo.delete(univRepo.findById(idDepartement).get());
    }
}
