package kounettechnologie.kounet.boutiqueservice.entity;

import jakarta.persistence.*;
import kounettechnologie.kounet.boutiqueservice.Model.Mescategories;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    @Transient
    private Mescategories category;
}

