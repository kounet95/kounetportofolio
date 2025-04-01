package kounettechnologie.kounet.blogservice.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {
    private Long id;
    private String content;
    private String title;
    private String author;
    private String createdAt;
    private boolean published;
    private String updatedAt;
    private Long categoryId;
    private List<Long> commentIds;

}
