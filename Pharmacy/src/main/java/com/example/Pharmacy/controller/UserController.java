package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.HospitalDTO;
import com.example.Pharmacy.dto.UserDTO;
import com.example.Pharmacy.dto.UserRegistrationDTO;
import com.example.Pharmacy.mappers.UserMapper;
import com.example.Pharmacy.model.User;
import com.example.Pharmacy.service.UserService;
import com.example.Pharmacy.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// Primer kontrolera cijim metodama mogu pristupiti samo autorizovani korisnici
@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserService userService;

	private UserServiceImpl userImpl;

    @PostMapping("/public/register")
    public ResponseEntity add(@Valid @RequestBody UserRegistrationDTO user) {
        userService.addUser(user);
        return ResponseEntity.ok().build();
    }

	@PostMapping("/registersup")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity addSup(@Valid @RequestBody UserRegistrationDTO user) {
		userService.addUserSup(user);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/registerderm")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity addDerm(@Valid @RequestBody UserRegistrationDTO user) {
		userService.addUserDerm(user);
		return ResponseEntity.ok().build();
	}

	// Za pristup ovoj metodi neophodno je da ulogovani korisnik ima ADMIN ulogu
	// Ukoliko nema, server ce vratiti gresku 403 Forbidden
	// Korisnik jeste autentifikovan, ali nije autorizovan da pristupi resursu
	@GetMapping("/user/{userId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public User loadById(@PathVariable Long userId) {
		return this.userService.findById(userId);
	}

	@GetMapping("/user/all")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<User> loadAll() {
		return this.userService.findAll();
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity delete(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("activate/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity activate(@PathVariable Long id) {
		userService.activateUser(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/logged/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
		User user = userService.findById(id);
		return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
	}

	@CrossOrigin
	@PutMapping(value = "/edit")
	public ResponseEntity<UserDTO> editUser(@RequestBody UserDTO userDTO) {

		User userInfo = userService.findById(userDTO.getId());
		userInfo.setName(userDTO.getName());
		userInfo.setSurname(userDTO.getSurname());
		userInfo.setUsername(userDTO.getUsername());
		userInfo.setCountry(userDTO.getCountry());
		userInfo.setCity(userDTO.getCity());
		userInfo.setAddress(userDTO.getAddress());
		userInfo.setNumber(userDTO.getNumber());

		userInfo = userService.save(userInfo);

		return new ResponseEntity<>(UserMapper.toDto(userInfo), HttpStatus.OK);
	}
}
