package kounettechnologie.kounet.blogservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTORequest {
    private Long id;
    private String content;
    private String title;
    private Long authorId;
    private String createdAt;
    private boolean published;
    private String updatedAt;
    private Long categoryId;
    private List<Long> commentIds;

}
