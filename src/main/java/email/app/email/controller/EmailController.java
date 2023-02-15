package email.app.email.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sendgrid.*;
import email.app.email.bean.EmailResponse;
import email.app.email.conf.exceptions.ErrorExceptions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

@RestController
@RequestMapping("/sendEmail")
public class EmailController {

    private final String apiKey = "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";

    @PostMapping()
    public EmailResponse sendEmail(@RequestBody EmailResponse requestBody) throws IOException {

        Email from = new Email("vdiaz.2192@gmail.com");
        String subject = requestBody.getSubject();
        Email to = new Email(requestBody.getFromTo());
        Content content = new Content("text/plain", requestBody.getMessage());
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(this.apiKey);

        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            if (response.getStatusCode() >= 400) {
                Integer responseBody = response.getStatusCode();
                throw new IOException(responseBody + "");
            }

        } catch (IOException ex) {
            System.out.println("MESSAGE: " + ex);
            throw new ErrorExceptions("Error al cargar error");
        }
        return requestBody;
    }

    @GetMapping("/validate")
    public String validate(@RequestBody EmailResponse emailResponse) throws IOException {
        String apiKey = this.apiKey;
        String email = emailResponse.getFromTo();

        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();

        try {
            request.setMethod(Method.GET);
            request.setEndpoint("v3/validations/email");
            request.addQueryParam("email", email);

            Response response = sg.api(request);
            String responseBody = response.getBody();
            System.out.println(responseBody);
        } catch (IOException ex) {
            System.out.println("Error en la respuesta de SendGrid: " + ex.getMessage());
        }
        return  "Validacion correcta";
    }
}
