package kounettechnologie.kounet.blogservice.services;

import kounettechnologie.kounet.blogservice.dtos.ArticleDTO;
import kounettechnologie.kounet.blogservice.dtos.ArticleDTORequest;
import kounettechnologie.kounet.blogservice.dtos.UserDTO;
import kounettechnologie.kounet.blogservice.entite.Article;

import kounettechnologie.kounet.blogservice.Mapper.BlogMapper;
import kounettechnologie.kounet.blogservice.exception.ResourceNotFoundException;
import kounettechnologie.kounet.blogservice.repos.ArticleRepository;
import kounettechnologie.kounet.blogservice.repos.UserClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final BlogMapper blogMapper;
    private final UserClient userClient;

    public ArticleService(ArticleRepository articleRepository, BlogMapper blogMapper, UserClient userClient) {
        this.articleRepository = articleRepository;
        this.blogMapper = blogMapper;
        this.userClient = userClient;
    }

    public List<ArticleDTO> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        return blogMapper.toArticleDTOList(articles);
    }

    public ArticleDTO getArticleById(Long id) throws ResourceNotFoundException{
        Article article = articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Article not found"));
        return blogMapper.toArticleDTO(article);
    }

    public ArticleDTO createArticle(ArticleDTORequest articleDTORequest) {
        Article article = blogMapper.toArticleEntity(articleDTORequest);
        UserDTO user = userClient.getUserById(articleDTORequest.getAuthorId()); // Récupérer l'utilisateur par ID
        article.setAuthor(blogMapper.toUtilisateurEntity(user));
        article = articleRepository.save(article);
        return blogMapper.toArticleDTO(article);
    }

    public ArticleDTO updateArticle(Long id, ArticleDTORequest articleDTORequest) throws ResourceNotFoundException {
        Article article = articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Article not found"));
        article.setContent(articleDTORequest.getContent());
        article.setTitle(articleDTORequest.getTitle());
        UserDTO user = userClient.getUserById(articleDTORequest.getAuthorId()); // Récupérer l'utilisateur par ID
        article.setAuthor(blogMapper.toUtilisateurEntity(user));
        article = articleRepository.save(article);
        return blogMapper.toArticleDTO(article);
    }

    public void deleteArticle(Long id)throws ResourceNotFoundException {
        Article article = articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Article not found"));
        articleRepository.delete(article);
    }
}
