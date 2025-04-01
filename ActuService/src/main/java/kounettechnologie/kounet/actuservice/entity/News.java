package kounettechnologie.kounet.actuservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@DiscriminatorValue("NEWS")
public class News extends Item {


    @Column(length = 1000)
    private String content;

    private String category;

    private LocalDate publishedDate;

    private String imageUrl;


    @OneToMany(mappedBy = "news", cascade = CascadeType.ALL)
    private List<Media> media;
}

