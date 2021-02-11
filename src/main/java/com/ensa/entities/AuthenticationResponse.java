package com.ensa.entities;



public class AuthenticationResponse {
    private String token;
    private ROLE role;
    private String email;
    
    

    public AuthenticationResponse() {
		super();
	}

	public AuthenticationResponse(String token, ROLE role, String email) {
		
		this.token = token;
		this.role = role;
		this.email = email;
	}

	public String getToken() {
        return token;
    }

	public ROLE getRole() {
		return role;
	}
}
