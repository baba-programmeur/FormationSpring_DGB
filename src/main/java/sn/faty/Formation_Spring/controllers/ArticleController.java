package sn.faty.Formation_Spring.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.faty.Formation_Spring.dtos.requests.ArticleRequest;
import sn.faty.Formation_Spring.dtos.responses.ArticleResponse;
import sn.faty.Formation_Spring.services.ArticleService;


@RestController
@RequestMapping("/api/article")
@AllArgsConstructor
@Data
@Slf4j
public class ArticleController {

    private final ArticleService articleService ;

    @PostMapping("/add")

    public ResponseEntity<ArticleResponse>  addArticle(@RequestBody ArticleRequest articleRequest) {

           log.info("id*** {}", articleRequest.getCategorie_id(),articleRequest.getLibelle());

        return new ResponseEntity<>(articleService.addArticle(articleRequest), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<ArticleResponse>>  allArticle(Pageable pageable) {

        return ResponseEntity.ok(articleService.allArticleByPage(pageable));
    }
}
