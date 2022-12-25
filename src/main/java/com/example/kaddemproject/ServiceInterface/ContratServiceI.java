package com.example.kaddemproject.ServiceInterface;

import com.example.kaddemproject.Models.Contrat;
import com.example.kaddemproject.Models.Etudiant;

import java.util.List;

public interface ContratServiceI {

    List<Contrat> retrieveAllContrat();

    Contrat addContrat(Contrat c);

    Contrat updateContrat(Contrat c);

    Contrat retrieveContrat(Integer idContrat);

    void removeContrat(Integer idContrat);

}
