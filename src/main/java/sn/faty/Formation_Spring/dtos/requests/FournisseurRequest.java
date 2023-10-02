package sn.faty.Formation_Spring.dtos.requests;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.faty.Formation_Spring.entities.Fournisseur;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FournisseurRequest {


   @Column(nullable = false, unique = true)
    private  String nom ;

   @Column(nullable = false, unique = true)

    private  String zone ;

    public static  Fournisseur toEntity(FournisseurRequest fournisseurRequest){
         return  Fournisseur.builder()
                 .nom(fournisseurRequest.getNom())
                 .zone(fournisseurRequest.getZone())
                 .build();
      }


}
