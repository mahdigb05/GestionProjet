package com.ensa.controllers;


import com.ensa.Utils.JwtUtil;
import com.ensa.entities.AuthenticationRequest;
import com.ensa.entities.AuthenticationResponse;
import com.ensa.entities.GpUserDetail;
import com.ensa.services.GpUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private GpUserDetailService gpUserDetailService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),authenticationRequest.getPassword())
            );

        }catch (BadCredentialsException e)
        {
            throw new BadCredentialsException("cet utilisateur n'existe pas");
        }
        final GpUserDetail userDetail = gpUserDetailService.loadUserByUsername(authenticationRequest.getEmail());
        final String jwt = jwtUtil.generateToken(userDetail);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse(jwt, userDetail.getUtilisateur().getRole());
        return new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
    }
}
