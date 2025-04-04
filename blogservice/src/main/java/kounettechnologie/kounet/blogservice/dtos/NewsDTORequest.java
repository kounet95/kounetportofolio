package kounettechnologie.kounet.blogservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDTORequest {

    private Long id;
    private String content;
    private String title;
    private LocalDate publishedAt;
    private List<String> mediaUrls;

}

