package com.example.kaddemproject.Controllers;

import com.example.kaddemproject.Models.Contrat;
import com.example.kaddemproject.Services.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contrat")
public class ContratController {

    @Autowired
    ContratService contratService;

    @GetMapping("/list")
    public List<Contrat> listContrats(){
        return contratService.retrieveAllContrat();
    }

    @PostMapping("/add")
    public Contrat addContrat(@RequestBody Contrat contrat){
        return contratService.addContrat(contrat);
    }

    @PutMapping("/edit")
    public Contrat editContrat(@RequestBody Contrat contrat){
        return contratService.addContrat(contrat);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteContrat(@PathVariable("id") Integer id){
        contratService.removeContrat(id);
    }

    @GetMapping("/{id}")
    public Contrat getContratById(@PathVariable("id") Integer id){
        return contratService.retrieveContrat(id);
    }


}
