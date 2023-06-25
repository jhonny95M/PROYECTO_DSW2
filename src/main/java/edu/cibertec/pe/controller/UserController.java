package edu.cibertec.pe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.pe.config.provider.JwtTokenProvider;
import edu.cibertec.pe.request.AuthenticationRequest;
import edu.cibertec.pe.response.AuthenticationResponse;


@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@GetMapping
	public String Get() {
		return "Todo ok";
	}
	  
	    @Autowired
	    private JwtTokenProvider jwtTokenProvider;
	  
	    @Autowired
	    private AuthenticationManager authenticationManager;
	  
	    @Autowired
	    private UserDetailsService userDetailsService;
	  
	    @PostMapping("/authenticate")//password 123a
	    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) {
	    	System.out.println("si ingreso");
	        try {
	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
	            UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
	            String token = jwtTokenProvider.generateToken(userDetails.getUsername());
	            return ResponseEntity.ok(new AuthenticationResponse(token));
	        } catch (AuthenticationException ex) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username/password");
	        }
	    }
	  
	    @GetMapping("/public")
	    public String publicEndpoint() {
	        return "Public endpoint";
	    }
	  
	    @GetMapping("/private")
	    public String privateEndpoint() {
	        return "Private endpoint";
	    }
}
