package kounettechnologie.kounet.actuservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@DiscriminatorValue("EVENT")
public class Event extends Item{


    private String description;

    private Date startDate;

    private Date endDate;

    private String location;

    private Boolean isOnline;

    private String registrationLink;
    private Boolean isHighlighted;
    private String mediaUrls;
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Media> media;
}
