package sn.faty.Formation_Spring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.faty.Formation_Spring.core.AbstractEntity;

@Entity
@Table(name="articles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy =InheritanceType.SINGLE_TABLE)
public class Article extends AbstractEntity {

    protected   String libelle;

    protected   String reference ;

    protected double prix ;

    @ManyToOne
    protected Category category;

    public Article(Long id, boolean etat, String libelle, String reference, double prix, Category category) {
        super(id, etat);
        this.libelle = libelle;
        this.reference = reference;
        this.prix = prix;
        this.category = category;
    }
}
