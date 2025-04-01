package kounettechnologie.kounet.category.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {
    private Long id;
    private String title;
    private String content;
    private boolean published;
    private Long categoryId;
    private String createdAt;
    private String updatedAt;
}

