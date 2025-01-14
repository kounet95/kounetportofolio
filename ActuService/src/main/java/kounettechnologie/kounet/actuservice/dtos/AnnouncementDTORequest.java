package kounettechnologie.kounet.actuservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AnnouncementDTORequest {
    private Long id;
    private String message;
    private LocalDate announcementDate;
    private Boolean isHighlighted;
    private String tag;
}
