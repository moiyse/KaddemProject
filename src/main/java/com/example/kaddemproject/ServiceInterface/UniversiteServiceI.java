package com.example.kaddemproject.ServiceInterface;

import com.example.kaddemproject.Models.Etudiant;
import com.example.kaddemproject.Models.Universite;

import java.util.List;

public interface UniversiteServiceI {

    List<Universite> retrieveAllUniversite();

    Universite addUniversite(Universite e);

    Universite updateUniversite(Universite e);

    Universite retrieveUniversite(Integer idUniversite);

    void removeUniversite(Integer idUniversite);

}
