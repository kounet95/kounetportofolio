package kounettechnologie.kounet.actuservice.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@SuperBuilder
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keys;

    @ManyToMany(mappedBy = "tags")
    private List<Item> items;

}
