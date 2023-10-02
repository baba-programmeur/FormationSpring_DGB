package sn.faty.Formation_Spring.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.faty.Formation_Spring.core.AbstractEntity;

import java.util.List;

@Entity
@Table(name="unites")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Unite extends AbstractEntity {

    @Column(nullable = false,unique = true)
    private String libelle;
    @Column(nullable=false,unique = true)
    private String code;

    @OneToMany(mappedBy="unite")
    private List<ArticleConfection> articleConfections ;

    public Unite(Long unite) {
         super(unite);
    }
}
