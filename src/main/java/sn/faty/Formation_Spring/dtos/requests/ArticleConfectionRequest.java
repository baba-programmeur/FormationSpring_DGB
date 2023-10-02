package sn.faty.Formation_Spring.dtos.requests;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.faty.Formation_Spring.entities.ArticleConfection;

import sn.faty.Formation_Spring.entities.Unite;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleConfectionRequest{


    private  String libelle ;

    private  double prix ;

    private  int quantiteStock;

    //private  String reference;

    private Long  category_id ;

    private Long unite ;

    private List<Long> fournisseur_id ;



    public  static ArticleConfection toEntity(ArticleConfectionRequest articleConfectionRequest){

        return
                ArticleConfection.builder()
                        .libelle(articleConfectionRequest.getLibelle())
                        .prix(articleConfectionRequest.getPrix())
                        .quantiteStock(articleConfectionRequest.getQuantiteStock())
                        .unite(new Unite(articleConfectionRequest.getUnite()))
                        .build();
    }


}
