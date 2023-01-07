package com.example.kaddemproject.Services;

import com.example.kaddemproject.Models.Universite;
import com.example.kaddemproject.Repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversiteService {

    @Autowired
    public UniversityRepository UniversiteRep;

    List<Universite> retrieveAllUniversites(){
        return UniversiteRep.findAll();
    }

    Universite addUniversite(Universite u){
        return UniversiteRep.save(u);
    }

    Universite updateUniversite(Universite u){
        Optional<Universite> UniversiteCheck = UniversiteRep.findById(u.getIdUniv());
        if(UniversiteCheck != null){
            return UniversiteRep.save(u);
        }
        else
            return null;
    }

    Universite retrieveUniversite(Integer idUniversite){
        Optional<Universite> Universite = UniversiteRep.findById(idUniversite);
        if(Universite != null)
            return Universite.get();
        else
            return null;
    }

    void removeUniversite(Integer idUniversite){
        UniversiteRep.delete(UniversiteRep.findById(idUniversite).get());
    }
}
