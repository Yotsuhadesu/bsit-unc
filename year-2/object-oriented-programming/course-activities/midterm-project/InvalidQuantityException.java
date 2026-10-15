/**
 * Describes an exception from invalid item quantity values
 */
public class InvalidQuantityException extends InvalidTransactionException {
    public InvalidQuantityException(String message) {
        super(message);
    }
}
