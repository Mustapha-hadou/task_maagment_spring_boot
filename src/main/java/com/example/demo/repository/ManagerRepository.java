
package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.UserEntity;


@Repository
public interface ManagerRepository extends CrudRepository<UserEntity, Long>{

	UserEntity findByEmail(String email);
}
