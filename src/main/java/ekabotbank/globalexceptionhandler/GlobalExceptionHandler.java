package ekabotbank.globalexceptionhandler;

import ekabotbank.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleAccountNotFoundException(AccountNotFoundException e) {
        return e.getMessage();
    }
    @ExceptionHandler(MinimumOpeningBalanceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleMinimumOpeningBalanceException(MinimumOpeningBalanceException e) {
        return e.getMessage();
    }
    @ExceptionHandler(InvalidAmountException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidAmountException(InvalidAmountException e) {
        return e.getMessage();
    }
    @ExceptionHandler(InsufficientBalanceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInsufficientBalanceException(InsufficientBalanceException e) {
        return e.getMessage();
    }
    @ExceptionHandler(UsernameAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleUsernameAlreadyExistsException(UsernameAlreadyExistsException e) {
        return e.getMessage();
    }
    @ExceptionHandler(InvalidCredentialsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidCredentialsException(InvalidCredentialsException e) {
        return e.getMessage();
    }
}

