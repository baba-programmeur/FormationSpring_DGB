package sn.faty.Formation_Spring.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.faty.Formation_Spring.entities.Article;


@Repository
public interface ArticleRepository extends JpaRepository<Article ,Long> {


    Page<Article> findAll(Pageable pageable);
}
