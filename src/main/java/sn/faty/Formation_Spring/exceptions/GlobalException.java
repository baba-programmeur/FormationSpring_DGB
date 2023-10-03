package sn.faty.Formation_Spring.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {


    @ExceptionHandler(EntittyNotFoundException.class)
    public ResponseEntity<?> handlerExceptionOfSearchEntityById(final EntittyNotFoundException entittyNotFoundException){

           Map<String, ErrorCodes> errors= new HashMap<>();

           errors.put(entittyNotFoundException.getMessage(), entittyNotFoundException.getErrorCodes());

           return
                   new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);

    }

}
