package com.example.kaddemproject.Services;

import com.example.kaddemproject.Models.Contrat;
import com.example.kaddemproject.Models.Universite;
import com.example.kaddemproject.Repositories.ContratRepository;
import com.example.kaddemproject.Repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratService {

    @Autowired
    private ContratRepository contRepo;



    public List<Contrat> retrieveAllContrat(){
        return contRepo.findAll();
    }


    public Contrat addContrat(Contrat e){
        return contRepo.save(e);
    }


    public Contrat updateContrat(Contrat e){
        Optional<Contrat> contratCheck = contRepo.findById(e.getIdContrat());
        if(contratCheck != null){
            return contRepo.save(e);
        }
        else
            return null;
    }

    public Contrat retrieveContrat(Integer idContrat){
        Optional<Contrat> contrat = contRepo.findById(idContrat);
        if(contrat != null)
            return contrat.get();
        else
            return null;
    }


    public void removeContrat(Integer idContrat){
        contRepo.delete(contRepo.findById(idContrat).get());
    }
}
