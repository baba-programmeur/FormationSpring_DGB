package sn.faty.Formation_Spring.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sn.faty.Formation_Spring.dtos.requests.ArticleRequest;
import sn.faty.Formation_Spring.dtos.responses.ArticleResponse;



public interface ArticleService {

  ArticleResponse  addArticle(ArticleRequest articleRequest);

  Page<ArticleResponse> allArticleByPage(Pageable pageable);


}
