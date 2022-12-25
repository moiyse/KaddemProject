package com.example.kaddemproject.Controllers;

import com.example.kaddemproject.Models.Contrat;
import com.example.kaddemproject.Models.Departement;
import com.example.kaddemproject.Services.ContratService;
import com.example.kaddemproject.Services.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departement")
public class DepartementController {

    @Autowired
    DepartementService departementService;

    @GetMapping("/list")
    public List<Departement> listDepartement(){
        return departementService.retrieveAllDepartement();
    }

    @PostMapping("/add")
    public Departement addContrat(@RequestBody Departement departement){
        return departementService.addDepartement(departement);
    }

    @PutMapping("/edit")
    public Departement editContrat(@RequestBody Departement departement){
        return departementService.addDepartement(departement);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartement(@PathVariable("id") Integer id){
        departementService.removeDepartement(id);
    }

    @GetMapping("/{id}")
    public Departement getContratById(@PathVariable("id") Integer id) {
        return departementService.retrieveDepartement(id);
    }
}
