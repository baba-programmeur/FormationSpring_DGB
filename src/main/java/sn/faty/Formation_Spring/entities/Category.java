package sn.faty.Formation_Spring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.faty.Formation_Spring.core.AbstractEntity;
import sn.faty.Formation_Spring.enums.TypeCategory;
import java.util.List;


@Entity
@Table(name="categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category  extends AbstractEntity {

    private String libelle;

    @Enumerated(value=EnumType.STRING)
    private TypeCategory typeCategory ;

    @OneToMany(mappedBy="category")
    private List<Article> articles ;

    @ManyToMany
    private  List<Fournisseur> fournisseurs ;


}
