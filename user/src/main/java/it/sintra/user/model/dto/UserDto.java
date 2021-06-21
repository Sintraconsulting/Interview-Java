package it.sintra.user.model.dto;

import java.io.Serializable;
import java.util.Date;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



// classUserDto for expose inteface data 
@Getter
@Setter
@Data
public class UserDto  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5330471780955703491L;

	private Long userId;

	@NotNull(message="Email is not be null.")
	@Email(message = "Email is not be valid.")
	private String email;
	@NotNull(message="Last Name is not be null.")
	private String lastName;
	
	@NotNull(message="First Name is not be null.")
	private String firstName;
	
	@NotNull(message = "fiscal code has to be present")
	@Pattern(regexp = "^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$",message = "Fiscal code not be valid.")
	@Size(message = "The size of fiscal code must be sixteen alphanumeric characters")
	private String fiscalCode;
	//optional
	private String description;
	//optional
	private Date lastAccessDate;
	
	@NotNull(message="Identity Card Number is not be null.")
	private String identityCardNumber;
	@NotNull(message = "Identity card manager hash is not be null")
	private String identityCardImageHash;
	
	@NotNull(message = "Identity card manager is not be null")
	private String identityCardImage;
	
	private Long idUser;
	
	
	
	

}
