package kounettechnologie.kounet.blogservice.services;

import kounettechnologie.kounet.blogservice.dtos.CategoryDTO;
import kounettechnologie.kounet.blogservice.dtos.CategoryDTORequest;
import kounettechnologie.kounet.blogservice.entite.Category;

import kounettechnologie.kounet.blogservice.Mapper.BlogMapper;
import kounettechnologie.kounet.blogservice.exception.ResourceNotFoundException;
import kounettechnologie.kounet.blogservice.repos.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final BlogMapper blogMapper;

    public CategoryService(CategoryRepository categoryRepository, BlogMapper blogMapper) {
        this.categoryRepository = categoryRepository;
        this.blogMapper = blogMapper;
    }

    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(blogMapper::toCategoryDTO).collect(Collectors.toList());
    }

    public CategoryDTO getCategoryById(Long id)throws ResourceNotFoundException {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        return blogMapper.toCategoryDTO(category);
    }

    public CategoryDTO createCategory(CategoryDTORequest categoryDTORequest) {
        Category category = blogMapper.toCategoryEntity(categoryDTORequest);
        category = categoryRepository.save(category);
        return blogMapper.toCategoryDTO(category);
    }

    public CategoryDTO updateCategory(Long id, CategoryDTORequest categoryDTORequest)throws ResourceNotFoundException {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        category.setName(categoryDTORequest.getName());
        // Update other fields as necessary
        category = categoryRepository.save(category);
        return blogMapper.toCategoryDTO(category);
    }

    public void deleteCategory(Long id)throws ResourceNotFoundException {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        categoryRepository.delete(category);
    }
}
