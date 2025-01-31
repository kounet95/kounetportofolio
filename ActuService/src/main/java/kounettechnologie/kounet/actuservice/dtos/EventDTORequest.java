package kounettechnologie.kounet.actuservice.dtos;

import kounettechnologie.kounet.actuservice.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTORequest {
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private String location;
    private Boolean isOnline;
    private Boolean isHighlighted;
    private String registrationLink;
    private List<Tag> tags;
    private String mediaUrls;
}
