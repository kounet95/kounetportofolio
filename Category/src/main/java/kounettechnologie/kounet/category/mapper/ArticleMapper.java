package kounettechnologie.kounet.category.mapper;



import kounettechnologie.kounet.category.dto.ArticleDTO;
import kounettechnologie.kounet.category.entity.Article;
import kounettechnologie.kounet.category.entity.Mescategories;

import java.util.List;
import java.util.stream.Collectors;

public class ArticleMapper {

    public static ArticleDTO toDTO(Article article) {
        if (article == null) {
            return null;
        }

        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setId(article.getId());
        articleDTO.setTitle(article.getTitle());
        articleDTO.setContent(article.getContent());
        articleDTO.setPublished(article.isPublished());
        articleDTO.setCategoryId(article.getCategory() != null ? article.getCategory().getId() : null);
        articleDTO.setCreatedAt(article.getCreatedAt());
        articleDTO.setUpdatedAt(article.getUpdatedAt());

        return articleDTO;
    }

    public static Article toEntity(ArticleDTO articleDTO, Mescategories category) {
        if (articleDTO == null) {
            return null;
        }

        Article article = new Article();
        article.setId(articleDTO.getId());
        article.setTitle(articleDTO.getTitle());
        article.setContent(articleDTO.getContent());
        article.setPublished(articleDTO.isPublished());
        article.setCategory(category);
        article.setCreatedAt(articleDTO.getCreatedAt());
        article.setUpdatedAt(articleDTO.getUpdatedAt());

        return article;
    }

    public static List<ArticleDTO> toDTOList(List<Article> articles) {
        return articles.stream()
                .map(ArticleMapper::toDTO)
                .collect(Collectors.toList());
    }
}
