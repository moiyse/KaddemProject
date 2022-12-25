package com.example.kaddemproject.Services;

import com.example.kaddemproject.Models.Equipe;
import com.example.kaddemproject.Models.Etudiant;
import com.example.kaddemproject.Repositories.EquipeRepository;
import com.example.kaddemproject.Repositories.EtudiantRepository;
import com.example.kaddemproject.ServiceInterface.EquipeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipeService implements EquipeServiceI {

    @Autowired
    private EquipeRepository equipeRepo;


    @Override
    public List<Equipe> retrieveAllEquipe(){
        return equipeRepo.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe e){
        return equipeRepo.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e){
        Optional<Equipe> equipeCheck = equipeRepo.findById(e.getIdEquipe());
        if(equipeCheck != null){
            return equipeRepo.save(e);
        }
        else
            return null;
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe){
        Optional<Equipe> equipe = equipeRepo.findById(idEquipe);
        if(equipe != null)
            return equipe.get();
        else
            return null;
    }

    @Override
    public void removeEquipe(Integer idEquipe){
        equipeRepo.delete(equipeRepo.findById(idEquipe).get());
    }
}
