package kounettechnologie.kounet.blogservice.entite;


import jakarta.persistence.*;
import kounettechnologie.kounet.blogservice.Model.Mescategories;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Locale;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

  @Transient
    private Mescategories category;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Comment> comments;

    private String author;
    private boolean published;
    private String createdAt;
    private String updatedAt;
}
