package controllers;

import Utils.JwtUtil;
import entities.AuthenticationRequest;
import entities.AuthenticationResponse;
import entities.GpUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import services.GpUserDetailService;

public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private GpUserDetailService gpUserDetailService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;


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
