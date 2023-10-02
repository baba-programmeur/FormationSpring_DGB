package sn.faty.Formation_Spring.controllers;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.faty.Formation_Spring.dtos.requests.ArticleConfectionRequest;
import sn.faty.Formation_Spring.dtos.responses.ArticleConfectionResponse;
import sn.faty.Formation_Spring.services.ArticleConfectionService;

@RestController
@RequestMapping("/api/articleConfection")
@Data
public class ArticleConfectionController {

    private  ArticleConfectionService articleConfectionService ;

    @Autowired
    public ArticleConfectionController(ArticleConfectionService articleConfectionService) {
        this.articleConfectionService = articleConfectionService;
    }

    @PostMapping("/add")
    public ResponseEntity<ArticleConfectionResponse> addArticleConfection(ArticleConfectionRequest articleConfectionRequest){
        return
                new ResponseEntity<>(articleConfectionService.add(articleConfectionRequest), HttpStatus.CREATED);

    }




}
