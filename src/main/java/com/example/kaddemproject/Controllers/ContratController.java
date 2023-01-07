package com.example.kaddemproject.Controllers;

import com.example.kaddemproject.Models.Contrat;
import com.example.kaddemproject.Services.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/contrat")
@RestController
public class ContratController {

    @Autowired
    ContratService contratService;

    @GetMapping("/all")
    public List<Contrat> getAllContrat(){
        return contratService.retrieveAllContrats();
    }

    @GetMapping("/get/{id}")
    public Contrat getContrat(@RequestParam("id") int id){
        return contratService.retrieveContrat(id);
    }

    @PostMapping("/add")
    public Contrat addContrat(@RequestBody Contrat c){
        System.out.println("the contract in add"+c);
        return contratService.addContrat(c);
    }

    @PutMapping("/update")
    public Contrat updateContrat(@RequestBody Contrat c){
        return contratService.updateContrat(c);
    }

    @DeleteMapping("/delete/{id}")
    public void removeContrat(@RequestParam("id") int id){
        contratService.removeContrat(id);
    }

}
