package email.app.email.conf.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ErrorExceptions extends  RuntimeException {

    private final String message;
    public ErrorExceptions(String message) {
        super("error-400");
        this.message = message;
    }

    public static ErrorExceptions of(String message) {
        return  new ErrorExceptions(message);
    }
}

