package kounettechnologie.kounet.blogservice.web;

import kounettechnologie.kounet.blogservice.dtos.CategoryDTO;
import kounettechnologie.kounet.blogservice.dtos.CategoryDTORequest;
import kounettechnologie.kounet.blogservice.exception.ResourceNotFoundException;
import kounettechnologie.kounet.blogservice.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {
    private final CategoryService categoryService;

    public CategorieController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("all")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id)  throws ResourceNotFoundException {
        CategoryDTO category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }
        @PostMapping("add")
        public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTORequest categoryDTORequest) {
            CategoryDTO category = categoryService.createCategory(categoryDTORequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(category);
        }

        @PutMapping("/{id}")
        public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, @RequestBody CategoryDTORequest categoryDTORequest)  throws ResourceNotFoundException {
            CategoryDTO category = categoryService.updateCategory(id, categoryDTORequest);
            return ResponseEntity.ok(category);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCategory(@PathVariable Long id)  throws ResourceNotFoundException  {
            categoryService.deleteCategory(id);
            return ResponseEntity.noContent().build();
        }
    }

