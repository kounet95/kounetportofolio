package kounettechnologie.kounet.actuservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDTO {
    private Long id;
    private String title;
    private String content;
    private String category;
    private LocalDate publishedDate;
    private List<String> tags;
    private List<String> mediaUrls;
}

