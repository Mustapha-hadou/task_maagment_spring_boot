package com.example.demo.services.Imp;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.demo.entities.AdminEntity;
import com.example.demo.entities.EmployeEntity;
import com.example.demo.entities.ManagerEntity;
import com.example.demo.entities.ProjetEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;
import com.example.demo.sherd.Utils;
import com.example.demo.sherd.dto.ProjetDto;
import com.example.demo.sherd.dto.UserDto;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
	UserRepository userRepository;
    
    @Autowired
    Utils util;
    
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
	@Override
	public void createUser(UserDto userDto,String email) {
        UserEntity checkuser =  userRepository.findByEmail(userDto.getEmail());
	    if(checkuser != null) throw new RuntimeException("cet utilisqteur existe deja dans la base de donnes");
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);
		userEntity.setEncryptepassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		userEntity.setUserId(util.generateStringId(32));
		if(userEntity.getRole().equals("ADMIN")) {	
			ModelMapper modelMapper=new ModelMapper();
			AdminEntity adminEntity = modelMapper.map(userEntity,AdminEntity.class);
			userRepository.save(adminEntity);
		}
		if(userEntity.getRole().equals("MANAGER")) {
			
			AdminEntity admin = (AdminEntity) userRepository.findByEmail(email);
			ModelMapper modelMapper=new ModelMapper();
			
	        UserDto adminDto = modelMapper.map(admin,UserDto.class);
			ManagerEntity managerEntity = modelMapper.map(userEntity,ManagerEntity.class);
			
			managerEntity.setAdmin(admin);
			userRepository.save(managerEntity);
		}
		if (userEntity.getRole().equals("EMPLOYEE")) {
			AdminEntity admin = (AdminEntity) userRepository.findByEmail(email);
			ModelMapper modelMapper=new ModelMapper();
			
	        UserDto adminDto = modelMapper.map(admin,UserDto.class);
			EmployeEntity employeEntity = modelMapper.map(userEntity,EmployeEntity.class);
			
			employeEntity.setAdmin(admin);
			userRepository.save(employeEntity);
		}
		
		
		 
		
		
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByEmail(email);
		if(userEntity == null) throw new UsernameNotFoundException(email);
		
		Collection<SimpleGrantedAuthority> roles=new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(userEntity.getRole()));
		return new User(userEntity.getEmail(),userEntity.getEncryptepassword(),roles);
	}

	@Override
	public UserDto getUser(String email) {
		UserEntity userEntity = userRepository.findByEmail(email);
		if(userEntity == null) throw new UsernameNotFoundException(email);
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userEntity, userDto);
		return userDto;
	}

	@Override
	public UserDto getUserByUserId(String userid) {
		UserEntity userEntity = userRepository.findByUserId(userid);
		if(userEntity == null) throw new UsernameNotFoundException(userid);
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userEntity, userDto);
		return userDto;
	}

	@Override
	public UserDto UpdateUser(String userid, UserDto userDto) {
		UserEntity userEntity = userRepository.findByUserId(userid);
		if(userEntity == null) throw new UsernameNotFoundException(userid);
		userEntity.setNom(userDto.getNom());
		userEntity.setPrenom(userDto.getPrenom());
		userEntity.setAge(userDto.getAge());
		userEntity.setEmail(userDto.getEmail());
		userEntity.setTelephone(userDto.getTelephone());
		
		UserEntity userUpdate = userRepository.save(userEntity);
		
		UserDto user = new UserDto();
		BeanUtils.copyProperties(userUpdate, user);
		return user;
	}

	@Override
	public void deleteUser(String userid) {
		UserEntity userEntity = userRepository.findByUserId(userid);
		if(userEntity == null) throw new UsernameNotFoundException(userid);
		
		userRepository.delete(userEntity);
		
	}

	@Override
	public void createUser(UserDto userDto) {
		UserEntity checkuser =  userRepository.findByEmail(userDto.getEmail());
	    if(checkuser != null) throw new RuntimeException("cet utilisqteur existe deja dans la base de donnes");
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);
		userEntity.setEncryptepassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		userEntity.setUserId(util.generateStringId(32));
		System.out.print("cretae ueser");
		if(userEntity.getRole().equals("ADMIN")) {	
			ModelMapper modelMapper=new ModelMapper();
			System.out.print("cretae admin");
			AdminEntity adminEntity = modelMapper.map(userEntity,AdminEntity.class);
			userRepository.save(adminEntity);
		}
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<UserEntity> users = (List<UserEntity>) userRepository.findAll();
		
		
		
		Type listeType = new TypeToken<List<UserDto>>() {}.getType();
		List<UserDto> usersDto = new ModelMapper().map(users,listeType);
		
		for(int i = 0 ; i < usersDto.size() ; i++) {
			if(usersDto.get(i).getRole().equals("ADMIN")) {
				usersDto.remove(i);
			}
		}
		
		return usersDto;
	}

	@Override
	public List<UserDto> getAllEmployees() {

		
        List<UserEntity> users = (List<UserEntity>) userRepository.findAll();
		

		Type listeType = new TypeToken<List<UserDto>>() {}.getType();
		List<UserDto> employDto = new ModelMapper().map(users,listeType);
		
		List <UserDto> employee=new ArrayList();
		
		for(int i=0;i<employDto.size();i++){
			if(employDto.get(i).getRole().equals("EMPLOYEE")) {
				employee.add(employDto.get(i));
			}
		}
		return employee;
	}


}
