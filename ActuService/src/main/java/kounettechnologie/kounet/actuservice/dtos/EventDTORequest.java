package kounettechnologie.kounet.actuservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTORequest {
    private Long id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private Boolean isOnline;
    private String registrationLink;
    private List<String> tags;
    private List<String> mediaUrls;
}
