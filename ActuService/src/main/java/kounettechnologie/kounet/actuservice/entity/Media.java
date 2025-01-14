package kounettechnologie.kounet.actuservice.entity;

import jakarta.persistence.*;

@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String url;

    private String description;

    @ManyToOne
    private News news;

    @ManyToOne
    private Event event;
}
