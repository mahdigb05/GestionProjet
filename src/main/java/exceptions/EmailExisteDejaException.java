package exceptions;

public class EmailExisteDejaException extends RuntimeException{

    public EmailExisteDejaException(String message) {
        super(message);
    }
}
