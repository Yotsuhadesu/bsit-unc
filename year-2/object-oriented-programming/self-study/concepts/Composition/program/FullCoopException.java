package program;
public class FullCoopException extends Exception {
    public FullCoopException() {
        super("Capacity reached. Cannot accept the chicken.");
    }
}
