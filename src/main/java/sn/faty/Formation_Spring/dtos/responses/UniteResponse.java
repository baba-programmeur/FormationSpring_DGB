package sn.faty.Formation_Spring.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.faty.Formation_Spring.entities.Unite;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UniteResponse {

    private  Long id ;

    private  String code ;

    private  String libelle ;


    public static  UniteResponse toDto(Unite unite){

        return
                UniteResponse.builder()
                        .id(unite.getId())
                        .code(unite.getCode())
                        .libelle(unite.getLibelle())
                        .build();
    }


}
