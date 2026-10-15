/**
 * A custom built exception class to address invalid values passed to Transaction class mutators.
 */
public class InvalidTransactionException extends Exception {
    public InvalidTransactionException(String message) {
        super(message);
    }
}
