package sn.faty.Formation_Spring.dtos.requests;

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
public class CategoryRequest {
    private  String libelle ;

    private TypeCategory typeCategory ;

    public static Category toEntity(CategoryRequest categoryRequest){
        return Category.builder()
                .libelle(categoryRequest.getLibelle())
                .typeCategory(categoryRequest.getTypeCategory())
                .build();
    }
}
