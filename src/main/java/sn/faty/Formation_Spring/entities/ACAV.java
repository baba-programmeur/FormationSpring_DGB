package sn.faty.Formation_Spring.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.faty.Formation_Spring.core.AbstractEntity;


@Entity
@Table(name="articleConfectionArticleVente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ACAV extends AbstractEntity {

    private int quantite ;

    @ManyToOne
    private ArticleConfection articleConfection ;

    @ManyToOne
    private ArticleVente articleVente ;

}
