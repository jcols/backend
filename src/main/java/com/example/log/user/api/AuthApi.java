package com.example.log.user.api;

import com.example.log.user.User;
import javax.validation.Valid;
//import net.codejava.jwt.JwtTokenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.log.jwt.JwtTokenUtil;

@RestController
public class AuthApi {
	@Autowired AuthenticationManager authManager;
	@Autowired JwtTokenUtil jwtUtil;
	
        @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
	@PostMapping("/auth/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
		try {
			Authentication authentication = authManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							request.getEmail(), request.getPassword())
			);
			
			User user = (User) authentication.getPrincipal();
			String accessToken = jwtUtil.generateAccessToken(user);
			//AuthResponse response = new AuthResponse(user.getEmail(), accessToken);
                        AuthResponse response = new AuthResponse(accessToken);
                        
			
			
			return ResponseEntity.ok().body(response);
			
		} catch (BadCredentialsException ex) {
                    System.out.println("Algo fallo: "+ex);
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
                     
		}
	}
}
