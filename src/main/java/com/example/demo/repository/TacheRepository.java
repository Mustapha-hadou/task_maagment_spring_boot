package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.ProjetEntity;
import com.example.demo.entities.TacheEntity;
import com.example.demo.entities.UserEntity;

@Repository
public interface TacheRepository  extends  CrudRepository<TacheEntity, Long> {
	
	List<TacheEntity>  findByEmployee(UserEntity user); 
		
	List<TacheEntity> findByProjet(ProjetEntity Projet);
	List<TacheEntity> findAll();
	List<TacheEntity> findByStatus(String status);
	TacheEntity findByTacheId(String tache_id);

	

}
