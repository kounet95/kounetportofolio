package kounettechnologie.kounet.boutiqueservice.dto;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO {
    private Long id;
    private Long productId; // ID du produit
    private String productName; // Nom du produit
    private Integer quantity;
    private Double price;
}


