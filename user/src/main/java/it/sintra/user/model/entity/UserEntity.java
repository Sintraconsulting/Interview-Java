package it.sintra.user.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "users")
public class UserEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 498786098814713195L;
	
	@Id
	@Column(name="ID_USER")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(name="EMAIL")
	private String email;
	
	
	@Column(name="FIRST_NAME")
	private String lastName;
	
	@Column(name="LAST_NAME")
	private String firstName;
	
	@Column(name="FISCAL_CODE")
	private String fiscalCode;
	//optional
	@Column(name="DESCRIPTION")
	private String description;
	//optional
	@Column(name="LAST_ACCESS_DATA")
	@Temporal(javax.persistence.TemporalType.DATE)
    @DateTimeFormat(pattern="yyy.MM.dd")
	private Date lastAccessDate;
	
	@Column(name="IDENTITY_CARD_NUMBER")
	private String identityCardNumber;
	
	@Column(name="IDENTITY_CARD_IMAGHE_HASH")
	private String identityCardImageHash;
	

	@Column(name="IDENTITY_CARD_IMG")
	private String identityCardImage;
	
}
