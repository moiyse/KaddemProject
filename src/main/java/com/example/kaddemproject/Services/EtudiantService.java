package com.example.kaddemproject.Services;


import com.example.kaddemproject.Models.Contrat;
import com.example.kaddemproject.Models.Departement;
import com.example.kaddemproject.Models.Equipe;
import com.example.kaddemproject.Repositories.ContratRepository;
import com.example.kaddemproject.Repositories.DepartementRepository;
import com.example.kaddemproject.Repositories.EquipeRepository;
import com.example.kaddemproject.ServiceInterface.EtudiantServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.kaddemproject.Models.Etudiant;
import com.example.kaddemproject.Repositories.EtudiantRepository;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EtudiantService implements EtudiantServiceI {

    @Autowired
    private EtudiantRepository etuRepo;
    @Autowired
    private DepartementRepository depRepo;
    @Autowired
    private ContratRepository contratRepo;
    @Autowired
    private EquipeRepository equipeRepo;


    @Override
    public List<Etudiant> retrieveAllEtudiants(){
        return etuRepo.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e){
        return etuRepo.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e){
        Optional<Etudiant> etudiantCheck = etuRepo.findById(e.getIdEtudiant());
        if(etudiantCheck != null){
            return etuRepo.save(e);
        }
        else
            return null;
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant){
        Optional<Etudiant> etudiant = etuRepo.findById(idEtudiant);
        if(etudiant != null)
            return etudiant.get();
        else
            return null;
    }

    @Override
    public void removeEtudiant(Integer idEtudiant){
            etuRepo.delete(etuRepo.findById(idEtudiant).get());
    }

    public void assignEtudiantToDepartement(Integer etudiantId,Integer departementId){
        Etudiant etudiant = etuRepo.findById(etudiantId).get();
        Departement departement = depRepo.findById(departementId).get();

        etudiant.setDepartement(departement);
        etuRepo.save(etudiant);
    }

    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e,Integer idContrat,Integer idEquipe){
        Set<Contrat> contrats = new HashSet<>();
        Set<Equipe> equipes = new HashSet<>();
        Contrat contrat = contratRepo.findById(idContrat).get();
        Equipe equipe = equipeRepo.findById(idEquipe).get();

        Integer idEtu = etuRepo.save(e).getIdEtudiant();
        Etudiant etudiant = etuRepo.findById(idEtu).get();
        contrats.add(contrat);
        equipes.add(equipe);
        System.out.println("From the service function"+etudiant);
        etudiant.setContrats(contrats);
        etudiant.setEquipes(equipes);
        System.out.println("From the service function"+etudiant);

        return etuRepo.save(etudiant);
    }

}
