/**
 * Describes an exception from invalid price values
 */
public class InvalidPriceException extends InvalidTransactionException {
    public InvalidPriceException(String message) {
        super(message);
    }
}
