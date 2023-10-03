package sn.faty.Formation_Spring.exceptions;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class EntittyNotFoundException  extends  RuntimeException{

    private String key="error on the field";
    //???
    private HttpStatus httpStatus=HttpStatus.NOT_FOUND ;

    private ErrorCodes errorCodes ;

    public EntittyNotFoundException(String message,ErrorCodes errorCodes) {
        super(message);
        this.errorCodes = errorCodes;
    }
}
