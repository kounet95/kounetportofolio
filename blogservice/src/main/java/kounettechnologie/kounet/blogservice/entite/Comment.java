package kounettechnologie.kounet.blogservice.entite;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity

@AllArgsConstructor
@NoArgsConstructor @Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String createdAt;


    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Utilisateur author;


}

