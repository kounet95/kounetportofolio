package kounettechnologie.kounet.boutiqueservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String customerEmail;
    private String status; // PENDING, COMPLETED, CANCELLED

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items;
}

