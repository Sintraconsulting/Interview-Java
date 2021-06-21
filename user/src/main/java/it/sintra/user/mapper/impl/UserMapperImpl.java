package it.sintra.user.mapper.impl;

import org.springframework.stereotype.Component;

import it.sintra.user.mapper.UserMapper;
import it.sintra.user.model.dto.UserDto;
import it.sintra.user.model.entity.UserEntity;

@Component
public class UserMapperImpl implements UserMapper {

	@Override
	public UserDto entityToDto(UserEntity entity) {
		if (entity == null)
			return null;
		UserDto userDto = new UserDto();
		userDto.setDescription(entity.getDescription());
		userDto.setEmail(entity.getEmail());
		userDto.setLastName(entity.getLastName());
		userDto.setFirstName(entity.getFirstName());
		userDto.setFiscalCode(entity.getFiscalCode());
		userDto.setIdentityCardImageHash(entity.getIdentityCardImageHash());
		userDto.setIdentityCardNumber(entity.getIdentityCardNumber());
		userDto.setLastAccessDate(entity.getLastAccessDate());
		userDto.setIdUser(entity.getUserId());
		return userDto;

	}

	@Override
	public UserEntity dtoToEntity(UserDto dto) {
		if (dto == null)
			return null;
		UserEntity userEntity = new UserEntity();
		userEntity.setDescription(dto.getDescription());
		userEntity.setEmail(dto.getEmail());
		userEntity.setLastName(dto.getLastName());
		userEntity.setFirstName(dto.getFirstName());
		userEntity.setFiscalCode(dto.getFiscalCode());
		userEntity.setIdentityCardImageHash(dto.getIdentityCardImageHash());
		userEntity.setIdentityCardNumber(dto.getIdentityCardNumber());
		userEntity.setLastAccessDate(dto.getLastAccessDate());
		userEntity.setIdentityCardImage(dto.getIdentityCardImage());
		userEntity.setUserId(dto.getIdUser());
		return userEntity;
	}

}
