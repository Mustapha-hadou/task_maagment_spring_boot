package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Avancemen_ProjettEntity;
import com.example.demo.entities.ProjetEntity;

@Repository
public interface AvancementProjetRepository extends CrudRepository<Avancemen_ProjettEntity, Long> {
	
	List<Avancemen_ProjettEntity> findByProjet(ProjetEntity tacheEntity);
   
	

}