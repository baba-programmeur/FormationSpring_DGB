package sn.faty.Formation_Spring.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.faty.Formation_Spring.entities.Fournisseur;



@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

   Page<Fournisseur> findAllByEtat_True(Pageable pageable);
}
