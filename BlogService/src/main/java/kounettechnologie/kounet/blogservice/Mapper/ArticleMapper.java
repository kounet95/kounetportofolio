package kounettechnologie.kounet.blogservice.Mapper;

import kounettechnologie.kounet.blogservice.dtos.ArticleDTO;
import kounettechnologie.kounet.blogservice.entite.Article;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper {

    public ArticleDTO toArticleDTO(Article article) {
        return new ArticleDTO(
                article.getId(),
                article.getTitle(),
                article.getContent(),
                article.getAuthor(),
                article.isPublished(),
                article.getCreatedAt(),
                article.getUpdatedAt(),
                article.getCategory(),
                article.getComments().stream().map(comment -> comment.getId()).toList()
        );
    }

    public Article fromArticleDTO(ArticleDTO articleDTO) {
        return new Article(
                articleDTO.getId(),
                articleDTO.getTitle(),
                articleDTO.getContent(),
                null, // category set elsewhere
                null, // comments set elsewhere
                articleDTO.getAuthor(),
                articleDTO.isPublished(),
                articleDTO.getCreatedAt(),
                articleDTO.getUpdatedAt()
        );
    }
}

