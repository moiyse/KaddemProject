package com.example.kaddemproject.Controllers;

import com.example.kaddemproject.Models.Contrat;
import com.example.kaddemproject.Models.Universite;
import com.example.kaddemproject.Services.ContratService;
import com.example.kaddemproject.Services.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {

    @Autowired
    UniversiteService universiteService;

    @GetMapping("/list")
    public List<Universite> listUniversite(){
        return universiteService.retrieveAllUniversite();
    }

    @PostMapping("/add")
    public Universite addUniversite(@RequestBody Universite univ){
        return universiteService.addUniversite(univ);
    }

    @PutMapping("/edit")
    public Universite editUniversite(@RequestBody Universite univ){
        return universiteService.addUniversite(univ);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUniversite(@PathVariable("id") Integer id){
        universiteService.removeUniversite(id);
    }

    @GetMapping("/{id}")
    public Universite getUniversiteById(@PathVariable("id") Integer id) {
        return universiteService.retrieveUniversite(id);
    }
}
