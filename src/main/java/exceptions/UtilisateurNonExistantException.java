package exceptions;

public class UtilisateurNonExistantException extends RuntimeException{
    public UtilisateurNonExistantException(String message) {
        super(message);
    }
}
