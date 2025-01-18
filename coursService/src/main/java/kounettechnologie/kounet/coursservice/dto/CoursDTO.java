package kounettechnologie.kounet.coursservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursDTO {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String instructorName;
}
