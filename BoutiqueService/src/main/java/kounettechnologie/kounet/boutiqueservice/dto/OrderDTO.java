package kounettechnologie.kounet.boutiqueservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private String customerName;
    private String customerEmail;
    private String status;
    private List<OrderItemDTO> items;
}
