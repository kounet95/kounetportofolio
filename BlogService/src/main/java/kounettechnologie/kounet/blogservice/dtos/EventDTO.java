package kounettechnologie.kounet.blogservice.dtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    private Long id;
    private String name;
    private String location;
    private Date date;
    private List<String> mediaUrls;
    private List<Long> tagIds;

}
