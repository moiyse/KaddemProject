package com.example.kaddemproject.Services;

import com.example.kaddemproject.Models.Contrat;
import com.example.kaddemproject.Models.Etudiant;
import com.example.kaddemproject.Repositories.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratService {


    @Autowired
    public ContratRepository contratRep;

    public List<Contrat> retrieveAllContrats(){
        return contratRep.findAll();
    }

    public Contrat addContrat(Contrat c){
        return contratRep.save(c);
    }

    public Contrat updateContrat(Contrat c){
        Optional<Contrat> etudiantCheck = contratRep.findById(c.getIdContrat());
        if(etudiantCheck != null){
            return contratRep.save(c);
        }
        else
            return null;
    }

    public Contrat retrieveContrat(Integer idContrat){
        Optional<Contrat> etudiant = contratRep.findById(idContrat);
        if(etudiant != null)
            return etudiant.get();
        else
            return null;
    }

    public void removeContrat(Integer idContrat){
        contratRep.delete(contratRep.findById(idContrat).get());
    }

}
