package ex01.client;

public class JogadorMortoException extends Exception {
    private static final String MSG = "Você morreu! :(";

    public JogadorMortoException() {
    }

    public JogadorMortoException(String message) {
        super(message);
    }

    public String getMessage() {
        return MSG;
    }
}
