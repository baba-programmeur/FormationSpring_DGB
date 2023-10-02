package sn.faty.Formation_Spring.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.faty.Formation_Spring.entities.Fournisseur;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FournisseurResponse {

    private  Long id ;

    private  String nom ;

    private  String zone ;

    public  static  FournisseurResponse toDto(Fournisseur fournisseur){

        return  FournisseurResponse.builder()
                .id(fournisseur.getId())
                .nom(fournisseur.getNom())
                .zone(fournisseur.getZone())
                .build();
    }
}
