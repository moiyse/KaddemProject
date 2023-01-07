package com.example.kaddemproject.Services;

import com.example.kaddemproject.Models.Equipe;
import com.example.kaddemproject.Repositories.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipeService {

    @Autowired
    public EquipeRepository EquipeRep;

    List<Equipe> retrieveAllEquipes(){
        return EquipeRep.findAll();
    }

    Equipe addEquipe(Equipe e){
        return EquipeRep.save(e);
    }

    Equipe updateEquipe(Equipe e){
        Optional<Equipe> EquipeCheck = EquipeRep.findById(e.getIdEquipe());
        if(EquipeCheck != null){
            return EquipeRep.save(e);
        }
        else
            return null;
    }

    Equipe retrieveEquipe(Integer idEquipe){
        Optional<Equipe> Equipe = EquipeRep.findById(idEquipe);
        if(Equipe != null)
            return Equipe.get();
        else
            return null;
    }

    void removeEquipe(Integer idEquipe){
        EquipeRep.delete(EquipeRep.findById(idEquipe).get());
    }
}
