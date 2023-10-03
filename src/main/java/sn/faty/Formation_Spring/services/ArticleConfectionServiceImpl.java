package sn.faty.Formation_Spring.services;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.faty.Formation_Spring.dtos.requests.ArticleConfectionRequest;
import sn.faty.Formation_Spring.dtos.responses.ArticleConfectionResponse;
import sn.faty.Formation_Spring.entities.*;
import sn.faty.Formation_Spring.exceptions.EntittyNotFoundException;
import sn.faty.Formation_Spring.exceptions.ErrorCodes;
import sn.faty.Formation_Spring.repositories.ArticleConfectionRepository;
import sn.faty.Formation_Spring.repositories.CategoryRepository;
import sn.faty.Formation_Spring.repositories.FournisseurRepository;
import sn.faty.Formation_Spring.repositories.UniteRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
@NoArgsConstructor
@Slf4j
public class ArticleConfectionServiceImpl implements ArticleConfectionService{

    private  CategoryRepository categoryRepository ;

    private  FournisseurRepository fournisseurRepository ;

    private  UniteRepository uniteRepository ;

    private  ArticleConfectionRepository articleConfectionRepository ;

    @Autowired
    public ArticleConfectionServiceImpl(CategoryRepository categoryRepository, FournisseurRepository fournisseurRepository, UniteRepository uniteRepository, ArticleConfectionRepository articleConfectionRepository) {
        this.categoryRepository = categoryRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.uniteRepository = uniteRepository;
        this.articleConfectionRepository = articleConfectionRepository;
    }

    /**
     * @param libelle
     * @return
     */

    @Override
    public Article findArticleConfectionByLibelle(String libelle) {
        return null;
    }

    /**
     * @param articleConfectionRequest
     * @return
     */
    @Override
    public ArticleConfectionResponse add(ArticleConfectionRequest articleConfectionRequest) {

        Unite unite= checkUniteById(articleConfectionRequest.getUnite());

        Category category=checkCategoryById(articleConfectionRequest.getCategory_id());

           log.debug("category {}",category);

         ArticleConfection articleConfection=ArticleConfectionRequest.toEntity(articleConfectionRequest);

         return
                 save(articleConfectionRequest.getFournisseur_id(),articleConfection,category,unite);
    }
    private  Category checkCategoryById(Long id){

        Optional<Category> categoryOptiona= categoryRepository.findById(id);

          if(categoryOptiona.isEmpty()){

            throw new EntittyNotFoundException("id Categorie non existant", ErrorCodes.CATEGORIE_NOT_FOUND);
          }
        return categoryOptiona.get();
    }

    private  Unite checkUniteById(Long idCategory){

        Optional<Unite> uniteOptional= uniteRepository.findById(idCategory);

        if(uniteOptional.isEmpty()){

            throw new EntittyNotFoundException("id Unite non existant", ErrorCodes.UNITE_NOT_FOUND);
        }

        return uniteOptional.get();
    }

    private ArticleConfectionResponse save(List<Long> idFournisseur, ArticleConfection articleConfection, Category category, Unite unite){

        List<Fournisseur> fournisseurs= idFournisseur.stream().map(idFourn  -> fournisseurRepository.findById(idFourn).orElse(null))
                .filter(fournisseur -> fournisseur != null)
                .collect(Collectors.toList());
         articleConfection.setCategory(category);
         articleConfection.setUnite(unite);
         articleConfection.setFournisseurs(fournisseurs);

        return
                ArticleConfectionResponse.toDto(articleConfectionRepository.save(articleConfection));

    }

    /**
     * @param id
     * @param request
     * @return
     */
    @Override
    public ArticleConfectionResponse update(Long id, ArticleConfectionRequest request) {
        return null;
    }



}


