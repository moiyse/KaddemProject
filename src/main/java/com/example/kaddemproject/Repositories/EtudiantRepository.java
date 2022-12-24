package com.example.kaddemproject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.kaddemproject.Models.Etudiant;
import com.example.kaddemproject.Models.Universite;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {
}
