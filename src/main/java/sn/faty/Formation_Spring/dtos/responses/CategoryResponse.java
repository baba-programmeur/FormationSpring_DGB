package sn.faty.Formation_Spring.dtos.responses;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.faty.Formation_Spring.entities.Category;
import sn.faty.Formation_Spring.enums.TypeCategory;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponse {

    private  Long id ;
    private  String libelle ;

  //  @Enumerated(EnumType.STRING)
    private TypeCategory typeCategory ;

    public static  CategoryResponse toDto(Category category){
        return
                CategoryResponse.builder()
                        .id(category.getId())
                        .libelle(category.getLibelle())
                        .typeCategory(category.getTypeCategory())
                        .build();
    }
}
