package sn.faty.Formation_Spring.core;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected   Long id ;
    protected boolean etat=true ;

    public AbstractEntity(Long id) {
        this.id = id;
    }
}
