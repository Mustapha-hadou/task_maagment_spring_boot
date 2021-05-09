
package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.ManagerEntity;


@Repository
public interface ManagerRepository extends CrudRepository<ManagerEntity, Long>{

	ManagerEntity findByEmail(String email);
}
