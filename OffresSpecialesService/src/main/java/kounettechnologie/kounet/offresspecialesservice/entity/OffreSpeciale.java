package kounettechnologie.kounet.offresspecialesservice.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OffreSpeciale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title; // Titre de l'offre

    @Column(nullable = false)
    private String description; // Description de l'offre

    @Column(nullable = false)
    private Double discountPercentage; // Pourcentage de remise

    @Column(nullable = false)
    private LocalDate startDate; // Date de début de l'offre

    @Column(nullable = false)
    private LocalDate endDate; // Date de fin de l'offre
}

