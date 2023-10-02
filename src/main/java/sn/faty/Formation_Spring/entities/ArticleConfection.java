package sn.faty.Formation_Spring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="articleConfection")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ArticleConfection extends Article{

    private int quantiteStock;

    @OneToMany(mappedBy="articleConfection")
    private List<ACAV> acav ;
    @ManyToOne
    private Unite unite ;

    @ManyToMany(mappedBy="articleConfections")
    private  List<Fournisseur> fournisseurs ;

   @Builder
    public ArticleConfection(Long id, boolean etat, String libelle, String reference, double prix, Category category, int quantiteStock, List<ACAV> acav, Unite unite, List<Fournisseur> fournisseurs) {
        super(id, etat, libelle, reference, prix, category);
        this.quantiteStock = quantiteStock;
        this.acav = acav;
        this.unite = unite;
        this.fournisseurs = fournisseurs;
    }
}
