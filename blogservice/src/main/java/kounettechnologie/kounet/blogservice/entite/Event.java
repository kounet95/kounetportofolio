package kounettechnologie.kounet.blogservice.entite;

import jakarta.persistence.*;

import lombok.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity

@NoArgsConstructor
@AllArgsConstructor @Data @Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private Date date;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Media> mediaList = new ArrayList<>();

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tag> tagList = new ArrayList<>();


}