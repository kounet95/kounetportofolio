package kounettechnologie.kounet.actuservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnnouncementDTO {
    private Long id;
    private String message;
    private LocalDate announcementDate;
    private Boolean isHighlighted;
    private String tag;
}
