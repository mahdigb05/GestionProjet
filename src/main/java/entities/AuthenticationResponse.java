package entities;

public class AuthenticationResponse {
    private String token;
    private ROLE role;
    
    

    public AuthenticationResponse() {
		super();
	}

	public AuthenticationResponse(String token, ROLE role) {
		
		this.token = token;
		this.role = role;
	}

	public String getToken() {
        return token;
    }

	public ROLE getRole() {
		return role;
	}
}
