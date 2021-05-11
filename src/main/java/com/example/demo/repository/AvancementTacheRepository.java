package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.AvancementTacheEntity;
import com.example.demo.entities.TacheEntity;

@Repository
public interface AvancementTacheRepository extends CrudRepository<AvancementTacheEntity, Long> {
	
	List<AvancementTacheEntity> findByTache(TacheEntity tacheEntity);
   
	

}