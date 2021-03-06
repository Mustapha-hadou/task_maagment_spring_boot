package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.AdminEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.sherd.dto.UserDto;
@Repository
public interface UserRepository extends  CrudRepository<UserEntity, Long> {
	
	UserEntity findByEmail(String email);
	UserEntity findByUserId(String id);	

}
