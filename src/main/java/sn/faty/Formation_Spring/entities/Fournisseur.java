package sn.faty.Formation_Spring.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.faty.Formation_Spring.core.AbstractEntity;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fournisseurs")
@Builder
public class Fournisseur extends AbstractEntity {

    private  String nom ;

    private  String zone ;

    @ManyToMany(mappedBy="fournisseurs")
    private List<Category> categories ;

    @ManyToMany
    private  List<ArticleConfection> articleConfections;


}
