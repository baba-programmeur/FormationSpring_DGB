package sn.faty.Formation_Spring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="articleVente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleVente extends Article {

    @Transient
    private double cout ;

    private boolean promo ;

    @OneToMany(mappedBy="articleVente")
    private List<ACAV> acav ;

}
