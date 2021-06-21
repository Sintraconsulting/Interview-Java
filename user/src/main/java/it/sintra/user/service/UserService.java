package it.sintra.user.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import it.sintra.user.common.exception.CorruptImageException;
import it.sintra.user.common.exception.DuplicateValueException;
import it.sintra.user.common.exception.ResourceNotFoundException;
import it.sintra.user.model.entity.UserEntity;
import it.sintra.user.repository.UserRepository;
import it.sintra.user.security.HashSecurity;
import it.sintra.user.utility.Message;

@Component
public class UserService implements Iuser {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity insertUser(UserEntity userEntity) {
		check(userEntity);
		return userRepository.save(userEntity);
	}

	@Override
	public UserEntity updateUser(UserEntity userEntity) {
		check(userEntity);
		return userRepository.save(userEntity);
	}

	

	@Override
	public UserEntity findByUserId(Long userId) {
		UserEntity curentUser = userRepository.findByUserId(userId);
		if (curentUser == null)
			throw new ResourceNotFoundException(Message.USER_NOT_FOUND.toString());
		return curentUser;
	}

	@Override
	public UserEntity deleteByUserId(Long userId) {
		UserEntity curentUser = userRepository.findByUserId(userId);
		if (curentUser == null)
			throw new ResourceNotFoundException(Message.DELETE_USER_NOT_FOUND.toString());
		
		return userRepository.deleteByUserId(userId);
	}
	
	// check
	private void check(UserEntity userEntity)  {
		UserEntity curentUser = userRepository.findByFiscalCodeOrEmail(userEntity.getFiscalCode(),
				userEntity.getEmail());
		//check duplicate mail or fiscal code
		if (curentUser != null) {
			if (curentUser.getEmail().equalsIgnoreCase(userEntity.getEmail()))
				throw new DuplicateValueException(Message.MAIL_ALREADY_EXIST.toString());
			if (curentUser.getFiscalCode().equalsIgnoreCase(userEntity.getFiscalCode()))
				throw new DuplicateValueException(Message.FISCAL_CODE_EXIST.toString());
		}
		
		//check length() of input hash
		if (userEntity.getIdentityCardImageHash().length()!=64) {
			throw new CorruptImageException(Message.HASH_IS_CORRUPT.toString());
		}
		//check hash value image 
		
		if (!(HashSecurity.generateCardImageHash(userEntity.getIdentityCardImage()).
				equalsIgnoreCase(userEntity.getIdentityCardImageHash()))) {
			throw new CorruptImageException(Message.IMAGE_IS_CORRUPT.toString());
		}
	}
}
