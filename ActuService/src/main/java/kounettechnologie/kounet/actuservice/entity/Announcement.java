package kounettechnologie.kounet.actuservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private LocalDate announcementDate;
    private String tag;
    private Boolean isHighlighted;
}

