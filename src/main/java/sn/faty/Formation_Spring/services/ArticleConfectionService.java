package sn.faty.Formation_Spring.services;

import sn.faty.Formation_Spring.dtos.requests.ArticleConfectionRequest;
import sn.faty.Formation_Spring.dtos.responses.ArticleConfectionResponse;
import sn.faty.Formation_Spring.entities.Article;

public interface ArticleConfectionService {

    Article findArticleConfectionByLibelle(String libelle);

    ArticleConfectionResponse add(ArticleConfectionRequest articleConfectionRequest);

    //ArticleConfectionLoadResponse load();
    ArticleConfectionResponse update(Long id, ArticleConfectionRequest articleConfectionRequest);
}
