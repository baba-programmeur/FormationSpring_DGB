package sn.faty.Formation_Spring.dtos.requests;

import lombok.Builder;
import lombok.Data;

import sn.faty.Formation_Spring.entities.ArticleConfection;
import sn.faty.Formation_Spring.entities.Category;

@Data
@Builder
public class ArticleRequest {

    private  String libelle;

    private  String reference ;

    private  double prix ;

    private Category  categorie_id;

    public  static ArticleConfection toEntity(ArticleRequest articleRequest){

        return
                  ArticleConfection.builder()
                        .libelle(articleRequest.getLibelle())
                        .reference(articleRequest.getReference())
                         .prix(articleRequest.getPrix())
                          .category(articleRequest.getCategorie_id())
                        .build();
    }
}
