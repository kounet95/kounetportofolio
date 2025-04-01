package kounettechnologie.kounet.category.web;

import kounettechnologie.kounet.category.dto.ArticleDTO;
import kounettechnologie.kounet.category.dto.MescategoriesDTO;
import kounettechnologie.kounet.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/article")
    public ResponseEntity<ArticleDTO> createArticle(@RequestBody ArticleDTO articleDTO) {
        return ResponseEntity.ok(categoryService.createArticle(articleDTO));
    }

    @GetMapping("/articles")
    public ResponseEntity<List<ArticleDTO>> getAllArticles() {
        return ResponseEntity.ok(categoryService.getAllArticles());
    }

    @GetMapping("/article/{id}")
    public ResponseEntity<ArticleDTO> getArticleById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getArticleById(id));
    }

    @PostMapping("/category")
    public ResponseEntity<MescategoriesDTO> createCategory(@RequestBody MescategoriesDTO categoryDTO) {
        return ResponseEntity.ok(categoryService.createCategory(categoryDTO));
    }

    @GetMapping("/categories")
    public ResponseEntity<List<MescategoriesDTO>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<MescategoriesDTO> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @PutMapping("/article/{id}")
    public ResponseEntity<ArticleDTO> updateArticle(@PathVariable Long id, @RequestBody ArticleDTO articleDTO) {
        return ResponseEntity.ok(categoryService.updateArticle(id, articleDTO));
    }

    @DeleteMapping("/article/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        categoryService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}

