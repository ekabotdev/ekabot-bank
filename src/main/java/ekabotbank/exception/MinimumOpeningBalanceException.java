package ekabotbank.exception;

public class MinimumOpeningBalanceException extends RuntimeException {
    public MinimumOpeningBalanceException(String message) {
        super(message);
    }
}
