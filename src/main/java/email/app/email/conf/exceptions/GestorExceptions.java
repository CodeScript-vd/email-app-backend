package email.app.email.conf.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

//@ControllerAdvice
public class GestorExceptions {
    //@ExceptionHandler(ErrorExceptions.class)
    protected ResponseEntity<ErrorResponse> handled(String message) {
        return ResponseEntity.status(404).body(ErrorResponse.builder().message(message).build());
    }
}
