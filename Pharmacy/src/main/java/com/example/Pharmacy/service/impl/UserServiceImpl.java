package com.example.Pharmacy.service.impl;


import com.example.Pharmacy.common.TimeProvider;
import com.example.Pharmacy.config.consts.UserRoles;
import com.example.Pharmacy.dto.UserDTO;
import com.example.Pharmacy.dto.UserRegistrationDTO;
import com.example.Pharmacy.exception.ApiRequestException;
import com.example.Pharmacy.exception.ResourceNotFoundException;
import com.example.Pharmacy.mappers.UserMapper;
import com.example.Pharmacy.model.*;
import com.example.Pharmacy.repository.AuthorityRepository;
import com.example.Pharmacy.repository.ConfirmationTokenRepository;
import com.example.Pharmacy.repository.UserRepository;
import com.example.Pharmacy.service.AuthorityService;
import com.example.Pharmacy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthorityService authService;

	@Autowired
	private ConfirmationTokenRepository tokenRepository;

	@Autowired
	private TimeProvider timeProvider;

	@Autowired
	private AuthorityRepository authorityRepository;

	@Override
	public User findByUsername(String username) throws UsernameNotFoundException {
		User u = userRepository.findByUsername(username);
		return u;
	}

	public User findById(Long id) throws AccessDeniedException {
		User u = userRepository.findById(id).orElseGet(null);
		return u;
	}

	public List<User> findAll() throws AccessDeniedException {
		List<User> result = userRepository.findAll();
		return result;
	}


	@Override
	public User save(User u) {

		return userRepository.save(u);
	}

	@Override
	public User addUser(UserRegistrationDTO userInfo) {
		if (userRepository.findByUsername(userInfo.getUsername()) != null) {
			throw new ApiRequestException("Username '" + userInfo.getUsername() + "' already exists.");
		}

		/*if (!userInfo.getPassword().equals(userInfo.getRepeatPassword())) {
			throw new ApiRequestException("Provided passwords must be the same.");
		}*/

		if (userRepository.findByEmail(userInfo.getEmail()) != null) {
			throw new ApiRequestException("Email '" + userInfo.getEmail() + "' is taken.");
		}

		User user = createNewUserObject(userInfo);
		userRepository.save(user);

		ConfirmationToken token = new ConfirmationToken(user);
		tokenRepository.save(token);

		//mailSenderService.sendRegistrationMail(token);

		return user;
	}

	public User addUserSup(UserRegistrationDTO userInfo) {
		if (userRepository.findByUsername(userInfo.getUsername()) != null) {
			throw new ApiRequestException("Username '" + userInfo.getUsername() + "' already exists.");
		}

		/*if (!userInfo.getPassword().equals(userInfo.getRepeatPassword())) {
			throw new ApiRequestException("Provided passwords must be the same.");
		}*/

		if (userRepository.findByEmail(userInfo.getEmail()) != null) {
			throw new ApiRequestException("Email '" + userInfo.getEmail() + "' is taken.");
		}

		User user = createNewUserObjectSup(userInfo);
		userRepository.save(user);

		ConfirmationToken token = new ConfirmationToken(user);
		tokenRepository.save(token);

		//mailSenderService.sendRegistrationMail(token);

		return user;
	}

	public User addUserDerm(UserRegistrationDTO userInfo) {
		if (userRepository.findByUsername(userInfo.getUsername()) != null) {
			throw new ApiRequestException("Username '" + userInfo.getUsername() + "' already exists.");
		}

		/*if (!userInfo.getPassword().equals(userInfo.getRepeatPassword())) {
			throw new ApiRequestException("Provided passwords must be the same.");
		}*/

		if (userRepository.findByEmail(userInfo.getEmail()) != null) {
			throw new ApiRequestException("Email '" + userInfo.getEmail() + "' is taken.");
		}

		User user = createNewUserObjectDerm(userInfo);
		userRepository.save(user);

		ConfirmationToken token = new ConfirmationToken(user);
		tokenRepository.save(token);

		//mailSenderService.sendRegistrationMail(token);

		return user;
	}

	public User addUserAdmin(UserRegistrationDTO userInfo) {
		if (userRepository.findByUsername(userInfo.getUsername()) != null) {
			throw new ApiRequestException("Username '" + userInfo.getUsername() + "' already exists.");
		}

		if (userRepository.findByEmail(userInfo.getEmail()) != null) {
			throw new ApiRequestException("Email '" + userInfo.getEmail() + "' is taken.");
		}

		User user = createNewUserObjectAdmin(userInfo);
		userRepository.save(user);

		ConfirmationToken token = new ConfirmationToken(user);
		tokenRepository.save(token);

		return user;
	}

	private User createNewUserObject(UserRegistrationDTO userInfo) {
		User user = UserMapper.toUserEntity(userInfo);
		user.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		user.setLastPasswordResetDate(timeProvider.nowTimestamp());
		user.getUserAuthorities().add(authorityRepository.findByName(UserRoles.ROLE_PATIENT));
		user.setName(userInfo.getName());
		user.setSurname(userInfo.getSurname());
		user.setEmail(userInfo.getEmail());
		user.setAddress(userInfo.getAddress());
		user.setCity(userInfo.getCity());
		user.setCountry(userInfo.getCountry());
		user.setRoleType(UserRoles.ROLE_PATIENT);
		user.setNumber(userInfo.getPhone());

		//aktivacija naloga
		user.setEnabled(true);

		return user;
	}

	private User createNewUserObjectSup(UserRegistrationDTO userInfo) {
		User user = UserMapper.toUserEntity(userInfo);
		user.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		user.setLastPasswordResetDate(timeProvider.nowTimestamp());
		user.getUserAuthorities().add(authorityRepository.findByName(UserRoles.ROLE_SUPPLIER));
		user.setName(userInfo.getName());
		user.setSurname(userInfo.getSurname());
		user.setEmail(userInfo.getEmail());
		user.setAddress(userInfo.getAddress());
		user.setCity(userInfo.getCity());
		user.setCountry(userInfo.getCountry());
		user.setRoleType(UserRoles.ROLE_SUPPLIER);
		user.setNumber(userInfo.getPhone());

		//aktivacija naloga
		user.setEnabled(true);

		return user;
	}

	private User createNewUserObjectDerm(UserRegistrationDTO userInfo) {
		User user = UserMapper.toUserEntity(userInfo);
		user.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		user.setLastPasswordResetDate(timeProvider.nowTimestamp());
		user.getUserAuthorities().add(authorityRepository.findByName(UserRoles.ROLE_DERMATOLOGIST));
		user.setName(userInfo.getName());
		user.setSurname(userInfo.getSurname());
		user.setEmail(userInfo.getEmail());
		user.setAddress(userInfo.getAddress());
		user.setCity(userInfo.getCity());
		user.setCountry(userInfo.getCountry());
		user.setRoleType(UserRoles.ROLE_DERMATOLOGIST);
		user.setNumber(userInfo.getPhone());

		//aktivacija naloga
		user.setEnabled(true);

		return user;
	}

	private User createNewUserObjectAdmin(UserRegistrationDTO userInfo) {
		User user = UserMapper.toUserEntity(userInfo);
		user.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		user.setLastPasswordResetDate(timeProvider.nowTimestamp());
		user.getUserAuthorities().add(authorityRepository.findByName(UserRoles.ROLE_ADMIN));
		user.setName(userInfo.getName());
		user.setSurname(userInfo.getSurname());
		user.setEmail(userInfo.getEmail());
		user.setAddress(userInfo.getAddress());
		user.setCity(userInfo.getCity());
		user.setCountry(userInfo.getCountry());
		user.setRoleType(UserRoles.ROLE_ADMIN);
		user.setNumber(userInfo.getPhone());

		//aktivacija naloga
		user.setEnabled(true);

		return user;
	}

	@Override
	public User editUser(UserDTO user) {
		//User userInfo = userHelper.getCurrentUser();
		User userInfo = new User();

		userInfo.setName(user.getName());
		userInfo.setSurname(user.getSurname());
		userInfo.setUsername(user.getUsername());
		userInfo.setCountry(user.getCountry());
		userInfo.setCity(user.getCity());
		userInfo.setAddress(user.getAddress());
		return userInfo;
	}

	@Override
	public void delete(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " doesn't exist"));

		userRepository.delete(user);
	}

	@Override
	public void activateUser(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " doesn't exist"));

		if(user.isEnabled()) {
			user.setEnabled(false);
		} else {
			user.setEnabled(true);
		}
		userRepository.save(user);
	}

	@Override
	public User findOne(Long id) {
		return userRepository.findById(id).orElseGet(null);
	}

}
