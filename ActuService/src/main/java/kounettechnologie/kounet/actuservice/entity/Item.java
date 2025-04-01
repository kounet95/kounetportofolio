package kounettechnologie.kounet.actuservice.entity;

import jakarta.persistence.*;
import kounettechnologie.kounet.actuservice.menu.ItemType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@DiscriminatorColumn(name = "ITEM",length =4 )
public abstract class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Enum<ItemType> itemType;
    private Date createdAt;
    private Date updatedAt;
    private String title;

    @ManyToMany
@JoinTable(name = "Item_Tag",joinColumns = @JoinColumn(name = "idItem"),
        inverseJoinColumns =@JoinColumn(name="idTag") )
    private List<Tag> tags;
}
