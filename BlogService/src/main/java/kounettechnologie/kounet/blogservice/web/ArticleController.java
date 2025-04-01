package kounettechnologie.kounet.blogservice.web;

import kounettechnologie.kounet.blogservice.dtos.ArticleDTO;
import kounettechnologie.kounet.blogservice.dtos.ArticleDTORequest;
import kounettechnologie.kounet.blogservice.exception.ResourceNotFoundException;
import kounettechnologie.kounet.blogservice.services.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ArticleDTO>> getAllArticles() {
        List<ArticleDTO> articles = articleService.getAllArticles();
        return ResponseEntity.ok(articles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getArticleById(@PathVariable Long id) throws ResourceNotFoundException {
        ArticleDTO article = articleService.getArticleById(id);
        return ResponseEntity.ok(article);
    }

    @PostMapping("add")
    public ResponseEntity<ArticleDTO> createArticle(@RequestBody ArticleDTORequest articleDTORequest) throws ResourceNotFoundException  {
        ArticleDTO article = articleService.createArticle(articleDTORequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(article);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleDTO> updateArticle(@PathVariable Long id, @RequestBody ArticleDTORequest articleDTORequest) throws ResourceNotFoundException  {
        ArticleDTO article = articleService.updateArticle(id, articleDTORequest);
        return ResponseEntity.ok(article);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id)  throws ResourceNotFoundException {
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
}
