package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.MedsDTO;
import com.example.Pharmacy.dto.PharmaciesDTO;
import com.example.Pharmacy.dto.UserDTO;
import com.example.Pharmacy.dto.UserRegistrationDTO;
import com.example.Pharmacy.mappers.UserMapper;
import com.example.Pharmacy.model.Complaint;
import com.example.Pharmacy.model.Meds;
import com.example.Pharmacy.model.Pharmacies;
import com.example.Pharmacy.model.User;
import com.example.Pharmacy.service.MedsService;
import com.example.Pharmacy.service.UserService;
import com.example.Pharmacy.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// Primer kontrolera cijim metodama mogu pristupiti samo autorizovani korisnici
@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private MedsService medsService;

	private UserServiceImpl userImpl;

	@Autowired
	private PasswordEncoder passwordEncoder;

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

	@PostMapping("/registeradmin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity addAdmin(@Valid @RequestBody UserRegistrationDTO user) {
		userService.addUserAdmin(user);
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

	@CrossOrigin
	@PostMapping(value = "/edit/patient")
	@PreAuthorize("hasRole('ROLE_PATIENT')")
	public ResponseEntity<UserDTO> editPatient(@RequestBody UserDTO userDTO) {

		User userInfo = userService.findById(userDTO.getId());
		if(userInfo == null){
			return null;
		}
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

	@CrossOrigin
	@PostMapping(value = "/edit/adminph")
	@PreAuthorize("hasRole('ROLE_ADMINPH')")
	public ResponseEntity<UserDTO> editAdminPH(@RequestBody UserDTO userDTO) {

		User userInfo = userService.findById(userDTO.getId());
		if(userInfo == null){
			return null;
		}
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

	@CrossOrigin
	@PostMapping(value = "/editPass")
	@PreAuthorize("hasRole('ROLE_PATIENT')")
	public ResponseEntity<UserDTO> editPass(@RequestBody UserDTO userDTO) {

		User user = userService.findById(userDTO.getId());
		if(user == null){
			return null;
		}

		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user = userService.save(user);

		return new ResponseEntity<>(UserMapper.toDto(user), HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping(value = "/changePassword")
	@PreAuthorize("hasRole('ROLE_ADMINPH')")
	public ResponseEntity<UserDTO> changePassword(@RequestBody UserDTO userDTO) {

		User user = userService.findById(userDTO.getId());
		if(user == null){
			return null;
		}

		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user = userService.save(user);

		return new ResponseEntity<>(UserMapper.toDto(user), HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	public User findPatient(@PathVariable Long userId) {
		return this.userService.findById(userId);
	}

	@CrossOrigin
	@PostMapping(value = "/editPassSup")
	@PreAuthorize("hasRole('ROLE_SUPPLIER')")
	public ResponseEntity<UserDTO> editPassSup(@RequestBody UserDTO userDTO) {

		User userInfo = userService.findById(userDTO.getId());
		if(userInfo == null){
			return null;
		}
		userInfo.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		userInfo = userService.save(userInfo);

		return new ResponseEntity<>(UserMapper.toDto(userInfo), HttpStatus.OK);
	}

	@GetMapping(value = "/pharmacy/{dermatologistId}")
	//@PreAuthorize("hasRole('ROLE_ADMINPH')")
	public ResponseEntity<List<PharmaciesDTO>> getPharmacyForDermatologist(@PathVariable Long dermatologistId) {

		User derm = userService.findOne(dermatologistId);

		Set<Pharmacies> ph = derm.getPhDermatologist();
		List<PharmaciesDTO> phDTO = new ArrayList<>();

		for( Pharmacies c : ph) {
			phDTO.add(new PharmaciesDTO(c));
		}
		return new ResponseEntity<>(phDTO, HttpStatus.OK);
	}


	@GetMapping(value = "/ph/{pharmacist_id}")
	//@PreAuthorize("hasRole('ROLE_ADMINPH')")
	public ResponseEntity<List<PharmaciesDTO>> getPharmacyForPharmacist(@PathVariable Long pharmacist_id) {

		User pharmacist = userService.findOne(pharmacist_id);

		Set<Pharmacies> ph = pharmacist.getPhPharmacist();
		List<PharmaciesDTO> phDTO = new ArrayList<>();

		for( Pharmacies c : ph) {
			phDTO.add(new PharmaciesDTO(c));
		}
		return new ResponseEntity<>(phDTO, HttpStatus.OK);
	}

}
