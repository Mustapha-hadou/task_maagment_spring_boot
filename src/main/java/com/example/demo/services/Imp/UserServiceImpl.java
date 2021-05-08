package com.example.demo.services.Imp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;

import com.example.demo.entities.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;
import com.example.demo.sherd.Utils;
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
	public void createUser(UserDto userDto) {
		
        UserEntity checkuser =  userRepository.findByEmail(userDto.getEmail());
	    if(checkuser != null) throw new RuntimeException("cet utilisqteur existe deja dans la base de donnes");
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);
		userEntity.setEncryptepassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		userEntity.setUserId(util.generateStringId(32));
		
		UserEntity newuserEntity = userRepository.save(userEntity);
		
		
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
	
	

}
