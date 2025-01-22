package kounettechnologie.kounet.actuservice.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter @ToString
@NoArgsConstructor @AllArgsConstructor @SuperBuilder
@Entity
@DiscriminatorValue("ANNONCE")
public class Announcement extends Item {

    private String message;
    private Boolean isHighlighted;
}

