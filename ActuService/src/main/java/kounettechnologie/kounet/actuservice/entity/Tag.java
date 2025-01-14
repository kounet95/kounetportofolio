package kounettechnologie.kounet.actuservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<News> news;

    @ManyToMany(mappedBy = "tags")
    private List<Event> events;

    @OneToMany(mappedBy = "tag")
    private List<Announcement> announcements;
}
