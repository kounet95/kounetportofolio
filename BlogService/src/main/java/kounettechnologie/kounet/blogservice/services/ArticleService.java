package kounettechnologie.kounet.blogservice.services;

import kounettechnologie.kounet.blogservice.Mapper.BlogMapper;
import kounettechnologie.kounet.blogservice.dtos.ArticleDTO;
import kounettechnologie.kounet.blogservice.dtos.ArticleDTORequest;
import kounettechnologie.kounet.blogservice.entite.Article;
import kounettechnologie.kounet.blogservice.exception.ResourceNotFoundException;
import kounettechnologie.kounet.blogservice.repos.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final BlogMapper blogMapper;

    public ArticleService(ArticleRepository articleRepository, BlogMapper blogMapper) {
        this.articleRepository = articleRepository;
        this.blogMapper = blogMapper;
    }

    public List<ArticleDTO> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        return blogMapper.toArticleDTOList(articles);
    }

    public ArticleDTO getArticleById(Long id) throws ResourceNotFoundException {
        Article article = articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Article not found"));
        return blogMapper.toArticleDTO(article);
    }

    public ArticleDTO createArticle(ArticleDTORequest articleDTORequest) {
        Article article = blogMapper.toArticleEntity(articleDTORequest);
        article = articleRepository.save(article);
        return blogMapper.toArticleDTO(article);
    }

    public ArticleDTO updateArticle(Long id, ArticleDTORequest articleDTORequest) throws ResourceNotFoundException {
        Article article = articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Article not found"));
        article.setContent(articleDTORequest.getContent());
        article.setTitle(articleDTORequest.getTitle());
        // Update other fields as necessary
        article = articleRepository.save(article);
        return blogMapper.toArticleDTO(article);
    }

    public void deleteArticle(Long id) throws ResourceNotFoundException {
        Article article = articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Article not found"));
        articleRepository.delete(article);
    }
}

