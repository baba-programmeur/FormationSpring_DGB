package sn.faty.Formation_Spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.faty.Formation_Spring.dtos.requests.CategoryRequest;
import sn.faty.Formation_Spring.dtos.responses.CategoryResponse;
import sn.faty.Formation_Spring.entities.Category;
import sn.faty.Formation_Spring.services.CategoryService;

import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryService categoryService ;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping("/add")
    public ResponseEntity<CategoryResponse> addCategory(@RequestBody CategoryRequest categoryRequest){

        return
                new ResponseEntity<>(categoryService.addCategory(categoryRequest), HttpStatus.CREATED);

    }

    @GetMapping("/all")
    public ResponseEntity<Page<CategoryResponse>> allCategory(Pageable pageable){

        return
                ResponseEntity.ok().body(categoryService.allCategory(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CategoryResponse>> getCategoryById(@PathVariable(name="id") Long id){

        return
                ResponseEntity.ok().body(categoryService.getCategoryById(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryResponse> deleteById(@PathVariable(name="id") Long id){

         categoryService.deleteCategoryById(id);

        return
                new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable(name="id") Long id, CategoryRequest categoryRequest){

          return
                new ResponseEntity<>(categoryService.updateCategory(id,categoryRequest),HttpStatus.CREATED);

    }

}
