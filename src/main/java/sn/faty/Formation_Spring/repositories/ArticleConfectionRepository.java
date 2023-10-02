package sn.faty.Formation_Spring.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.faty.Formation_Spring.entities.ArticleConfection;

@Repository
public interface ArticleConfectionRepository extends JpaRepository<ArticleConfection, Long> {


}
