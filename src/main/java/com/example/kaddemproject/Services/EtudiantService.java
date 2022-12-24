package com.example.kaddemproject.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.kaddemproject.Models.Etudiant;
import com.example.kaddemproject.Repositories.EtudiantRepository;


import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etuRepo;

    List<Etudiant> retrieveAllEtudiants(){
        return etuRepo.findAll();
    }

    Etudiant addEtudiant(Etudiant e){
        return etuRepo.save(e);
    }

    Etudiant updateEtudiant(Etudiant e){
        Optional<Etudiant> etudiantCheck = etuRepo.findById(e.getIdEtudiant());
        if(etudiantCheck != null){
            return etuRepo.save(e);
        }
        else
            return null;
    }

    Etudiant retrieveEtudiant(Integer idEtudiant){
        Optional<Etudiant> etudiant = etuRepo.findById(idEtudiant);
        if(etudiant != null)
            return etudiant.get();
        else
            return null;
    }

    void removeEtudiant(Integer idEtudiant){
            etuRepo.delete(etuRepo.findById(idEtudiant).get());
    }

}
