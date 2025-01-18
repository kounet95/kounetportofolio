package kounettechnologie.kounet.offresspecialesservice.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OffreSpecialeDTO {
    private Long id;
    private String title;
    private String description;
    private Double discountPercentage;
    private LocalDate startDate;
    private LocalDate endDate;
}

