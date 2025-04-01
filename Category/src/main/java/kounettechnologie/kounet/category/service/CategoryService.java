package kounettechnologie.kounet.category.service;


import kounettechnologie.kounet.category.dto.ArticleDTO;
import kounettechnologie.kounet.category.dto.MescategoriesDTO;
import kounettechnologie.kounet.category.entity.Article;
import kounettechnologie.kounet.category.entity.Mescategories;
import kounettechnologie.kounet.category.mapper.ArticleMapper;
import kounettechnologie.kounet.category.mapper.MescategoriesMapper;

import kounettechnologie.kounet.category.repos.ArticleRepository;
import kounettechnologie.kounet.category.repos.MescategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private MescategoriesRepository mescategoriesRepository;

    public ArticleDTO createArticle(ArticleDTO articleDTO) {
        Optional<Mescategories> category = mescategoriesRepository.findById(articleDTO.getCategoryId());
        if (category.isPresent()) {
            Article article = ArticleMapper.toEntity(articleDTO, category.get());
            articleRepository.save(article);
            return ArticleMapper.toDTO(article);
        }
        throw new IllegalArgumentException("Category not found");
    }

    public List<ArticleDTO> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        return ArticleMapper.toDTOList(articles);
    }

    public ArticleDTO getArticleById(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        return article.map(ArticleMapper::toDTO).orElseThrow(() -> new IllegalArgumentException("Article not found"));
    }

    public MescategoriesDTO createCategory(MescategoriesDTO categoryDTO) {
        Mescategories category = MescategoriesMapper.toEntity(categoryDTO);
        mescategoriesRepository.save(category);
        return MescategoriesMapper.toDTO(category);
    }

    public List<MescategoriesDTO> getAllCategories() {
        List<Mescategories> categories = mescategoriesRepository.findAll();
        return MescategoriesMapper.toDTOList(categories);
    }

    public MescategoriesDTO getCategoryById(Long id) {
        Optional<Mescategories> category = mescategoriesRepository.findById(id);
        return category.map(MescategoriesMapper::toDTO).orElseThrow(() -> new IllegalArgumentException("Category not found"));
    }

    public ArticleDTO updateArticle(Long id, ArticleDTO articleDTO) {
        Optional<Article> articleOpt = articleRepository.findById(id);
        if (articleOpt.isPresent()) {
            Optional<Mescategories> category = mescategoriesRepository.findById(articleDTO.getCategoryId());
            if (category.isPresent()) {
                Article article = articleOpt.get();
                article.setTitle(articleDTO.getTitle());
                article.setContent(articleDTO.getContent());
                article.setPublished(articleDTO.isPublished());
                article.setCategory(category.get());
                article.setUpdatedAt(articleDTO.getUpdatedAt());
                articleRepository.save(article);
                return ArticleMapper.toDTO(article);
            }
        }
        throw new IllegalArgumentException("Article or Category not found");
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    public void deleteCategory(Long id) {
        mescategoriesRepository.deleteById(id);
    }
}

