package exceptions;

public class NonExistanteInstanceException extends RuntimeException {
    public NonExistanteInstanceException(String s) {
        super(s);
    }
}
