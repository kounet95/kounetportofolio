package kounettechnologie.kounet.blogservice.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {

    private String title;
    private String content;
    private String author;
    private boolean published;
    private String createdAt;
    private String updatedAt;
    private Long categoryId;
    private List<Long> commentIds;
}

