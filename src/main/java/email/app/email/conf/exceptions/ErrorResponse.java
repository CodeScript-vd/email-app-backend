package email.app.email.conf.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Builder
@Data
@AllArgsConstructor
public class ErrorResponse extends ResponseEntityExceptionHandler {
    private String message;
    public  ErrorResponse() { super(); };
}
