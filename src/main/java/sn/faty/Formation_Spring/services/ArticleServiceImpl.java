package sn.faty.Formation_Spring.services;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.faty.Formation_Spring.dtos.requests.ArticleRequest;
import sn.faty.Formation_Spring.dtos.responses.ArticleResponse;
import sn.faty.Formation_Spring.entities.Category;
import sn.faty.Formation_Spring.repositories.ArticleRepository;
import sn.faty.Formation_Spring.repositories.CategoryRepository;

import java.util.Optional;



@Service
@Transactional
@AllArgsConstructor
public class ArticleServiceImpl  implements  ArticleService{

    private final ArticleRepository articleRepository ;

    private  final CategoryRepository categoryRepository ;

    /**
     * @param articleRequest
     * @return
     */
    @Override
    public ArticleResponse addArticle(ArticleRequest articleRequest) {

         Optional<Category> category= categoryRepository.findById(articleRequest.getCategorie_id().getId());

            if(category.isEmpty()){

                throw  new RuntimeException("idCategorie non existant");
            }

          return  ArticleResponse.toDto(articleRepository.save(ArticleRequest.toEntity(articleRequest)));
    }

    /**
     * @param pageable
     * @return
     */
    @Override
    public Page<ArticleResponse> allArticleByPage(Pageable pageable) {

        return
                articleRepository.findAll(pageable).map(ArticleResponse::toDto);
    }
}
