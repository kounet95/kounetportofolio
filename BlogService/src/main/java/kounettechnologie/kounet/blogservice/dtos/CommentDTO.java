package kounettechnologie.kounet.blogservice.dtos;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private Long id;
    private String content;
    private String author;
    private String createdAt;
    private Long articleId;
}

