package kounettechnologie.kounet.blogservice.Mapper;

import kounettechnologie.kounet.blogservice.dtos.*;
import kounettechnologie.kounet.blogservice.entite.*;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BlogMapper {
    private final ModelMapper modelMapper;

    public BlogMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ArticleDTO toArticleDTO(Article article) {
        ArticleDTO articleDTO = modelMapper.map(article, ArticleDTO.class);
        articleDTO.setAuthor(article.getAuthor().getUsername()); // Mapping author
        articleDTO.setCommentIds(article.getComments().stream().map(Comment::getId).collect(Collectors.toList())); // Mapping comment IDs
        return articleDTO;
    }

    public Article toArticleEntity(ArticleDTORequest articleDTORequest) {
        Article article = modelMapper.map(articleDTORequest, Article.class);
        // Additional mappings if necessary
        return article;
    }

    public CommentDTO toCommentDTO(Comment comment) {
        CommentDTO commentDTO = modelMapper.map(comment, CommentDTO.class);
        commentDTO.setAuthor(comment.getAuthor().getUsername()); // Mapping author
        return commentDTO;
    }

    public Comment toCommentEntity(CommentDTORequest commentDTORequest) {
        Comment comment = modelMapper.map(commentDTORequest, Comment.class);
        // Additional mappings if necessary
        return comment;
    }

    public EventDTO toEventDTO(Event event) {
        return modelMapper.map(event, EventDTO.class);
    }

    public Event toEventEntity(EventDTORequest eventDTORequest) {
        return modelMapper.map(eventDTORequest, Event.class);
    }

    public MediaDTO toMediaDTO(Media media) {
        return modelMapper.map(media, MediaDTO.class);
    }

    public Media toMediaEntity(MediaDTO mediaDTO) {
        return modelMapper.map(mediaDTO, Media.class);
    }

    public NewsDTO toNewsDTO(News news) {
        return modelMapper.map(news, NewsDTO.class);
    }

    public News toNewsEntity(NewsDTORequest newsDTORequest) {
        return modelMapper.map(newsDTORequest, News.class);
    }

    public TagDTO toTagDTO(Tag tag) {
        return modelMapper.map(tag, TagDTO.class);
    }

    public Tag toTagEntity(TagDTORequest tagDTORequest) {
        return modelMapper.map(tagDTORequest, Tag.class);
    }

    public CategoryDTO toCategoryDTO(Category category) {
        CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
        categoryDTO.setArticleIds(category.getArticles().stream().map(Article::getId).collect(Collectors.toList())); // Mapping des IDs des articles
        return categoryDTO;
    }

    public Category toCategoryEntity(CategoryDTORequest categoryDTORequest) {
        Category category = modelMapper.map(categoryDTORequest, Category.class);
        // Additional mappings if necessary
        return category;
    }

    public List<ArticleDTO> toArticleDTOList(List<Article> articles) {
        return articles.stream().map(this::toArticleDTO).collect(Collectors.toList());
    }

    public List<CommentDTO> toCommentDTOList(List<Comment> comments) {
        return comments.stream().map(this::toCommentDTO).collect(Collectors.toList());
    }

    public List<CategoryDTO> toCategoryDTOList(List<Category> categories) {
        return categories.stream().map(this::toCategoryDTO).collect(Collectors.toList());
    }
}
