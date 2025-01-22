package kounettechnologie.kounet.actuservice.dtos;

import kounettechnologie.kounet.actuservice.entity.Tag;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {

    private String description;
    private Date startDate;
    private Date endDate;
    private String location;
    private Boolean isOnline;
    private String registrationLink;
    private List<Tag> tags;
    private String mediaUrls;
}

