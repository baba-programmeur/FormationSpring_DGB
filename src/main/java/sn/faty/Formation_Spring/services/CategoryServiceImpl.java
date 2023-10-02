package sn.faty.Formation_Spring.services;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.faty.Formation_Spring.dtos.requests.CategoryRequest;
import sn.faty.Formation_Spring.dtos.responses.CategoryResponse;
import sn.faty.Formation_Spring.dtos.responses.FournisseurResponse;
import sn.faty.Formation_Spring.entities.Category;
import sn.faty.Formation_Spring.repositories.CategoryRepository;

import java.util.Optional;


@Service
@Transactional
@NoArgsConstructor
@Data
@Slf4j
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository ;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * @param categoryRequest
     * @return
     */
    @Override
    public CategoryResponse addCategory(CategoryRequest categoryRequest) {

  return
          CategoryResponse.toDto(categoryRepository.save(CategoryRequest.toEntity(categoryRequest)));

    }

    /**
     * @param pageable
     * @return
     */
    @Override
    public Page<CategoryResponse> allCategory(Pageable pageable) {

        return
                categoryRepository.findCategoriesByEtatTrue(pageable).map(CategoryResponse::toDto);
    }
    /**
     * @param pageable
     * @return
     */
    @Override
    public Page<FournisseurResponse> allFournisseurByPage(Pageable pageable) {
        return null;
    }

    /**
     * @param id
     * @param categoryRequest
     * @return
     */
    @Override
    public CategoryResponse updateCategory(Long id,CategoryRequest categoryRequest) {

     Optional<Category> categoryExistant= categoryRepository.findById(id);

     log.info("************* categoryExistant *************: {}",categoryExistant);

     if(categoryExistant.isEmpty()){

         throw new RuntimeException("id non existant");
     }

         Category category1=categoryExistant.get();

         category1.setLibelle(categoryRequest.getLibelle());

         category1.setTypeCategory(categoryRequest.getTypeCategory());

          return
                  CategoryResponse.toDto(categoryRepository.save(category1));
    }


    /**
     * @param id
     */
    @Override
    public void deleteCategoryById(Long id) {

        Optional<Category> category=categoryRepository.findById(id);

        Category category1= category.get();

        category1.setEtat(false);

        categoryRepository.save(category1);

    }

    /**
     * @param id
     * @return
     */
    @Override
    public  Optional<CategoryResponse> getCategoryById(Long id) {

      Optional<Category> category=  categoryRepository.findById(id);

          if(category.isEmpty()){

              throw  new RuntimeException("id non trouve ");
          }

        return
                category.map(CategoryResponse::toDto);
    }
}
