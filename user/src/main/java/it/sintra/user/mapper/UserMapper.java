package it.sintra.user.mapper;

import org.mapstruct.Mapper;

import it.sintra.user.model.dto.UserDto;
import it.sintra.user.model.entity.UserEntity;

@Mapper
public interface UserMapper {
	
	UserDto entityToDto(UserEntity entity);
	
	UserEntity dtoToEntity(UserDto dto);

}
