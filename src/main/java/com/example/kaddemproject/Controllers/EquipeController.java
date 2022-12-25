package com.example.kaddemproject.Controllers;

import com.example.kaddemproject.Models.Contrat;
import com.example.kaddemproject.Models.Equipe;
import com.example.kaddemproject.Services.ContratService;
import com.example.kaddemproject.Services.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipe")
public class EquipeController {

    @Autowired
    EquipeService equipeService;

    @GetMapping("/list")
    public List<Equipe> listEquipe(){
        return equipeService.retrieveAllEquipe();
    }

    @PostMapping("/add")
    public Equipe addEquipe(@RequestBody Equipe equipe){
        return equipeService.addEquipe(equipe);
    }

    @PutMapping("/edit")
    public Equipe editEquipe(@RequestBody Equipe equipe){
        return equipeService.addEquipe(equipe);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEquipe(@PathVariable("id") Integer id){
        equipeService.removeEquipe(id);
    }

    @GetMapping("/{id}")
    public Equipe getEquipeById(@PathVariable("id") Integer id) {
        return equipeService.retrieveEquipe(id);
    }
}
