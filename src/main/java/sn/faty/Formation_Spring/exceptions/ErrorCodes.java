package sn.faty.Formation_Spring.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public enum ErrorCodes {

    CATEGORIE_NOT_FOUND(1000),


//************************************************


    FOURNISSEUR_NOT_FOUND(2000),


    //********************************************

    UNITE_NOT_FOUND(2000);


    private int code ;
    ErrorCodes(int code) {
        this.code = code;
    }


}
