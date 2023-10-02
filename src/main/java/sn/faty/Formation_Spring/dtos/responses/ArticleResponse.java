package sn.faty.Formation_Spring.dtos.responses;

import lombok.Builder;
import lombok.Data;
import sn.faty.Formation_Spring.entities.Article;

@Builder
@Data
public class ArticleResponse {

    private Long id ;

    private String libelle;

    private String reference ;

    private  double prix ;

    public static ArticleResponse  toDto(Article article){

        return
                   ArticleResponse.builder()
                           .id(article.getId())
                           .prix(article.getPrix())
                          .libelle(article.getLibelle())
                          .reference(article.getReference())
                           .build();
    }
}
