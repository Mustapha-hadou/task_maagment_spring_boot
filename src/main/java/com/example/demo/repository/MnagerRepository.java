package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.AdminEntity;
import com.example.demo.entities.EmployeEntity;
import com.example.demo.entities.ManagerEntity;
import com.example.demo.entities.UserEntity;

@Repository
public interface MnagerRepository extends  CrudRepository<ManagerEntity, Long> {

	List<UserEntity> findByAdmin(AdminEntity admin);

}

