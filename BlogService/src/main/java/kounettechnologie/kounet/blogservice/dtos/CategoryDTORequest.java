package kounettechnologie.kounet.blogservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTORequest {
    private Long id;
    private String name;
    private List<Long> articleIds; // Mapping des IDs des articles
}
