package it.sintra.user;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.MethodArgumentNotValidException;

import it.sintra.user.common.exception.CorruptImageException;
import it.sintra.user.common.exception.DuplicateValueException;
import it.sintra.user.common.exception.ResourceNotFoundException;
import it.sintra.user.mapper.impl.UserMapperImpl;
import it.sintra.user.model.dto.UserDto;
import it.sintra.user.service.UserService;
import it.sintra.user.utility.Message;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserApplicationTests {

	@Autowired
	private UserService userService;
	@Autowired
	private UserMapperImpl useMapperImpl;

	@Test
	void contextLoads() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test_sintra;DB_CLOSE_DELAY=-1");
		dataSource.setUsername("root");
		dataSource.setPassword("");
	}

	//test con l'inserimento di un codice fiscale giù presente 
	@Test
	public void inserUserValidationFiscalCode() {

		UserDto userDto = new UserDto();
		userDto.setDescription("test");
		userDto.setEmail("a.cibelli@gmail.it");
		userDto.setFirstName("a");
		userDto.setLastName("a");
		userDto.setFiscalCode("CBLLSN90D10F912E");
		userDto.setIdentityCardNumber("123456");
		userDto.setIdentityCardImageHash("0508f43ac035c0091577f64928ed5e9432d74a4383bd4d313dca908f2dbe9b25");
		userDto.setIdentityCardImage("dfgvfdfdvddefbv");
		userDto.setLastAccessDate(new Date());
		useMapperImpl.dtoToEntity(userDto);
		Exception exception = assertThrows(DuplicateValueException.class, () -> {
			userService.insertUser(useMapperImpl.dtoToEntity(userDto));
		});

		String expectedMessage = Message.FISCAL_CODE_EXIST.toString();
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));

	}
	
	//test con update  di un codice fiscale giù presente 
	@Test
	public void updateUserValidationFiscalCode() {

		UserDto userDto = new UserDto();
		userDto.setDescription("test");
		userDto.setEmail("a.cibelli@gmail.it");
		userDto.setFirstName("a");
		userDto.setLastName("a");
		userDto.setFiscalCode("CBLLSN90D10F912E");
		userDto.setIdentityCardNumber("123456");
		userDto.setIdentityCardImageHash("0508f43ac035c0091577f64928ed5e9432d74a4383bd4d313dca908f2dbe9b25");
		userDto.setIdentityCardImage("dfgvfdfdvddefbv");
		userDto.setLastAccessDate(new Date());
		useMapperImpl.dtoToEntity(userDto);
		Exception exception = assertThrows(DuplicateValueException.class, () -> {
			userService.updateUser(useMapperImpl.dtoToEntity(userDto));
		});

		String expectedMessage = Message.FISCAL_CODE_EXIST.toString();
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));

	}
	//test con l'inserimento di una mail  già presente 
	@Test
	public void inserUserValidatioMail() {

		UserDto userDto = new UserDto();
		userDto.setDescription("test");
		userDto.setEmail("alessandro.cibelli@gmail.com");
		userDto.setFirstName("a");
		userDto.setLastName("a");
		userDto.setFiscalCode("CBNNSN90D10F912");
		userDto.setIdentityCardNumber("123456");
		userDto.setIdentityCardImageHash("0508f43ac035c0091577f64928ed5e9432d74a4383bd4d313dca908f2dbe9b25");
		userDto.setIdentityCardImage("dfgvfdfdvddefbv");
		userDto.setLastAccessDate(new Date());
		useMapperImpl.dtoToEntity(userDto);
		Exception exception = assertThrows(DuplicateValueException.class, () -> {
			userService.insertUser(useMapperImpl.dtoToEntity(userDto));
		});

		String expectedMessage = Message.MAIL_ALREADY_EXIST.toString();
		String actualMessage = exception.getMessage();
		System.out.println(actualMessage);

		assertTrue(actualMessage.contains(expectedMessage));

	}
	
	//test con l'update di una mail  già presente 
	@Test
	public void updateUserValidatioMail() {

		UserDto userDto = new UserDto();
		userDto.setDescription("test");
		userDto.setEmail("alessandro.cibelli@gmail.com");
		userDto.setFirstName("a");
		userDto.setLastName("a");
		userDto.setFiscalCode("CBNNSN90D10F912");
		userDto.setIdentityCardNumber("123456");
		userDto.setIdentityCardImageHash("0508f43ac035c0091577f64928ed5e9432d74a4383bd4d313dca908f2dbe9b25");
		userDto.setIdentityCardImage("dfgvfdfdvddefbv");
		userDto.setLastAccessDate(new Date());
		useMapperImpl.dtoToEntity(userDto);
		Exception exception = assertThrows(DuplicateValueException.class, () -> {
			userService.updateUser(useMapperImpl.dtoToEntity(userDto));
		});

		String expectedMessage = Message.MAIL_ALREADY_EXIST.toString();
		String actualMessage = exception.getMessage();
		System.out.println(actualMessage);

		assertTrue(actualMessage.contains(expectedMessage));

	}

	//test con l'inserimento dove va in eccezione il check sull'integrita dell'immagine
	@Test
	public void insertUserValidationIntegrityImage() {

		UserDto userDto = new UserDto();
		userDto.setDescription("test");
		userDto.setEmail("alessandro.cibelli@gmail.eu");
		userDto.setFirstName("name");
		userDto.setLastName("laste name");
		userDto.setFiscalCode("CBSSSN90D10F912E");
		userDto.setIdentityCardNumber("123456");
		userDto.setIdentityCardImageHash("0508F43AC035C0091577F64928ED5E9432D74A4383BD4D313DCA908F2DBE9B25");
		userDto.setIdentityCardImage("dfgvfdfdvddefb7");
		userDto.setLastAccessDate(new Date());
		useMapperImpl.dtoToEntity(userDto);
		Exception exception = assertThrows(CorruptImageException.class, () -> {
			userService.insertUser(useMapperImpl.dtoToEntity(userDto));
		});

		String expectedMessage = Message.IMAGE_IS_CORRUPT.toString();
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));

	}
	
	//test con l'update dove va in eccezione il check sull'integrita dell'immagine
	@Test
	public void updateUserValidationIntegrityImage() {

		UserDto userDto = new UserDto();
		userDto.setDescription("test");
		userDto.setEmail("alessandro.cibelli@gmail.eu");
		userDto.setFirstName("name");
		userDto.setLastName("laste name");
		userDto.setFiscalCode("CBSSSN90D10F912E");
		userDto.setIdentityCardNumber("123456");
		userDto.setIdentityCardImageHash("0508F43AC035C0091577F64928ED5E9432D74A4383BD4D313DCA908F2DBE9B25");
		userDto.setIdentityCardImage("dfgvfdfdvddefb7");
		userDto.setLastAccessDate(new Date());
		useMapperImpl.dtoToEntity(userDto);
		Exception exception = assertThrows(CorruptImageException.class, () -> {
			userService.updateUser(useMapperImpl.dtoToEntity(userDto));
		});

		String expectedMessage = Message.IMAGE_IS_CORRUPT.toString();
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));

	}
	
	@Test
	public void findByUserId() {

		assertNotNull(userService.findByUserId((long) 1));
		

	}
	
	@Test
	public void findByUserIdException() {
		
		Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
			userService.findByUserId((long) 10);
		});
		
		String expectedMessage = Message.USER_NOT_FOUND.toString();
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));

	}
	
	
	

	
}
