package it.sintra.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.sintra.user.model.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{

	UserEntity findByfiscalCode(String fiscalCode);
	
	UserEntity findByUserId(Long userId);
	
	UserEntity findByFiscalCodeOrEmail(String fiscalCode,String email);
	
	UserEntity deleteByUserId(Long userId);
	
 
}
