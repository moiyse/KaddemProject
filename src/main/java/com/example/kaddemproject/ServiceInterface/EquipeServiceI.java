package com.example.kaddemproject.ServiceInterface;

import com.example.kaddemproject.Models.Equipe;
import com.example.kaddemproject.Models.Etudiant;

import java.util.List;

public interface EquipeServiceI {

    List<Equipe> retrieveAllEquipe();

    Equipe addEquipe(Equipe e);

    Equipe updateEquipe(Equipe e);

    Equipe retrieveEquipe(Integer idEquipe);

    void removeEquipe(Integer idEquipe);
}
