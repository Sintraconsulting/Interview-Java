package it.sintra.user.service;
import java.util.List;

import it.sintra.user.model.entity.UserEntity;
public interface Iuser {
	  List<UserEntity> getAllUsers();
	  
	  UserEntity insertUser(UserEntity userEntity);
	  
	  UserEntity updateUser(UserEntity userEntity);
	  
	  UserEntity findByUserId(Long id);
	  
	  UserEntity deleteByUserId(Long id);
	  
	  
}
