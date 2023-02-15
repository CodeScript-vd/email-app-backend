package email.app.email.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EmailResponse  {

    @JsonProperty("fromTo")
    private String fromTo;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("message")
    protected  String message;
}
