package sn.faty.Formation_Spring.dtos.responses;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.faty.Formation_Spring.entities.ArticleConfection;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleConfectionResponse {

    private  Long id ;

    private String libelle ;

    private int quantiteStock;

    private double prix ;

    private CategoryResponse categoryResponse;

    private  UniteResponse uniteResponse ;

    private  List<FournisseurResponse> fournisseurResponses ;


    public static  ArticleConfectionResponse toDto(ArticleConfection articleConfection){

        return
                ArticleConfectionResponse.builder()
                        .id(articleConfection.getId())
                        .libelle(articleConfection.getLibelle())
                        .quantiteStock(articleConfection.getQuantiteStock())
                        .prix(articleConfection.getPrix())
                        .categoryResponse(CategoryResponse.toDto(articleConfection.getCategory()))
                        .uniteResponse(UniteResponse.toDto(articleConfection.getUnite()))
                        .fournisseurResponses(articleConfection.getFournisseurs().stream().map(FournisseurResponse::toDto).collect(Collectors.toList()))
                        .build();
    }
}
