package com.example.kaddemproject.Controllers;

import com.example.kaddemproject.Models.Contrat;
import com.example.kaddemproject.Models.Equipe;
import com.example.kaddemproject.Models.Etudiant;
import com.example.kaddemproject.Services.ContratService;
import com.example.kaddemproject.Services.EquipeService;
import com.example.kaddemproject.Services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {

    @Autowired
    EtudiantService etuService;

    @GetMapping("/list")
    public List<Etudiant> listEtudiant(){
        return etuService.retrieveAllEtudiants();
    }

    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant etu){
        return etuService.addEtudiant(etu);
    }

    @PutMapping("/edit")
    public Etudiant editEtudiant(@RequestBody Etudiant etu){
        return etuService.addEtudiant(etu);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEtudiant(@PathVariable("id") Integer id){
        etuService.removeEtudiant(id);
    }

    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable("id") Integer id) {
        return etuService.retrieveEtudiant(id);
    }

    @PostMapping("/etudiantToEquipeAndContrat/{idContrat}/{idEquipe}")
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,@PathVariable("idContrat") Integer idContrat,@PathVariable Integer idEquipe){
        return etuService.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);
    }
}
