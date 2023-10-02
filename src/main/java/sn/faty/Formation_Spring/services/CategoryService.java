package sn.faty.Formation_Spring.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sn.faty.Formation_Spring.dtos.requests.CategoryRequest;
import sn.faty.Formation_Spring.dtos.requests.FournisseurRequest;
import sn.faty.Formation_Spring.dtos.responses.CategoryResponse;
import sn.faty.Formation_Spring.dtos.responses.FournisseurResponse;

import java.util.Optional;

public interface CategoryService {

    CategoryResponse addCategory(CategoryRequest categoryRequest);

    Page<CategoryResponse> allCategory(Pageable pageable);

    Page<FournisseurResponse> allFournisseurByPage(Pageable pageable);

    CategoryResponse  updateCategory(Long id, CategoryRequest categoryRequest);

   Optional<CategoryResponse> getCategoryById(Long id);

    void deleteCategoryById(Long id);
}
