package kounettechnologie.kounet.actuservice.dtos;

import jakarta.persistence.*;
import kounettechnologie.kounet.actuservice.entity.ItemType;
import kounettechnologie.kounet.actuservice.entity.Tag;
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
public class ItemDTO {
        private Long id;
        private Enum<ItemType> itemType;
        private String name;
        private Date createdAt;
        private Date updatedAt;
        private String title;
        @ManyToMany
        @JoinTable(name = "Item_Tag",joinColumns = @JoinColumn(name = "idItem"),
                inverseJoinColumns =@JoinColumn(name="idTag") )
        private List<Tag> tags;
    }


