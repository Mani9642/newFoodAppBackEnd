package com.cigniti.foodApp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cigniti.foodApp.entity.AuthenticationRequest;
import com.cigniti.foodApp.entity.AuthenticationResponse;
import com.cigniti.foodApp.entity.User;
import com.cigniti.foodApp.repository.UserRepository;
import com.cigniti.foodApp.service.MyUserDetailsService;
import com.cigniti.foodApp.utility.JwtUtil;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Authentication {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
    UserRepository userRepository;

	

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		

		final String accessToken = jwtTokenUtil.generateToken(userDetails);
		
		Optional<User> user = userRepository.findByUserName(authenticationRequest.getUsername()); 

		return ResponseEntity.ok(new AuthenticationResponse(accessToken,user));
	}


}
