package it.sintra.user.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.sintra.user.mapper.impl.UserMapperImpl;
import it.sintra.user.model.dto.ApiResponse;
import it.sintra.user.model.dto.UserDto;
import it.sintra.user.service.UserService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserMapperImpl useMapperImpl;

	@GetMapping("/{userId}")
	public ResponseEntity<ApiResponse<UserDto>> getUser(@PathVariable Long userId) {

		log.info("START - getUser() - input userId={}", userId);
		return ResponseEntity.ok(new ApiResponse<>(HttpStatus.CREATED.value(), null,
				useMapperImpl.entityToDto(userService.findByUserId(userId))));

	}

	@PostMapping("/add")
	public ResponseEntity<ApiResponse<UserDto>> addUser(@Valid @RequestBody UserDto userDto, Error errors) {

		log.info("START - addUser() - input UserDto={}", userDto.toString());
		return ResponseEntity.ok(new ApiResponse<>(HttpStatus.CREATED.value(), null,
				useMapperImpl.entityToDto(userService.insertUser(useMapperImpl.dtoToEntity(userDto)))));
	}

	@PutMapping("/update")
	public ResponseEntity<ApiResponse<UserDto>> updateUser(@Valid @RequestBody UserDto userDto, Error errors) {

		log.info("START - updateUser() - input UserDto={}", userDto.toString());
		return ResponseEntity.ok(new ApiResponse<>(HttpStatus.CREATED.value(), null,
				useMapperImpl.entityToDto(userService.updateUser(useMapperImpl.dtoToEntity(userDto)))));
	}

	@GetMapping("/users")
	public ResponseEntity<ApiResponse<List<UserDto>>> getAllUsers() {

		return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), null,
				userService.getAllUsers().stream().map(useMapperImpl::entityToDto).collect(Collectors.toList())));
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse<List<UserDto>>> deletUser(@PathVariable Long userId) {

		log.info("START - deletUser() - input UserDto={}", userId);
		return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), null,
				userService.getAllUsers().stream().map(useMapperImpl::entityToDto).collect(Collectors.toList())));
	}

}
