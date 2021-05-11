package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.ProjetEntity;
import com.example.demo.entities.UserEntity;

@Repository
public interface ProjetRepository extends CrudRepository<ProjetEntity,Long>{
	
	ProjetEntity findByProjetId(String projetId);
	List<ProjetEntity> findByManager(UserEntity managerId);
	List<ProjetEntity> findByAdmin(UserEntity adminId);
}
